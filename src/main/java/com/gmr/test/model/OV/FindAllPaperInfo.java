package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 查找一个班级的所有的试卷
 * @author: ggmr
 * @create: 2018-06-26 21:00
 */
@Data
public class FindAllPaperInfo {
    @JsonProperty("Paperid")
    private Integer paperId;
    @JsonProperty("Papername")
    private String paperName;
    @JsonProperty("Deadline")
    private String deadline;
    @JsonProperty("Status")
    private Integer status;
}
