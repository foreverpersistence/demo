package com.learning.fred.design.project.com.xzg.ratelimite;

import java.io.InputStream;

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
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        System.out.println(stopwatch);
//
//        TimeUnit.SECONDS.sleep(1);
//
//        stopwatch.stop();
//        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
//
//        stopwatch.start();
//
//        Thread.sleep(100);
//
//        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
//        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
//
//
//
//
//        System.out.println(Ticker.systemTicker().read());



        InputStream in = new Demo().getClass().getResourceAsStream("1.txt");
        if (in!=null) {
            System.out.println("eeeee");
        }

        InputStream in2 = Demo.class.getResourceAsStream("/2.txt");
        if (in2 != null) {
            System.out.println("bbbb");
        }


        /**
         * Class.getResourceAsStream   加 /， classpath
         */
        InputStream in3 = Demo.class.getResourceAsStream("/3.txt");
        if (in3 != null) {
            System.out.println("cccc");
        }

        /**
         * 通过 classLoader 获取 class path， 不加 /
         */
        InputStream in4 = Demo.class.getClassLoader().getResourceAsStream("3.txt");
        if (in4 != null){
            System.out.println("dddd");
        }

    }
}
