package com.learning.fred.design.metricdemo.controller.v2;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;

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

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSave) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(1));
        this.eventBus.register(new EventListener());
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
//        metricsStorage.saveRequestInfo(requestInfo);
        eventBus.post(requestInfo);
    }

    private EventBus eventBus;


    public class EventListener {

        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
             metricsStorage.saveRequestInfo(requestInfo);
        }
    }

}
