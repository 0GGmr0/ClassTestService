package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 学生做的试卷情况
 * @author: ggmr
 * @create: 2018-06-26 23:57
 */
@Data
public class StudentsPaperSituationsInfo {
    @JsonProperty("Studentid")
    private String studentId;
    @JsonProperty("Studentname")
    private String studentName;
    @JsonProperty("Correctionrate")
    private String correctionRate;
}
