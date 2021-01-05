package com.learning.fred.design.metricdemo.controller.v3;

import com.google.common.annotations.VisibleForTesting;
import com.learning.fred.design.metricdemo.controller.v2.Aggregator;
import com.learning.fred.design.metricdemo.controller.v2.MetricsStorage;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fred
 * @date 2020/12/14 10:04
 * @description todo
 */
public class EmailReport1 extends ScheduledReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    public EmailReport1(MetricsStorage metricsStorage, Aggregator aggregator, StatView viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    public void startDailyReport() {
        Date firstTime = trimTimeFieldToZeroOfNextDay(new Date());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis; doStatAndReport(startTimeInMillis, endTimeInMillis);

            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    /**
     * 可测试性 不好， 依赖 当前时间
     * @return
     */
    @VisibleForTesting
    protected Date trimTimeFieldToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);// 依赖 度解放， 方便测试
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


}
