package com.learning.fred.design.principle.pattern.action.resposibilty.v1;

/**
 * @author fred
 * @date 2020/12/28 13:46
 * @description todo
 */
public class HandlerChain {

    private Handler head = null;
    private Handler tail =  null;
    public void addHandler(Handler handler) {
        handler.setSuccessor(null);

        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void hander() {
        if (head != null) {
            head.handle();
        }

    }
}
