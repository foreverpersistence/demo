package com.learning.fred.design.metricdemo.controller.v2;

import java.util.List;
import java.util.Map;

/**
 * @author fred
 * @date 2020/11/9 10:28 上午
 * @description redis storage
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long end) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long end) {
        return null;
    }
}
