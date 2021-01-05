package com.learning.fred.design.principle.qiaojie;

/**
 * @author fred
 * @date 2020/12/21 15:09
 * @description 抽象
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
    //    private List<String> emailAddresses;
//    private List<String> telephones;
//    private List<String> wecharIds;
//
//    public Notification() {
//    }
//
//
//    public List<String> getEmailAddresses() {
//        return emailAddresses;
//    }
//
//    public void setEmailAddresses(List<String> emailAddresses) {
//        this.emailAddresses = emailAddresses;
//    }
//
//    public List<String> getTelephones() {
//        return telephones;
//    }
//
//    public void setTelephones(List<String> telephones) {
//        this.telephones = telephones;
//    }
//
//    public List<String> getWecharIds() {
//        return wecharIds;
//    }
//
//    public void setWecharIds(List<String> wecharIds) {
//        this.wecharIds = wecharIds;
//    }
}
