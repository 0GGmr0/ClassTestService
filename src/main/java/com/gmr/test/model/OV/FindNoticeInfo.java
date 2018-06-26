package com.gmr.test.model.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 请求所有的公告接口
 * @author: ggmr
 * @create: 2018-06-26 11:51
 */
@Data
public class FindNoticeInfo {
    @JsonProperty("Id")
    Integer id;
    @JsonProperty("Title")
    String title;
    @JsonProperty("Image")
    String image;
    @JsonProperty("Overview")
    String overview;
    @JsonProperty("PublishTime")
    String publishTime;
}
