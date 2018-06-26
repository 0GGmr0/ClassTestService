package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 某个学生加入的所有班级列表
 * @author: ggmr
 * @create: 2018-06-26 18:46
 */
@Data
public class StudentAllClassInfo {
     @JsonProperty("Classname")
     String className;
     @JsonProperty("Teachername")
     String teacherName;
     @JsonProperty("Studentnumber")
     Integer studentnumber;
     @JsonProperty("Classicon")
     String classIcon;
}
