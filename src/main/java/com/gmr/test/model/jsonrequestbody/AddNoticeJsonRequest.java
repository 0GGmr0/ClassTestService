package com.gmr.test.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: test
 * @description: 发布公告json请求
 * @author: ggmr
 * @create: 2018-06-26 09:49
 */

@Data
public class AddNoticeJsonRequest {
    @JsonProperty("Classname")
    private String className;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Content")
    private String content;
    @JsonProperty("Image")
    private String image;
}
