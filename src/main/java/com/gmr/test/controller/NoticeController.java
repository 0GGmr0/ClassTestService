package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.jsonrequestbody.AddNoticeJsonRequest;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.service.NoticeService;
import com.gmr.test.tools.JwtUtil;
import com.gmr.test.tools.ResultTool;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: test
 * @description: 公告controller
 * @author: ggmr
 * @create: 2018-06-26 11:30
 */
@RestController
@CrossOrigin
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    /**
     * @Description: 增加一个公告
     * @Param: [httpServletRequest, addNoticeJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "teacher/newNotice", method = RequestMethod.POST)
    public Result addNotice(HttpServletRequest httpServletRequest,
                            @RequestBody AddNoticeJsonRequest addNoticeJsonRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String teacherId = JwtUtil.parseJwt(token);
        return noticeService.addNotice(teacherId, addNoticeJsonRequest);
    }


    /**
     * @Description: 查询所有的公告
     * @Param: [httpServletRequest, className]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "both/allNotice", method = RequestMethod.GET)
    public Result findAllNotice(HttpServletRequest httpServletRequest,
                            @RequestParam("Classname") String className) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return noticeService.findAllNotice(className);
    }

    @RequestMapping(value = "both/someNotice", method = RequestMethod.GET)
    public Result findAllNotice(HttpServletRequest httpServletRequest,
                                @RequestParam("Classname") String className,
                                @RequestParam("Noticename") String noticename) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return noticeService.findSomeNotice(className, noticename);
    }
}
