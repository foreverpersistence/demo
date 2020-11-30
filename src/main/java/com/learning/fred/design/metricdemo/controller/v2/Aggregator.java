package com.learning.fred.design.metricdemo.controller.v2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author fred
 * @date 2020/11/9 10:22 上午
 * @description 根据原始数据计算统计数据。
 */
public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {

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
}
