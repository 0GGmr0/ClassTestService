package com.gmr.test.service;


import com.gmr.test.dao.ClassMapper;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.entity.Class;
import com.gmr.test.model.entity.ClassExample;
import com.gmr.test.model.jsonrequestbody.CreateClassJsonRequest;
import com.gmr.test.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
