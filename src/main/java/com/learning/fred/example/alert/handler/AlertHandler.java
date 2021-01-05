package com.learning.fred.example.alert.handler;

import com.learning.fred.example.alert.AlertRule;
import com.learning.fred.example.alert.ApiStatInfo;
import com.learning.fred.example.alert.Notification;

/**
 * @author fred
 * @date 2020/12/21 14:19
 * @description 告警处理类
 */
public abstract class AlertHandler {


    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
