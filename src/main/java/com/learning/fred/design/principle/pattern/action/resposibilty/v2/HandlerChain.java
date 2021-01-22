package com.learning.fred.design.principle.pattern.action.resposibilty.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2020/12/28 13:50
 * @description 责任链
 */
public class HandlerChain {

    //list
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handler() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handler();
            if (handled) {
                break;
            }
        }
    }
}
