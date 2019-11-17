package com.cloud.xue.demo.exception;

import com.cloud.xue.demo.enums.ResultEnum;

/**
 * @Program demo
 * @Title: AreaException
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-14 11:00:42
 */
public class AreaException extends RuntimeException{
    private String errorCde;



    public AreaException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCde = resultEnum.getCode();
    }

    public String getErrorCde() {
        return errorCde;
    }

    public void setErrorCde(String errorCde) {
        this.errorCde=errorCde;
    }
}
