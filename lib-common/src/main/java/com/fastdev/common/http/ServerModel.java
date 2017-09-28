package com.fastdev.common.http;

import com.bean.DataObject;

import java.io.Serializable;

/**
 * Created by lipy on 2017/6/8.
 */
public class ServerModel<T extends DataObject> implements Serializable, DataObject {
    private int code;
    private String msg;
    private T   data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ServerModel{" +
                "code=" + code +
                ", message='" + msg + '\'' +
                "\ndata=" + data +
                '}';
    }
}
