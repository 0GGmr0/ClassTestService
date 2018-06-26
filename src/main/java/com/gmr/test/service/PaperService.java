package com.gmr.test.service;

import com.gmr.test.dao.ClassMapper;
import com.gmr.test.dao.PaperForClassMapper;
import com.gmr.test.dao.PaperMapper;
import com.gmr.test.dao.PaperProblemsMapper;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.OV.TimeLimitInfo;
import com.gmr.test.model.entity.*;
import com.gmr.test.model.entity.Class;
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
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
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

        if(singleProblemsList.isEmpty() && multipleProblemsList.isEmpty() &&
                formProblemsList.isEmpty() && judgeProblemsList.isEmpty()) {
            return ResultTool.error("试卷为空");
        }
        //判断这个老师是不是已经出过同名试卷
        PaperExample paperExample = new PaperExample();
        paperExample.createCriteria()
                .andTeacherIdEqualTo(teacherId)
                .andPaperNameEqualTo(paperName);
        //老师没有出过同名试卷
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

            //因为前端给我的题目的第一个总是空的，所以我这边用一个count来计数，把第一个舍弃
            int count = 0;
            //数据库插入单项选择题
            if(singleProblemsList.isEmpty() == false) {
                for (ProblemsJsonRequest problemsJsonRequest : singleProblemsList) {
                    if(count == 0) {
                        count++;
                        continue;
                    }
                    PaperProblems paperProblems = new PaperProblems();
                    paperProblems.setProblemContent(problemsJsonRequest.getProblem());
                    List<ItemJsonRequest> options = problemsJsonRequest.getItems();
                    switch (options.size()) {
                        case 4:
                            paperProblems.setQuestionD(options.get(3).getValue());
                        case 3:
                            paperProblems.setQuestionC(options.get(2).getValue());
                        case 2:
                            paperProblems.setQuestionB(options.get(1).getValue());
                        case 1:
                            paperProblems.setQuestionA(options.get(0).getValue());
                    }
                    paperProblems.setChoiceNum(options.size());
                    paperProblems.setProblemType(1);
                    paperProblems.setRightAnswer(problemsJsonRequest.getAnswer());
                    paperProblems.setPaperId(paperId);
                    paperProblemsMapper.insert(paperProblems);
                }
            }
            //数据库插入多选题
            if(multipleProblemsList.isEmpty() == false) {
                count = 0;
                for (ProblemsJsonRequest problemsJsonRequest : multipleProblemsList) {
                    if(count == 0) {
                        count++;
                        continue;
                    }
                    PaperProblems paperProblems = new PaperProblems();
                    paperProblems.setProblemContent(problemsJsonRequest.getProblem());
                    List<ItemJsonRequest> options = problemsJsonRequest.getItems();
                    switch (options.size()) {
                        case 4:
                            paperProblems.setQuestionD(options.get(3).getValue());
                        case 3:
                            paperProblems.setQuestionC(options.get(2).getValue());
                        case 2:
                            paperProblems.setQuestionB(options.get(1).getValue());
                        case 1:
                            paperProblems.setQuestionA(options.get(0).getValue());
                    }
                    paperProblems.setChoiceNum(options.size());
                    paperProblems.setProblemType(2);
                    paperProblems.setRightAnswer(problemsJsonRequest.getAnswer());
                    paperProblems.setPaperId(paperId);
                    paperProblemsMapper.insert(paperProblems);
                }
            }

            //数据库插入填空题
            if(formProblemsList.isEmpty() == false) {
                count = 0;
                for (ProblemsJsonRequest problemsJsonRequest : formProblemsList) {
                    if(count == 0) {
                        count++;
                        continue;
                    }
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
                count = 0;
                for (ProblemsJsonRequest problemsJsonRequest : judgeProblemsList) {
                    if(count == 0) {
                        count++;
                        continue;
                    }
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

    /**
     * @Description: 把String类型的时间转换成Date类型
     * @Param: [strDate]
     * @Return: java.util.Date
     * @Author: ggmr
     * @Date: 18-6-26
     */
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

    /**
     * @Description: 教师查看自己出的试卷
     * @Param: [teacherId, findPaperProblemsJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    public Result teacherFindPaper(String teacherId, String paperName, Integer problemType) {
        Paper paper = findPaperByName(teacherId, paperName);
        if(paper == null) {
            return ResultTool.error("您没有这个名字的试卷");
        }
        //查找到满足条件的所有题目
        PaperProblemsExample paperProblemsExample = new PaperProblemsExample();
        paperProblemsExample.createCriteria()
                .andPaperIdEqualTo(paper.getPaperId())
                .andProblemTypeEqualTo(problemType);
        List<PaperProblems> paperProblemsList = paperProblemsMapper
                                    .selectByExample(paperProblemsExample);
        if(paperProblemsList.isEmpty()) {
            return ResultTool.error("您没有出这类型的题目");
        }
        List<ProblemsJsonRequest> problemsJsonRequestList = new LinkedList<>();
        for(PaperProblems paperProblem : paperProblemsList) {
            ProblemsJsonRequest problemsJsonRequest = new ProblemsJsonRequest();
            problemsJsonRequest.setProblem(paperProblem.getProblemContent());
            problemsJsonRequest.setAnswer(paperProblem.getRightAnswer());

            //如果是选择题，那么会有这个items选项
            if(problemType == 1 || problemType == 2) {
                List<ItemJsonRequest> itemJsonRequestList = new LinkedList<>();
                switch (paperProblem.getChoiceNum()) {
                    case 4 : {
                        ItemJsonRequest itemJsonRequestD = new ItemJsonRequest();
                        itemJsonRequestD.setValue(paperProblem.getQuestionD());
                        itemJsonRequestD.setName("D");
                        itemJsonRequestList.add(itemJsonRequestD);
                    }
                    case 3 : {
                        ItemJsonRequest itemJsonRequestC = new ItemJsonRequest();
                        itemJsonRequestC.setValue(paperProblem.getQuestionC());
                        itemJsonRequestC.setName("C");
                        itemJsonRequestList.add(itemJsonRequestC);
                    }
                    case 2 : {
                        ItemJsonRequest itemJsonRequestB = new ItemJsonRequest();
                        itemJsonRequestB.setValue(paperProblem.getQuestionB());
                        itemJsonRequestB.setName("B");
                        itemJsonRequestList.add(itemJsonRequestB);
                    }
                    case 1 : {
                        ItemJsonRequest itemJsonRequestA = new ItemJsonRequest();
                        itemJsonRequestA.setValue(paperProblem.getQuestionA());
                        itemJsonRequestA.setName("A");
                        itemJsonRequestList.add(itemJsonRequestA);
                    }
                }
                Collections.reverse(itemJsonRequestList);
                problemsJsonRequest.setItems(itemJsonRequestList);
            }
            problemsJsonRequestList.add(problemsJsonRequest);
        }
        return ResultTool.success(problemsJsonRequestList);

    }

    /**
     * @Description: 查找一个试卷的时间限制
     * @Param: [className, paperId]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    public Result findPaperTimeLimit(String className, Integer paperId) {

        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);

        List<Class> existClass = classMapper.selectByExample(classExample);
        if(existClass.isEmpty()) {
            return ResultTool.error("不存在这个班级");
        }

        PaperForClassExample paperForClassExample = new PaperForClassExample();
        paperForClassExample.createCriteria()
                .andClassIdEqualTo(existClass.get(0).getClassId())
                .andPapperIdEqualTo(paperId);
        List<PaperForClass> paperList = paperForClassMapper.selectByExample(paperForClassExample);
        if(paperList.isEmpty()) {
            return ResultTool.error("这个班级没有发布id为这个号码的试卷");
        }
        TimeLimitInfo timeLimitInfo = new TimeLimitInfo();
        timeLimitInfo.setLimitTime(paperList.get(0).getLimitTime());
        return ResultTool.success(timeLimitInfo);
    }

    public Result teacherFindAllPaper(String className) {
        return null;
    }

}
