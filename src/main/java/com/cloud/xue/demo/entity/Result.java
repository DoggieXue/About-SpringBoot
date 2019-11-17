package com.cloud.xue.demo.entity;

/**
 * @Program demo
 * @Title: Result
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-14 11:03:40
 */
public class Result<T> {
    //错误码
    private String errorCde;
    //错误信息
    private String errorMsg;
    //具体内容
    private T data;

    public Result() {
    }

    public Result(String errorCde, String errorMsg, T data) {
        this.errorCde=errorCde;
        this.errorMsg=errorMsg;
        this.data=data;
    }

    public String getErrorCde() {
        return errorCde;
    }

    public void setErrorCde(String errorCde) {
        this.errorCde=errorCde;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg=errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data=data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errorCde:'" + errorCde + '\'' +
                ", errorMsg:'" + errorMsg + '\'' +
                ", data:" + data +
                '}';
    }
}
