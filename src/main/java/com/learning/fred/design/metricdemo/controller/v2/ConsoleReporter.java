package com.learning.fred.design.metricdemo.controller.v2;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author fred
 * @date 2020/11/9 1:56 下午
 * @description 控制台输出
 */
public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSecond, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;

                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

                Map<String, RequestStat> stats = new HashMap<>();

                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {

                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();

                    //统计
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestStat);
                }

                // 显示
                System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");

                System.out.println(JSON.toJSON(stats));

            }
        }, 0, periodInSecond, TimeUnit.SECONDS);
    }
}
