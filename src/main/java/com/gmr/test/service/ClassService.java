package com.gmr.test.service;


import com.gmr.test.dao.ClassMapper;
import com.gmr.test.dao.ClassStudentsMapper;
import com.gmr.test.model.OV.ClassStudentsInfo;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.entity.Class;
import com.gmr.test.model.entity.ClassExample;
import com.gmr.test.model.entity.ClassStudents;
import com.gmr.test.model.entity.ClassStudentsExample;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
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
    private ClassMapper classMapper;

    @Resource
    private ClassStudentsMapper classStudentsMapper;
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
            newClass.setClassIcon(classIcon);
            newClass.setClassName(className);
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

}
