package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmr.test.model.jsonrequestbody.createpaperAssembly.ItemJsonRequest;
import lombok.Data;

import java.util.List;

/**
 * @program: test
 * @description: 查看一个同学试卷做的具体情况
 * @author: ggmr
 * @create: 2018-06-27 00:36
 */
@Data
public class FindSomeStudentsPaperInfo {
    @JsonProperty("Problem")
    String problem;
    @JsonProperty("Items")
    List<ItemJsonRequest> items;
    @JsonProperty("Studentanswer")
    String studentAnswer;
    @JsonProperty("Rightanswer")
    String rightAnswer;
    @JsonProperty("Iscorrect")
    Integer isCorrect;
}
