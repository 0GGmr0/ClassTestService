package com.gmr.test.dao;

import com.gmr.test.model.entity.PaperForClass;
import com.gmr.test.model.entity.PaperForClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperForClassMapper {
    int countByExample(PaperForClassExample example);

    int deleteByExample(PaperForClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaperForClass record);

    int insertSelective(PaperForClass record);

    List<PaperForClass> selectByExample(PaperForClassExample example);

    PaperForClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaperForClass record, @Param("example") PaperForClassExample example);

    int updateByExample(@Param("record") PaperForClass record, @Param("example") PaperForClassExample example);

    int updateByPrimaryKeySelective(PaperForClass record);

    int updateByPrimaryKey(PaperForClass record);
}