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


    @RequestMapping(value = "both/allNotice", method = RequestMethod.GET)
    public Result findAllNotice(HttpServletRequest httpServletRequest,
                            @RequestParam("Classname") String className) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return noticeService.findAllNotice(className);
    }
}
