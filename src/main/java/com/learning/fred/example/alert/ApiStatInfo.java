package com.learning.fred.example.alert;

/**
 * @author fred
 * @date 2020/12/21 14:18
 * @description todo
 */
public class ApiStatInfo {

    private String api;
    private long requestCount;
    private long errorCunt;
    private long duratinOfSeconds;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public long getErrorCunt() {
        return errorCunt;
    }

    public void setErrorCunt(long errorCunt) {
        this.errorCunt = errorCunt;
    }

    public long getDuratinOfSeconds() {
        return duratinOfSeconds;
    }

    public void setDuratinOfSeconds(long duratinOfSeconds) {
        this.duratinOfSeconds = duratinOfSeconds;
    }
}
