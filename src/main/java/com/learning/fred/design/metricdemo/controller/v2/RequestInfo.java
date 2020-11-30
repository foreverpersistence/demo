package com.learning.fred.design.metricdemo.controller.v2;

/**
 * @author fred
 * @date 2020/11/9 10:23 上午
 * @description todo
 */
public class RequestInfo {

    private String apiName;
    private double responseTime;
    private long timestamp;

    public RequestInfo(String register, int i, int i1) {

    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
