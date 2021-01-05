package com.learning.fred.design.principle.action.observer.v1;

/**
 * @author fred
 * @date 2020/12/24 14:02
 * @description demo
 */
public class Demo {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());

        subject.notifyObserver(new Message());
    }
}
