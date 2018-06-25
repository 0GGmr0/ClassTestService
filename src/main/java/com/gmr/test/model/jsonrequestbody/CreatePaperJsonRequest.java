package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ProblemsJsonRequest;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: test
 * @description: 教师出试卷的请求json
 * @author: ggmr
 * @create: 2018-06-25 09:49
 */
@Data
public class CreatePaperJsonRequest {
    @JsonProperty("Papername")
    private String paperName;
    @JsonProperty("Problemsnum")
    private Integer problemsNum;
    @JsonProperty("Single")
    private List<ProblemsJsonRequest> single;
    @JsonProperty("Multiple")
    private List<ProblemsJsonRequest> multiple;
    @JsonProperty("Form")
    private List<ProblemsJsonRequest> form;
    @JsonProperty("Judge")
    private List<ProblemsJsonRequest> judge;
}
