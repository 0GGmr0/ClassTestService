package com.gmr.test.dao;

import com.gmr.test.model.entity.PaperProblems;
import com.gmr.test.model.entity.PaperProblemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperProblemsMapper {
    int countByExample(PaperProblemsExample example);

    int deleteByExample(PaperProblemsExample example);

    int deleteByPrimaryKey(Integer problemId);

    int insert(PaperProblems record);

    int insertSelective(PaperProblems record);

    List<PaperProblems> selectByExample(PaperProblemsExample example);

    PaperProblems selectByPrimaryKey(Integer problemId);

    int updateByExampleSelective(@Param("record") PaperProblems record, @Param("example") PaperProblemsExample example);

    int updateByExample(@Param("record") PaperProblems record, @Param("example") PaperProblemsExample example);

    int updateByPrimaryKeySelective(PaperProblems record);

    int updateByPrimaryKey(PaperProblems record);
}