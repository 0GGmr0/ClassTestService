package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ItemJsonRequest;
import lombok.Data;

import java.util.List;

/**
 * @program: test
 * @description: 学生做卷子的时候查看自己的卷子
 * @author: ggmr
 * @create: 2018-06-26 21:59
 */
@Data
public class StudentsViewPaper {
    @JsonProperty("Problemid")
    private Integer problemId;
    @JsonProperty("Problemname")
    private String problemName;
    @JsonProperty("Items")
    private List<ItemJsonRequest> items;
}
