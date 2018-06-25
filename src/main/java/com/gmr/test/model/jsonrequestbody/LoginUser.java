package com.gmr.test.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: test
 * @description: 登录请求json
 * @author: ggmr
 * @create: 2018-06-25 07:35
 */
@Data
public class LoginUser {
    private String uid;
    private String password;
}
