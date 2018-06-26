package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 学生加入一个班级
 * @author: ggmr
 * @create: 2018-06-26 18:25
 */
@Data
public class JoinClassJsonRequest {
    @JsonProperty("ClassName")
    String className;
}
