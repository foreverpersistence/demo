package com.learning.fred.design.project.com.xzg.ratelimite.rule;

/**
 * @author fred
 * @date 2021/1/22 15:31
 * @description api 限流 配置信息
 */
public class ApiLimit {

    private static final int DEFSULT_TIME_UNIT = 1;//second

    private String api;
    private int limit;
    private int unit = DEFSULT_TIME_UNIT;

    public ApiLimit() {
    }

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFSULT_TIME_UNIT);
    }

    public ApiLimit(String api, int limit, int unit) {
        this.api = api;
        this.limit = limit;
        this.unit = unit;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
