package com.gmr.test.model.OV;

import lombok.Data;

/**
 * @program: test
 * @description: 登录返回json
 * @author: ggmr
 * @create: 2018-06-25 07:36
 */
@Data
public class TokenResponse {
    private Integer identity;
    private String token;
}
