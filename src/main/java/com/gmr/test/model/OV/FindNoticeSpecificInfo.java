package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 查找一个具体的公告的信息
 * @author: ggmr
 * @create: 2018-06-26 12:39
 */
@Data
public class FindNoticeSpecificInfo {
    @JsonProperty("Id")
    Integer id;
    @JsonProperty("Title")
    String title;
    @JsonProperty("Content")
    String content;
    @JsonProperty("Image")
    String image;
    @JsonProperty("Publishtime")
    String publishTime;
}
