package com.learning.fred.design.principle.pattern.action.observer.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2020/12/24 13:59
 * @description todo
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {

        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {

        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
