package com.learning.fred.design.principle.action.observer.v1;

/**
 * @author fred
 * @date 2020/12/24 14:01
 * @description 具体观察者
 */
public class ConcreteObserverOne implements Observer {

    @Override
    public void update(Message msg) {

        System.out.println("ConcreteObserverOne doing");
    }
}
