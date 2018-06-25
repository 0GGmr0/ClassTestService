package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 创建班级时的请求json
 * @author: ggmr
 * @create: 2018-06-25 07:13
 */
@Data
public class CreateClassJsonRequest {
    @JsonProperty("Userid")
    private String userId;
    @JsonProperty("Classname")
    private String className;
    @JsonProperty("Classicon")
    private String classIcon;
}
