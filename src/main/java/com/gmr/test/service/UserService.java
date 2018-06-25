package com.gmr.test.service;

import com.gmr.test.dao.UserMapper;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.OV.TokenResponse;
import com.gmr.test.model.entity.User;
import com.gmr.test.model.jsonrequestbody.LoginUser;
import com.gmr.test.tools.AuthTool;
import com.gmr.test.tools.JwtUtil;
import com.gmr.test.tools.ResultTool;
import com.gmr.test.tools.SecurityTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: test
 * @description: 用户service
 * @author: ggmr
 * @create: 2018-06-25 07:33
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 正则匹配
     */
    private static Pattern pattern = Pattern.compile("10.*?");

    /**
     * @Description: 登录接口
     * @Param: [user]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    public Result login(LoginUser user) {
        if (user == null || user.getUid() == null || "".equals(user.getUid()) || user.getPassword() == null || "".equals(user.getPassword())) {
            return ResultTool.error("账号或密码不能为空");
        }
        // 首先验证数据库中有没有该用户
        User existedUser = userMapper.selectByPrimaryKey(user.getUid());
        if (existedUser != null) {
            try {
                if (existedUser.getPassword().equals(SecurityTool.encodeByMd5(user.getPassword()))) {
                    //密码正确
                    TokenResponse response = new TokenResponse();
                    response.setToken(JwtUtil.createJwt(user.getUid()));
                    response.setIdentity(existedUser.getIdentity());
                    return ResultTool.success(response);
                } else if (!existedUser.getPassword().equals(SecurityTool.encodeByMd5(user.getPassword()))) {
                    // 如果用户在上海大学端更改了密码，我们访问接口进行验证，通过则更新数据库中用户的密码
                    if (AuthTool.getAuth(user.getUid(), user.getPassword())) {
                        User record = new User();
                        record.setUserId(user.getUid());
                        record.setPassword(SecurityTool.encodeByMd5(user.getPassword()));
                        userMapper.updateByPrimaryKeySelective(record);
                        TokenResponse response = new TokenResponse();
                        response.setToken(JwtUtil.createJwt(user.getUid()));
                        response.setIdentity(existedUser.getIdentity());
                        return ResultTool.success(response);

                    } else {
                        return ResultTool.error("账号密码错误");
                    }
                } else {
                    return ResultTool.error("您没有权限登录该系统");
                }
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                return ResultTool.error(e.getMessage());
            }
        } else {
            // 请求上海大学登陆接口查看有没有该用户，有的话该用户进入我们的数据库，没有的话返回登陆失败的信息
            if (AuthTool.getAuth(user.getUid(), user.getPassword())) {
                User systemUser = AuthTool.getInfo(user.getUid());
                assert systemUser != null;
                systemUser.setUserId(user.getUid());
                try {
                    systemUser.setPassword(SecurityTool.encodeByMd5(user.getPassword()));
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                    return ResultTool.error(e.getMessage());
                }
                Matcher matcher = pattern.matcher(user.getUid());
                TokenResponse response = new TokenResponse();
                if(matcher.find()) {
                    systemUser.setIdentity(1);
                    response.setIdentity(1);
                } else {
                    systemUser.setIdentity(2);
                    response.setIdentity(2);
                }
                userMapper.insertSelective(systemUser);
                response.setToken(JwtUtil.createJwt(user.getUid()));

                return ResultTool.success(response);
            } else {
                return ResultTool.error("您不是上海大学的用户");
            }
        }
    }
}
