package com.learning.fred.design.metricdemo.controller.v3;

import com.learning.fred.design.metricdemo.controller.v2.Aggregator;
import com.learning.fred.design.metricdemo.controller.v2.MetricsStorage;
import com.learning.fred.design.metricdemo.controller.v2.RequestInfo;
import com.learning.fred.design.metricdemo.controller.v2.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fred
 * @date 2020/12/14 09:56
 * @description todo
 */
public abstract class ScheduledReporter {

    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatView viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatView viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durarionInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> aggregate = aggregator.aggregate(requestInfos, durarionInMillis);
        viewer.output(aggregate, startTimeInMillis, endTimeInMillis);
    }

    private static final long MAX_STAT_DURATION_IN_MILLIS = 10 * 60 * 1000;

    private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeInMillis) {
        Map<String, List<RequestStat>> segmentStats = new HashMap<>();

        long segmentStartTimeMillis = startTimeInMillis;
        while (segmentStartTimeMillis < endTimeInMillis) {
            long segmentEndTimeMillis = segmentStartTimeMillis + MAX_STAT_DURATION_IN_MILLIS;
            if (segmentEndTimeMillis > endTimeInMillis) {
                segmentEndTimeMillis = endTimeInMillis;
            }

            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(segmentStartTimeMillis, segmentEndTimeMillis);
            if (requestInfos == null || requestInfos.isEmpty()) {
                continue;
            }

            Map<String, RequestStat> aggregatedStat = aggregator.aggregate(requestInfos, segmentEndTimeMillis - segmentStartTimeMillis);
            addStat(segmentStats, aggregatedStat);

            segmentStartTimeMillis += MAX_STAT_DURATION_IN_MILLIS;

        }

        long durationInMillis = endTimeInMillis - startTimeInMillis;
        //
        Map<String, RequestStat> aggregatedStats = aggregateStats(segmentStats, durationInMillis);

        return aggregatedStats;
    }

    private void addStat(Map<String, List<RequestStat>> segmentStats, Map<String, RequestStat> segmentStat) {
        for (Map.Entry<String, RequestStat> entry : segmentStat.entrySet()) {
            String apiName = entry.getKey();
            RequestStat stat = entry.getValue();
            List<RequestStat> statList = segmentStats.putIfAbsent(apiName, new ArrayList<>());
            statList.add(stat);
        }
    }

    private Map<String, RequestStat> aggregateStats(Map<String, List<RequestStat>> segmentStats, long durationInMillis) {
        Map<String, RequestStat> aggregatedStats = new HashMap<>();

        for (Map.Entry<String, List<RequestStat>> entry : segmentStats.entrySet()) {

            String apiName = entry.getKey();
            List<RequestStat> apiStats = entry.getValue();
            double maxRespTime = Double.MIN_VALUE;
            double minRespTime = Double.MAX_VALUE;
            long count = 0;
            double sumRespTime = 0;

            for (RequestStat stat : apiStats) {
                if (stat.getMaxResponseTime() > maxRespTime) {
//                    maxRespTime = stat.getMaxR ;
                }
                if (stat.getMinResponseTime() < minRespTime) {
//                    minRespTime = stat.getMinR ;
                }
                count += stat.getCount();
                sumRespTime += (stat.getCount() * stat.getAvgResponseTime());
            }

            RequestStat aggregatedStat = new RequestStat();
            aggregatedStat.setMaxResponseTime(maxRespTime);
            aggregatedStat.setMinResponseTime(minRespTime); aggregatedStat.setAvgResponseTime(sumRespTime / count); aggregatedStat.setCount(count); 
            aggregatedStat.setTps(count / durationInMillis * 1000); 
            aggregatedStats.put(apiName, aggregatedStat);
        }

        return aggregatedStats;

    }

}
