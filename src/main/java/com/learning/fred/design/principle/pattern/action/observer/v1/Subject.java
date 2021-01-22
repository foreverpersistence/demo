package com.learning.fred.design.principle.pattern.action.observer.v1;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);

}
