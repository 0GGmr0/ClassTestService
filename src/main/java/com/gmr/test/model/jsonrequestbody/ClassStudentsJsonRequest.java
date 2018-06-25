package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 请求返回班级所有学生信息的请求json
 * @author: ggmr
 * @create: 2018-06-25 09:04
 */
@Data
public class ClassStudentsJsonRequest {
    @JsonProperty("Classname")
    private String className;
}
