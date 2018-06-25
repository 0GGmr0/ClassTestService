package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 老师的班级列表
 * @author: ggmr
 * @create: 2018-06-25 13:42
 */
@Data
public class TeacherClass {
    @JsonProperty("Classicon")
    private String classIcon;
    @JsonProperty("Teachername")
    private String teacherName;
}
