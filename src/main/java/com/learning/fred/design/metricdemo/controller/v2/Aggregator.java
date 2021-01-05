package com.learning.fred.design.metricdemo.controller.v2;

import java.util.*;

/**
 * @author fred
 * @date 2020/11/9 10:22 上午
 * @description 根据原始数据计算统计数据。
 */
public class Aggregator {

    public /*static*/ RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {

        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;

        double avgResptime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double responseTime = requestInfo.getResponseTime();
            if (maxRespTime < responseTime) {
                maxRespTime = responseTime;
            }

            if (minRespTime > responseTime) {
                minRespTime = responseTime;
            }

            sumRespTime += responseTime;
        }

        if (count != 0) {
            avgResptime = sumRespTime / count;
        }

        long tps = (long) (count / durationInMillis * 1000);

        //百分位
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if (diff < 0.0) {
                    return -1;
                } else if (diff > 0.0) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });

        int idx999 = (int) (count * 0.9999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();//第几位数字
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }

        RequestStat stat = new RequestStat();
        stat.setMaxResponseTime(maxRespTime);
        stat.setMinResponseTime(minRespTime);
        stat.setAvgResponseTime(avgResptime);
        stat.setP999ResponseTime(p999RespTime);
        stat.setP99ResponseTime(p99RespTime);
        stat.setCount(count);
        stat.setTps(tps);

        return stat;

    }


    /**
     * v2
     * @param requestInfos
     * @param durationInMillis
     * @return
     */
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos,
                                              long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String name = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(name, requestStat);
        }

        return requestStats;
    }


    private RequestStat doAggregate(List<RequestInfo> requestInfos, long duration) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }
        RequestStat requestStat = new RequestStat();
//        requestStat.setMaxResponseTime(max(respTimes));
//        requestStat.setMinResponseTime(min(respTimes));
//        requestStat.setAvgResponseTime(avg(respTimes));
//        requestStat.setP999ResponseTime(percentile999(respTimes));
//        requestStat.setP99ResponseTime(percentile99(respTimes));
//        requestStat.setCount(respTimes.size());
//        requestStat.setTps((long) tps(respTimes.size(), durationInMillis/1000));
        return requestStat;
    }






}
