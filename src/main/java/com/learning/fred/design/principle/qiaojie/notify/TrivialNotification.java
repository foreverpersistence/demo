package com.learning.fred.design.principle.qiaojie.notify;

import com.learning.fred.design.principle.qiaojie.MsgSender;
import com.learning.fred.design.principle.qiaojie.Notification;

/**
 * @author fred
 * @date 2020/12/21 15:20
 * @description todo
 */
public class TrivialNotification extends Notification {

    public TrivialNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {

    }
}
