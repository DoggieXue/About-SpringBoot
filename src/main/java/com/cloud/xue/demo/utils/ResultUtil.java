package com.cloud.xue.demo.utils;

import com.cloud.xue.demo.entity.Result;
import com.cloud.xue.demo.enums.ResultEnum;

/**
 * @Program demo
 * @Title: ResultUtil
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-14 11:25:09
 */
public class ResultUtil {
    /**
     * 成功响应
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setErrorCde("0");
        result.setErrorMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(Object object,ResultEnum resultEnum){
        Result result = new Result();
        result.setErrorCde(resultEnum.getCode());
        result.setErrorMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    /**
     * 异常响应
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static Result error(String errorCode, String errorMsg){
        Result result = new Result();
        result.setErrorCde(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public static Result error(ResultEnum resultEnum){
        return new Result(resultEnum.getCode(),resultEnum.getMsg(),null);
    }
}
