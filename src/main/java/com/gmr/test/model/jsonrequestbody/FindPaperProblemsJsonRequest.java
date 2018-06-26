package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 教师查询自己出的试卷的某一类题目
 * @author: ggmr
 * @create: 2018-06-25 14:54
 */
@Data
public class FindPaperProblemsJsonRequest {
    @JsonProperty("Papername")
    String paperName;
    @JsonProperty("Problemtype")
    Integer problemType;
}
