package com.learning.fred.design.project.com.xzg.ratelimite;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;

import java.util.concurrent.TimeUnit;

/**
 * @author fred
 * @date 2021/1/22 16:04
 * @description todo
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        /**
         * StopWatch
         */
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(stopwatch);

        TimeUnit.SECONDS.sleep(1);

        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));

        stopwatch.start();

        Thread.sleep(100);

        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));




        System.out.println(Ticker.systemTicker().read());


    }
}
