package com.gmr.test.model.jsonrequestbody.createpaperAssembly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: test
 * @description: 判断题和填空题的json请求
 * @author: ggmr
 * @create: 2018-06-25 10:16
 */
@Data
public class ProblemsJsonRequest {
    @JsonProperty("Problem")
    private String problem;
    @JsonProperty("A")
    private String A;
    @JsonProperty("B")
    private String B;
    @JsonProperty("C")
    private String C;
    @JsonProperty("D")
    private String D;
    @JsonProperty("Answer")
    private String answer;
}
