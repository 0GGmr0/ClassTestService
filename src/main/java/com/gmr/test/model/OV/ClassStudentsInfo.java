package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 返回班级学生列表的一个单独信息
 * @author: ggmr
 * @create: 2018-06-25 09:17
 */
@Data
public class ClassStudentsInfo {

    @JsonProperty("Studentname")
    private String studentName;

    @JsonProperty("Studentid")
    private String studentId;
}
