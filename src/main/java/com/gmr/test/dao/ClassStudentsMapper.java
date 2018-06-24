package com.gmr.test.dao;

import com.gmr.test.model.entity.ClassStudents;
import com.gmr.test.model.entity.ClassStudentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassStudentsMapper {
    int countByExample(ClassStudentsExample example);

    int deleteByExample(ClassStudentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassStudents record);

    int insertSelective(ClassStudents record);

    List<ClassStudents> selectByExample(ClassStudentsExample example);

    ClassStudents selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassStudents record, @Param("example") ClassStudentsExample example);

    int updateByExample(@Param("record") ClassStudents record, @Param("example") ClassStudentsExample example);

    int updateByPrimaryKeySelective(ClassStudents record);

    int updateByPrimaryKey(ClassStudents record);
}