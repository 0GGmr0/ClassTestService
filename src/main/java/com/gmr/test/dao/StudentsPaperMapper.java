package com.gmr.test.dao;

import com.gmr.test.model.entity.StudentsPaper;
import com.gmr.test.model.entity.StudentsPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsPaperMapper {
    int countByExample(StudentsPaperExample example);

    int deleteByExample(StudentsPaperExample example);

    int deleteByPrimaryKey(Integer studentsPaperId);

    int insert(StudentsPaper record);

    int insertSelective(StudentsPaper record);

    List<StudentsPaper> selectByExample(StudentsPaperExample example);

    StudentsPaper selectByPrimaryKey(Integer studentsPaperId);

    int updateByExampleSelective(@Param("record") StudentsPaper record, @Param("example") StudentsPaperExample example);

    int updateByExample(@Param("record") StudentsPaper record, @Param("example") StudentsPaperExample example);

    int updateByPrimaryKeySelective(StudentsPaper record);

    int updateByPrimaryKey(StudentsPaper record);
}