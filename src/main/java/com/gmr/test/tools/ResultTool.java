package com.gmr.test.tools;

import com.gmr.test.model.OV.Result;

import java.util.List;

import static com.gmr.test.model.ResultCode.FAILED;
import static com.gmr.test.model.ResultCode.SUCCESS;

/**
 * @program: test
 * @description: 返回格式模板
 * @author: ggmr
 * @create: 2018-06-24 19:25
 */
public class ResultTool {
    public static Result<List<Object>> success(List<Object> object){
        Result<List<Object>> result = new Result<>();
        result.setCode(SUCCESS);
        result.setData(object);
        return result;
    }

    public static Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(SUCCESS);
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(null);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(FAILED);
        result.setData(null);
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setCode(FAILED);
        result.setData(null);
        return result;
    }
}
