package com.learning.fred.design.principle.pattern.action.observer.event;

import java.util.concurrent.Executor;

/**
 * @author fred
 * @date 2020/12/24 19:12
 * @description 异步
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
