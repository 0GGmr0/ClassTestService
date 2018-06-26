package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmr.test.model.jsonrequestbody.answerInfo.AnswerInfo;
import lombok.Data;

import java.util.List;

/**
 * @program: test
 * @description: 学生提交答案
 * @author: ggmr
 * @create: 2018-06-26 22:26
 */
@Data
public class AddStudentsJsonRequest {
    @JsonProperty("Paperid")
    private Integer paperId;
    @JsonProperty("Single")
    private List<AnswerInfo> single;
    @JsonProperty("Multiple")
    private List<AnswerInfo> multiple;
    @JsonProperty("Form")
    private List<AnswerInfo> form;
    @JsonProperty("Judge")
    private List<AnswerInfo> judge;
}
