package com.gmr.test.dao;

import com.gmr.test.model.entity.StudentsAnswer;
import com.gmr.test.model.entity.StudentsAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsAnswerMapper {
    int countByExample(StudentsAnswerExample example);

    int deleteByExample(StudentsAnswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentsAnswer record);

    int insertSelective(StudentsAnswer record);

    List<StudentsAnswer> selectByExample(StudentsAnswerExample example);

    StudentsAnswer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentsAnswer record, @Param("example") StudentsAnswerExample example);

    int updateByExample(@Param("record") StudentsAnswer record, @Param("example") StudentsAnswerExample example);

    int updateByPrimaryKeySelective(StudentsAnswer record);

    int updateByPrimaryKey(StudentsAnswer record);
}