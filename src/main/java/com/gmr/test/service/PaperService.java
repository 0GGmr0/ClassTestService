package com.gmr.test.service;

import com.gmr.test.dao.ClassMapper;
import com.gmr.test.dao.PaperMapper;
import com.gmr.test.dao.PaperProblemsMapper;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.entity.Paper;
import com.gmr.test.model.entity.PaperExample;
import com.gmr.test.model.entity.PaperProblems;
import com.gmr.test.model.jsonrequestbody.CreatePaperJsonRequest;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ItemJsonRequest;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ProblemsJsonRequest;
import com.gmr.test.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: test
 * @description: 试卷service
 * @author: ggmr
 * @create: 2018-06-25 09:48
 */
@Service
public class PaperService {
    @Resource
    private PaperMapper paperMapper;

    @Resource
    private PaperProblemsMapper paperProblemsMapper;

    @Resource
    private ClassMapper classMapper;
    /**
     * @Description: 教师出试卷
     * @Param: [teacherId, createPaperJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    public Result addPaper(String teacherId,
                           CreatePaperJsonRequest createPaperJsonRequest) {

        String paperName = createPaperJsonRequest.getPaperName();
        Integer problemsNum = createPaperJsonRequest.getProblemsNum();
        List<ProblemsJsonRequest> singleProblemsList = createPaperJsonRequest.getSingle();
        List<ProblemsJsonRequest> multipleProblemsList = createPaperJsonRequest.getMultiple();
        List<ProblemsJsonRequest> formProblemsList = createPaperJsonRequest.getForm();
        List<ProblemsJsonRequest> judgeProblemsList = createPaperJsonRequest.getJudge();

        //判断这个老师是不是已经出过同名试卷
        PaperExample paperExample = new PaperExample();
        paperExample.createCriteria()
                .andTeacherIdEqualTo(teacherId)
                .andPaperNameEqualTo(paperName);
        if(paperMapper.selectByExample(paperExample).isEmpty()) {
            //数据库插入试卷总表
            Paper paper = new Paper();
            paper.setPaperName(paperName);
            paper.setPaperScore(problemsNum);
            paper.setProbleNum(problemsNum);
            paper.setTeacherId(teacherId);
            paperMapper.insert(paper);

            paperExample.clear();
            paperExample.createCriteria()
                    .andPaperNameEqualTo(paperName);
            Integer paperId = paperMapper.selectByExample(paperExample).get(0).getPaperId();
            //数据库插入单项选择题
            if(singleProblemsList.isEmpty() == false) {
                for (ProblemsJsonRequest problemsJsonRequest : singleProblemsList) {
                    PaperProblems paperProblems = new PaperProblems();
                    paperProblems.setProblemContent(problemsJsonRequest.getProblem());
                    List<ItemJsonRequest> options = problemsJsonRequest.getItems();
                    switch (options.size()) {
                        case 4:
                            paperProblems.setQuestionD(options.get(3).getName() + options.get(3).getValue());
                        case 3:
                            paperProblems.setQuestionC(options.get(2).getName() + options.get(2).getValue());
                        case 2:
                            paperProblems.setQuestionB(options.get(1).getName() + options.get(1).getValue());
                        case 1:
                            paperProblems.setQuestionA(options.get(0).getName() + options.get(0).getValue());
                    }
                    paperProblems.setProblemType(1);
                    paperProblems.setRightAnswer(problemsJsonRequest.getAnswer());
                    paperProblems.setPaperId(paperId);
                    paperProblemsMapper.insert(paperProblems);
                }
            }
            //数据库插入多选题
            if(multipleProblemsList.isEmpty() == false) {
                for (ProblemsJsonRequest problemsJsonRequest : multipleProblemsList) {
                    PaperProblems paperProblems = new PaperProblems();
                    paperProblems.setProblemContent(problemsJsonRequest.getProblem());
                    List<ItemJsonRequest> options = problemsJsonRequest.getItems();
                    switch (options.size()) {
                        case 4:
                            paperProblems.setQuestionD(options.get(3).getName() + options.get(3).getValue());
                        case 3:
                            paperProblems.setQuestionC(options.get(2).getName() + options.get(2).getValue());
                        case 2:
                            paperProblems.setQuestionB(options.get(1).getName() + options.get(1).getValue());
                        case 1:
                            paperProblems.setQuestionA(options.get(0).getName() + options.get(0).getValue());
                    }
                    paperProblems.setProblemType(2);
                    paperProblems.setRightAnswer(problemsJsonRequest.getAnswer());
                    paperProblems.setPaperId(paperId);
                    paperProblemsMapper.insert(paperProblems);
                }
            }
            if(formProblemsList.isEmpty() == false) {
                //数据库插入填空题
                for (ProblemsJsonRequest problemsJsonRequest : formProblemsList) {
                    PaperProblems paperProblems = new PaperProblems();
                    paperProblems.setProblemContent(problemsJsonRequest.getProblem());
                    paperProblems.setProblemType(3);
                    paperProblems.setRightAnswer(problemsJsonRequest.getAnswer());
                    paperProblems.setPaperId(paperId);
                    paperProblemsMapper.insert(paperProblems);
                }
            }
            //数据库插入判断题
            if(judgeProblemsList.isEmpty() == false) {
                for (ProblemsJsonRequest problemsJsonRequest : judgeProblemsList) {
                    PaperProblems paperProblems = new PaperProblems();
                    paperProblems.setProblemContent(problemsJsonRequest.getProblem());
                    paperProblems.setProblemType(4);
                    paperProblems.setRightAnswer(problemsJsonRequest.getAnswer());
                    paperProblems.setPaperId(paperId);
                    paperProblemsMapper.insert(paperProblems);
                }
            }
            return ResultTool.success();
        } else {
            return ResultTool.error("不好意思，您的试卷名和您出的其他试卷的名字重复");
        }
    }
}
