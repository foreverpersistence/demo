package com.learning.fred.mockdemo.controller;

import java.io.Serializable;

/**
 * @author fred
 * @date 2020/12/18 13:49
 * @description todo
 */
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 4886206811288786668L;

    private boolean success = false;

    private int ret = 1; //0: 成功, 非0: 失败

    private String code = "no code";

    private String msg = "no message";

    private T data = null;

    public void copy(ResultInfo<T> other) {
        this.withSuccess(other.isSuccess()).withRet(other.getRet()).withCode(other.getCode()).withMsg(other.getMsg()).withData(
                other.getData());
    }

    public ResultInfo<T> succeed() {
        this.success = true;
        this.ret = 0;
        this.code = "SUCCESS";
        this.msg = "success";
        return this;
    }

    public ResultInfo<T> succeed(T data) {
        this.success = true;
        this.ret = 0;
        this.code = "SUCCESS";
        this.msg = "success";
        this.data = data;
        return this;
    }

    public ResultInfo<T> withSuccess(boolean success) {
        this.success = success;
        if (success) {
            this.ret = 0;
        }
        return this;
    }

    public ResultInfo<T> withRet(int ret) {
        this.ret = ret;
        return this;
    }

    public ResultInfo<T> withCode(String code) {
        this.code = code;
        return this;
    }

    public ResultInfo<T> withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultInfo<T> withData(T data) {
        this.data = data;
        return this;
    }


    public ResultInfo<T> fail(ResultInfo<T> other) {
        this.success = false;
        this.ret = other.ret;
        this.code = other.code;
        this.msg = other.msg;
        this.data = other.getData();
        return this;
    }

    public ResultInfo<T> fail(int ret, String code, String msg) {
        this.success = false;
        this.ret = ret;
        this.code = code;
        this.msg = msg;
        return this;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getRet() {
        return ret;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResultInfo [success=" + success + ", ret=" + ret + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}
