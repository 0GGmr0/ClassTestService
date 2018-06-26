package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: test
 * @description: 教师查看学生做题的情况的整体类
 * @author: ggmr
 * @create: 2018-06-27 00:04
 */
@Data
public class StudentsPaperSituations {
    @JsonProperty("Allcorrection")
    private String allCorrection;
    @JsonProperty("Situations")
    private List<StudentsPaperSituationsInfo> situations;
}
