package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.model.jsonrequestbody.JoinClassJsonRequest;
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

    /**
     * @Description: 返回教师自己创建的班级列表
     * @Param: [httpServletRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    @RequestMapping(value = "teacher/allClass",method = RequestMethod.GET)
    public Result teacherClassList(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String teacherId = JwtUtil.parseJwt(token);
        return classService.teacherClassList(teacherId);
    }

    /**
     * @Description: 学生加入一个班级
     * @Param: [httpServletRequest, joinClassJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "student/joinClass",method = RequestMethod.POST)
    public Result joinClass(HttpServletRequest httpServletRequest,
                            @RequestBody JoinClassJsonRequest joinClassJsonRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String studentId = JwtUtil.parseJwt(token);
        return classService.joinClass(studentId, joinClassJsonRequest);
    }

}
