package com.learning.fred.design.principle.action.observer.event;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author fred
 * @date 2020/12/24 19:10
 * @description todo
 */
public class EventBus {

    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void registry(Object obj) {
        registry.registry(obj);
    }

    public void post(Object event) {
        List<ObserverAction> matchedObserverActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : matchedObserverActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
