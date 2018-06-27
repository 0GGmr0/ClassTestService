package com.gmr.test.service;


import com.gmr.test.dao.ClassMapper;
import com.gmr.test.dao.ClassStudentsMapper;
import com.gmr.test.dao.UserMapper;
import com.gmr.test.model.OV.ClassStudentsInfo;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.OV.StudentAllClassInfo;
import com.gmr.test.model.OV.TeacherClass;
import com.gmr.test.model.entity.*;
import com.gmr.test.model.entity.Class;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.model.jsonrequestbody.JoinClassJsonRequest;
import com.gmr.test.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @description: 班级service
 * @author: ggmr
 * @create: 2018-06-24 19:22
 */
@Service
public class ClassService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ClassMapper classMapper;

    @Resource
    private ClassStudentsMapper classStudentsMapper;

    private final String defaultClassIcon = "http://oukrdttii.bkt.clouddn.com/18-6-24/60283894.jpg";


    /**
     * @Description: 老师创建一个班级
     * @Param: [teacherId, createClassJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    public Result createClass(CreateClassJsonRequest createClassJsonRequest) {
        String teacherId = createClassJsonRequest.getUserId();
        String classIcon = createClassJsonRequest.getClassIcon();
        String className = createClassJsonRequest.getClassName();
        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);
        if(classMapper.selectByExample(classExample).isEmpty()) {
            Class newClass = new Class();
            if(classIcon.length() != 0) {
                newClass.setClassIcon(classIcon);
            } else {
                newClass.setClassIcon(defaultClassIcon);
            }
            newClass.setClassName(className);
            newClass.setStudentNum(0);
            newClass.setTeacherId(teacherId);
            if(classMapper.insert(newClass) == 1) {
                return ResultTool.success();
            } else {
                return ResultTool.error("插入数据失败");
            }
        }
        return ResultTool.error("已存在的班级名");
    }

    /**
     * @Description: 返回一个班级的全部学生信息
     * @Param: [classStudentsJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    public Result classStudentsInformation(String className) {

        //找到班级id
        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);

        List<Class> existClass = classMapper.selectByExample(classExample);
        if(existClass.isEmpty()) {
            return ResultTool.error("不存在这个班级");
        }
        //获取一个班级所有的学生
        ClassStudentsExample classStudentsExample = new ClassStudentsExample();
        classStudentsExample.createCriteria()
                .andClassIdEqualTo(existClass.get(0).getClassId());
        List<ClassStudents> classStudentsList = classStudentsMapper.selectByExample(classStudentsExample);
        if(classStudentsList.isEmpty()) {
            return ResultTool.error("此班级没有学生");
        } else {
            List<ClassStudentsInfo> classStudentsInfoList = new LinkedList<>();
            for(ClassStudents classStudents : classStudentsList) {
                ClassStudentsInfo classStudentsInfo = new ClassStudentsInfo();
                classStudentsInfo.setStudentId(classStudents.getStudentId());
                classStudentsInfo.setStudentName(classStudents.getStudentName());
                classStudentsInfoList.add(classStudentsInfo);
            }
            return ResultTool.success(classStudentsInfoList);
        }
    }

    /**
     * @Description: 返回一个教师有所的班级列表
     * @Param: [teacherId]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-25
     */
    public Result teacherClassList(String teacherId) {

        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andTeacherIdEqualTo(teacherId);
        List<Class> classList = classMapper.selectByExample(classExample);
        if(classList.isEmpty()) {
            return ResultTool.error("该老师没有班级");
        }
        List<TeacherClass> teacherClassList = new LinkedList<>();
        for(Class teacherClass : classList) {
            TeacherClass existClass = new TeacherClass();
            existClass.setTeacherName(teacherClass.getClassName());
            existClass.setClassIcon(teacherClass.getClassIcon());
            teacherClassList.add(existClass);
        }
        return ResultTool.success(teacherClassList);
    }


    /**
     * @Description: 学生加入一个班级
     * @Param: [studentsId, joinClassJsonRequest]
     * @Return: com.gmr.test.model.OV.Result
     * @Author: ggmr
     * @Date: 18-6-26
     */
    public Result joinClass(String studentsId, JoinClassJsonRequest joinClassJsonRequest) {
        String className = joinClassJsonRequest.getClassName();
        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);

        List<Class> existClass = classMapper.selectByExample(classExample);
        if (existClass.isEmpty()) {
            return ResultTool.error("不存在这个班级");
        }
        Class class1 = existClass.get(0);
        class1.setStudentNum(class1.getStudentNum() + 1);
        User student = userMapper.selectByPrimaryKey(studentsId);
        ClassStudents classStudents = new ClassStudents();
        classStudents.setClassId(class1.getClassId());
        classStudents.setStudentId(studentsId);
        classStudents.setStudentName(student.getUserName());
        classStudentsMapper.insert(classStudents);
        classMapper.updateByPrimaryKeySelective(class1);
        return ResultTool.success();
    }

    public Result studentClassList(String studentId) {

        //根据学生id找到所有的加入的班级
        ClassStudentsExample classStudentsExample = new ClassStudentsExample();
        classStudentsExample.createCriteria()
                .andStudentIdEqualTo(studentId);
        List<ClassStudents> classStudentsList = classStudentsMapper
                .selectByExample(classStudentsExample);
        if(classStudentsList.isEmpty()) {
            return ResultTool.error("该学生没有加入任何班级");
        }

        List<StudentAllClassInfo> studentAllClassInfoList = new LinkedList<>();
        for(ClassStudents classStudents : classStudentsList) {
            Integer classId = classStudents.getClassId();
            Class class1 = classMapper.selectByPrimaryKey(classId);
            StudentAllClassInfo studentAllClassInfo = new StudentAllClassInfo();
            studentAllClassInfo.setClassIcon(class1.getClassIcon());
            studentAllClassInfo.setClassName(class1.getClassName());
            User teacher = userMapper.selectByPrimaryKey(class1.getTeacherId());
            studentAllClassInfo.setTeacherName(teacher.getUserName());

            studentAllClassInfoList.add(studentAllClassInfo);
        }

        return ResultTool.success(studentAllClassInfoList);
    }

}
