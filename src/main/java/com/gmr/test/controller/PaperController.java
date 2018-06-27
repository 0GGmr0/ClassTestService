package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.jsonrequestbody.*;
import com.gmr.test.service.PaperService;
import com.gmr.test.tools.JwtUtil;
import com.gmr.test.tools.ResultTool;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @program: test
 * @description: 试卷controller
 * @author: ggmr
 * @create: 2018-06-25 13:07
 */
@RestController
@CrossOrigin
public class PaperController {
    @Resource
    private PaperService paperService;


    /**
     * @Description: 教师出试卷
     * @Param: [httpServletRequest, createPaperJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    @RequestMapping(value = "teacher/newPaper", method = RequestMethod.POST)
    public Result addPaper(HttpServletRequest httpServletRequest,
                           @RequestBody CreatePaperJsonRequest createPaperJsonRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String teacherId = JwtUtil.parseJwt(token);
        return paperService.addPaper(teacherId, createPaperJsonRequest);
    }


    /**
     * @Description: 教师发布试卷
     * @Param: [httpServletRequest, pullPaperJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    @RequestMapping(value = "teacher/postPaper", method = RequestMethod.POST)
    public Result pullPaper(HttpServletRequest httpServletRequest,
                            @RequestBody PullPaperJsonRequest pullPaperJsonRequest) throws ParseException {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String teacherId = JwtUtil.parseJwt(token);
        return paperService.pullPaper(teacherId, pullPaperJsonRequest);
    }

    /**
     * @Description: 教师查看自己的试卷
     * @Param: [httpServletRequest, paperName, problemType]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "teacher/paper", method = RequestMethod.GET)
    public Result pullPaper(HttpServletRequest httpServletRequest,
                            @RequestParam("Papername") String paperName,
                            @RequestParam("Problemtype") Integer problemType) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String teacherId = JwtUtil.parseJwt(token);
        return paperService.teacherFindPaper(teacherId, paperName, problemType);
    }

    /**
     * @Description: 查找一个试卷的限时
     * @Param: [httpServletRequest, paperId]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "both/paperTimeLimit", method = RequestMethod.GET)
    public Result findPaperLimitTime(HttpServletRequest httpServletRequest,
                            @RequestParam("Classname") String className,
                            @RequestParam("Paperid") Integer paperId) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return paperService.findPaperTimeLimit(className, paperId);
    }

    /**
     * @Description: 查看一个班级的所有试卷
     * @Param: [httpServletRequest, className]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "both/allPaper", method = RequestMethod.GET)
    public Result findAllPaper(HttpServletRequest httpServletRequest,
                                     @RequestParam("Classname") String className) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String userId = JwtUtil.parseJwt(token);
        return paperService.findAllPaper(userId, className);
    }

    /**
     * @Description: 学生做题时查看自己的试卷
     * @Param: [httpServletRequest, paperId, problemType]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "student/paper", method = RequestMethod.GET)
    public Result studentsViewPaper(HttpServletRequest httpServletRequest,
                                    @RequestParam("Paperid") Integer paperId,
                                    @RequestParam("Problemtype") Integer problemType) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return paperService.paperInfo(paperId, problemType);
    }

    
    /**
     * @Description: 学生提交试卷
     * @Param: [httpServletRequest, addStudentsJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    @RequestMapping(value = "student/postAnswer", method = RequestMethod.POST)
    public Result addAnswer(HttpServletRequest httpServletRequest,
                            @RequestBody AddStudentsJsonRequest addStudentsJsonRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        String studentId = JwtUtil.parseJwt(token);
        return paperService.addStudentsAnswer(studentId, addStudentsJsonRequest);
    }

    /**
     * @Description: 教师查看班级同学做的试卷的情况
     * @Param: [httpServletRequest, className, paperId]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-27
     */
    @RequestMapping(value = "teacher/paperInformation", method = RequestMethod.GET)
    public Result studentsPaperInfo(HttpServletRequest httpServletRequest,
                                    @RequestParam("Classname") String className,
                                    @RequestParam("Paperid") Integer paperId) throws ParseException {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return paperService.classStudentsPaperInfo(className, paperId);
    }


    @RequestMapping(value = "both/singleProblems", method = RequestMethod.GET)
    public Result studentsPaperInfo(HttpServletRequest httpServletRequest,
                                    @RequestParam("Problemtype") Integer problemType,
                                    @RequestParam("Studentid") String studentId,
                                    @RequestParam("Paperid") Integer paperId) throws ParseException {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            return ResultTool.error("请登录");
        }
        return paperService.findSomeStudentPaperInfo( paperId, studentId, problemType);
    }

}
