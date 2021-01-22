package com.learning.fred.design.principle.pattern.action.observer.v2;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.learning.fred.design.principle.isp.UserService;

import java.util.concurrent.Executors;

/**
 * @author fred
 * @date 2020/12/24 14:03
 * @description todo
 */
public class UserController {

    private UserService userService;
    private PromotionService promotionService;


    public Long registry(String telephone, String password) {
        //
        boolean e = userService.register("", "");
        //注册后的解藕
//        promotionService.issuNewUserExperienxeCash("");

        return null;
    }

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();
        eventBus.post(null);
        EventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(1));
    }
}
