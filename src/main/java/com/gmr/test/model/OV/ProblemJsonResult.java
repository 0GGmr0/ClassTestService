package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ItemJsonRequest;
import lombok.Data;

import java.util.List;

/**
 * @program: test
 * @description: 与problemJsonRequest同原理
 * @author: ggmr
 * @create: 2018-06-27 21:42
 */
@Data
public class ProblemJsonResult {
    @JsonProperty("Problemname")
    private String problem;
    @JsonProperty("Items")
    private List<ItemJsonRequest> items;
    @JsonProperty("Answer")
    private String answer;
}
