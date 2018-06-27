package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.OV.TokenResponse;
import com.gmr.test.model.jsonrequestbody.LoginUser;
import com.gmr.test.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: test
 * @description: 登录接口
 * @author: ggmr
 * @create: 2018-06-25 07:33
 */
@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * @Description: 登录接口
     * @Param: [loginUser]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public Result login(@RequestBody LoginUser loginUser) {
//        return userService.login(loginUser);
//    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result login(@RequestParam("uid") String uid,
                        @RequestParam("password") String password) {
        return userService.login(uid, password);
    }
}
