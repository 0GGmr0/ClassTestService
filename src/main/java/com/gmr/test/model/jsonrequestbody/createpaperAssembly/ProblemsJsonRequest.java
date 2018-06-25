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
    @JsonProperty("Items")
    private List<ItemJsonRequest> items;
    @JsonProperty("Answer")
    private String answer;
}
