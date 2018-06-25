package com.gmr.test.model.OV;

import com.gmr.test.model.ResultCode;
import lombok.Data;

/**
 * @program: test
 * @description: 返回的标准格式
 * @author: ggmr
 * @create: 2018-06-24 19:23
 */
@Data
public class Result<T> {
    private ResultCode code;
    private String message;
    private T data;
}
