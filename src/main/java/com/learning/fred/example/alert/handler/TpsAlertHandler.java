package com.learning.fred.example.alert.handler;

import com.learning.fred.example.alert.AlertRule;
import com.learning.fred.example.alert.ApiStatInfo;
import com.learning.fred.example.alert.Notification;

/**
 * @author fred
 * @date 2020/12/21 15:01
 * @description todo
 */
public class TpsAlertHandler extends AlertHandler {


    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
//        long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDuratinOfSeconds();
//        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }


    }
}
