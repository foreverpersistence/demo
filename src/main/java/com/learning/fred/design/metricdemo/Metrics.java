package com.learning.fred.design.metricdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author fred
 * @date 2020/11/9 9:28 上午
 * @description todo
 */
public class Metrics {

    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    public void startRepeatReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                Map<String, Map<String, Double>> stas = new HashMap<>();
                for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiRespTimes = entry.getValue();

                    stas.putIfAbsent(apiName, new HashMap<>());
                    stas.get(apiName).put("max", max(apiRespTimes));
                    stas.get(apiName).put("avg", avg(apiRespTimes));
                }

                for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {

                    String apiName = entry.getKey();
                    List<Double> apiTimestamps = entry.getValue();
                    stas.putIfAbsent(apiName, new HashMap<>());
                    stas.get(apiName).put("count", (double) apiTimestamps.size());
                }

                //显示形式
                System.out.println(JSON.toJSON(stas));

            }


        }, 0, period, unit);
    }

    private Double avg(List<Double> apiRespTimes) {
        return null;
    }

    private Double max(List<Double> apiRespTimes) {
        return null;
    }
}
