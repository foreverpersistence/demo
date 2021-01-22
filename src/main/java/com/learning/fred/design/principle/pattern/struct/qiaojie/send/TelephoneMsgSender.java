package com.learning.fred.design.principle.pattern.struct.qiaojie.send;

import com.learning.fred.design.principle.pattern.struct.qiaojie.MsgSender;

import java.util.List;

/**
 * @author fred
 * @date 2020/12/21 15:15
 * @description todo
 */
public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {

    }
}
