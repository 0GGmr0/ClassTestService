package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.service.ClassService;
import com.gmr.test.tools.JwtUtil;
import com.gmr.test.tools.ResultTool;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: test
 * @description: 班级controller
 * @author: ggmr
 * @create: 2018-06-25 07:21
 */
@RestController
@CrossOrigin
public class ClassController {

    @Resource
    private ClassService classService;

    @RequestMapping(value = "teacher/newClass",method = RequestMethod.POST)
    public Result createClass(HttpServletRequest httpServletRequest,
                              @RequestBody CreateClassJsonRequest createClassJsonRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
//        String teacherId = JwtUtil.parseJwt(token);
        return classService.createClass(createClassJsonRequest);
    }

}