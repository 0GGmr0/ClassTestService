package com.gmr.test.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: test
 * @description:
 * @author: ggmr
 * @create: 2018-06-21 14:28
 */
@RestController
@CrossOrigin
public class Test {
    @RequestMapping("test")
    public String sssest() {
        return "dsdsd";
    }
}
