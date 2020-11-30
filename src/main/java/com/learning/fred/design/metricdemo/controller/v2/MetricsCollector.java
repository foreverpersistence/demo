package com.learning.fred.design.metricdemo.controller.v2;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fred
 * @date 2020/11/9 10:21 上午
 * @description 数据采集， 接口数据
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;//接口编程

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
