package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: test
 * @description: 教师发布试卷请求json
 * @author: ggmr
 * @create: 2018-06-25 14:04
 */
@Data
public class PullPaperJsonRequest {
    @JsonProperty("Classname")
    private String className;
    @JsonProperty("Papername")
    private String paperName;
    @JsonProperty("Deadline")
    private String deadline;
    @JsonProperty("Limittime")
    private String limitTime;
}
