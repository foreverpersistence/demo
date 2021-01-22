package com.learning.fred.design.principle.pattern.struct.qiaojie.notify;

import com.learning.fred.design.principle.pattern.struct.qiaojie.MsgSender;
import com.learning.fred.design.principle.pattern.struct.qiaojie.Notification;

/**
 * @author fred
 * @date 2020/12/21 15:19
 * @description todo
 */
public class UrgencyNotification extends Notification {
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {

    }
}
