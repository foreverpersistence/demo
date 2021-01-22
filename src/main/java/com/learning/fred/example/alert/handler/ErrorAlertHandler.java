package com.learning.fred.example.alert.handler;

import com.learning.fred.example.alert.AlertRule;
import com.learning.fred.example.alert.ApiStatInfo;
import com.learning.fred.example.alert.Notification;

/**
 * @author fred
 * @date 2020/12/21 15:02
 * @description todo
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
//        if (apiStatInfo.getErrorCunt() > rule.getMatchedRule(apiStatInfo.getApi()) {
//            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
//        }
    }
}
