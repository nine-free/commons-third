package com.soft1010.commons.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jifuzhang on 17/8/8.
 */
public class Response<T> {
    private String errorCode;
    private String errorMsg;
    @JSONField(name = "data")
    private T t;

    public Response() {
    }

    public Response(String errorCode, String errorMsg, T t) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.t = t;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
