package com.gmr.test.model.jsonrequestbody.answerInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 学生提交试卷的具体内容
 * @author: ggmr
 * @create: 2018-06-26 22:30
 */
@Data
public class AnswerInfo {
    @JsonProperty("Problemid")
    private Integer problemId;
    @JsonProperty("Answer")
    private String answer;
}
