package com.learning.fred.design.metricdemo.controller;

import com.learning.fred.design.metricdemo.Metrics;

import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

/**
 * @author fred
 * @date 2020/11/9 9:46 上午
 * @description todo
 */
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatReport(60, TimeUnit.SECONDS);
    }

    public void register(Object user) {
        long startTimestamp = System.currentTimeMillis();

        metrics.recordTimestamp("register", startTimestamp);

        //todo

        long respTime = System.currentTimeMillis() - startTimestamp;

        metrics.recordResponseTime("register", respTime);

    }

    public Object login(String phone, String password) {
        long startTimestamp = System.currentTimeMillis();

        metrics.recordTimestamp("login", startTimestamp);

        //todo

        long respTime = System.currentTimeMillis() - startTimestamp;

        metrics.recordResponseTime("login", respTime);
        return null;
    }
}
