package com.cloud.xue.demo.enums;

/**
 *
 */
public enum ResultEnum {
    UNKNOW_ERROR("-1","未知错误"),
    SUCCESS("0", "成功"),
    ADD_ERROR("101","插入区域信息失败!"),
    UPDATE_ERROR("102","更新区域信息失败!"),
    DELETE_ERROR("103","删除区域信息失败!"),

    UPLOAD_ERROR("104","上传文件失败！"),
    ;

    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }
}
