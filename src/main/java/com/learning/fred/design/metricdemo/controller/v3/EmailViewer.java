package com.learning.fred.design.metricdemo.controller.v3;

import com.learning.fred.design.metricdemo.controller.v2.RequestStat;

import java.util.Map;

/**
 * @author fred
 * @date 2020/12/14 09:46
 * @description 邮箱展示
 */
public class EmailViewer implements StatView {
    @Override
    public void output(Map<String, RequestStat> requestStatMap, long startTimeInMillis, long end) {

    }
}
