package com.learning.fred.example.alert;

import com.learning.fred.example.alert.handler.AlertHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2021/1/13 17:38
 * @description todo
 */
public class Alert {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }
}
