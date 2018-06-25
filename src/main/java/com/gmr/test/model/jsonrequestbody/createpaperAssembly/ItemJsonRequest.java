package com.gmr.test.model.jsonrequestbody.createpaperAssembly;

import lombok.Data;

/**
 * @program: test
 * @description: 选择题选项的json请求
 * @author: ggmr
 * @create: 2018-06-25 10:08
 */
@Data
public class ItemJsonRequest {
    private String name;
    private String value;
}
