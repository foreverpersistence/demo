package com.learning.fred.design.principle.pattern.struct.qiaojie.notify;

import com.learning.fred.design.principle.pattern.struct.qiaojie.MsgSender;
import com.learning.fred.design.principle.pattern.struct.qiaojie.Notification;

/**
 * @author fred
 * @date 2020/12/21 15:18
 * @description 严重程度的消息发送
 */
public class ServerNotification extends Notification {
    public ServerNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {

    }
}
