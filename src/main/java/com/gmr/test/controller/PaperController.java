package com.gmr.test.controller;

import com.gmr.test.model.OV.Result;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.model.jsonrequestbody.CreatePaperJsonRequest;
import com.gmr.test.model.jsonrequestbody.FindPaperProblemsJsonRequest;
import com.gmr.test.model.jsonrequestbody.PullPaperJsonRequest;
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


}
