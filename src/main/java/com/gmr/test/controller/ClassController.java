package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.service.ClassService;
import com.gmr.test.tools.JwtUtil;
import com.gmr.test.tools.ResultTool;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
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

    /**
     * @Description: 创建一个班级
     * @Param: [httpServletRequest, createClassJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
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

    /**
     * @Description: 查看一个班级的学生信息列表
     * @Param: [httpServletRequest, className]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    @RequestMapping(value = "both/studentInformation",method = RequestMethod.GET)
    public Result classStudentsInfoList(HttpServletRequest httpServletRequest,
                                        @RequestParam(value = "Classname") String className) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return classService.classStudentsInformation(className);
    }

}
