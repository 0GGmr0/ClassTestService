package com.gmr.test.service;

import com.gmr.test.dao.ClassMapper;
import com.gmr.test.dao.PaperForClassMapper;
import com.gmr.test.dao.PaperMapper;
import com.gmr.test.dao.PaperProblemsMapper;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.entity.*;
import com.gmr.test.model.jsonrequestbody.CreatePaperJsonRequest;
import com.gmr.test.model.jsonrequestbody.PullPaperJsonRequest;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ItemJsonRequest;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ProblemsJsonRequest;
import com.gmr.test.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private PaperForClassMapper paperForClassMapper;

    @Resource
    private ClassMapper classMapper;

    /**
     * @Description: 通过试卷名查找试卷
     * @Param: [paperName]
     * @Return: com.gmr.test.model.entity.Paper
     * @Author: ggmr
     * @Date: 18-6-25
     */
    private Paper findPaperByName(String teacherId, String paperName) {
        PaperExample paperExample = new PaperExample();
        paperExample.createCriteria()
                .andTeacherIdEqualTo(teacherId)
                .andPaperNameEqualTo(paperName);
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        if(paperList.isEmpty()) {
            return null;
        } else {
            return paperList.get(0);
        }
    }

    /**
     * @Description: 根据班级名查找班级
     * @Param: [className]
     * @Return: com.gmr.test.model.entity.Class
     * @Author: ggmr
     * @Date: 18-6-25
     */
    private com.gmr.test.model.entity.Class findClassByName(String className) {
        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);
        List<com.gmr.test.model.entity.Class> classList = classMapper.selectByExample(classExample);
        if(classList.isEmpty()) {
            return null;
        } else {
            return classList.get(0);
        }
    }



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

    private Date stringToDate(String strDate) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return fmt.parse(strDate);
    }



    /**
     * @Description: 教师发布试卷
     * @Param: [pullPaperJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    public Result pullPaper(String teacherId,
                            PullPaperJsonRequest pullPaperJsonRequest) throws ParseException {
        String className = pullPaperJsonRequest.getClassName();
        String paperName = pullPaperJsonRequest.getPaperName();
        Date deadline = stringToDate(pullPaperJsonRequest.getDeadline());
        String limitTime = pullPaperJsonRequest.getLimitTime();
        PaperForClass paperForClass = new PaperForClass();
        Paper paper = findPaperByName(teacherId, paperName);
        if(paper == null) {
            return ResultTool.error("您没有这张试卷");
        }
        paperForClass.setPapperId(paper.getPaperId());
        paperForClass.setDeadline(deadline);

        com.gmr.test.model.entity.Class existClass = findClassByName(className);
        if(existClass == null) {
            return ResultTool.error("您没有这个名字的班级");
        }
        paperForClass.setClassId(existClass.getClassId());
        paperForClass.setLimitTime(limitTime);
        paperForClass.setTeacherId(teacherId);
        paperForClassMapper.insert(paperForClass);
        return ResultTool.success();
    }

}
