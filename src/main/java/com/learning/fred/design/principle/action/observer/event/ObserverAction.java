package com.learning.fred.design.principle.action.observer.event;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fred
 * @date 2020/12/24 16:58
 * @description 包装 订阅者的 class 和 method
 */
public class ObserverAction {

    //class
    private Object target;

    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
//        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object even) {// param: even
        try {
            method.invoke(target, even);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
