package com.learning.fred.design.metricdemo.controller.v2;

import java.util.*;

/**
 * @author fred
 * @date 2020/11/9 2:05 下午
 * @description todo
 */
public class EmailReport {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailReport(MetricsStorage metricsStorage, EmailSender emailSender) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void startDailyReport() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.THURSDAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

//        Date firstTime = calendar.getTime();
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
//                long endTimeInMillis = System.currentTimeMillis();
//                long startTimeInMillis = endTimeInMillis - durationInMillis;
//
//                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
//
//                Map<String, RequestStat> stats = new HashMap<>();
//
//                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
//
//                    String apiName = entry.getKey();
//                    List<RequestInfo> requestInfosPerApi = entry.getValue();
//
//                    //统计
//                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
//                    stats.put(apiName, requestStat);
//                }
//                //todo html 发送
//
//
//            }
//        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}
