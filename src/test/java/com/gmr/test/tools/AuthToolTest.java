package com.gmr.test.tools;

import com.gmr.test.model.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthToolTest {

    @Test
    public void getAuth() {
    }

    @Test
    public void getInfo() {
        User user = AuthTool.getInfo("16122131");
        Assert.assertNotNull(user);
    }
}