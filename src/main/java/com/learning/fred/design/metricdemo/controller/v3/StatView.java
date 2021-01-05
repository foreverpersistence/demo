package com.learning.fred.design.metricdemo.controller.v3;

import com.learning.fred.design.metricdemo.controller.v2.RequestStat;

import java.util.Map;

public interface StatView {

    void output(Map<String, RequestStat> requestStatMap, long startTimeInMillis, long end);
}
