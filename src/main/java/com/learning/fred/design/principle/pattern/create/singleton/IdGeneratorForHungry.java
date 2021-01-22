package com.learning.fred.design.principle.pattern.create.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fred
 * @date 2020/12/14 16:46
 * @description 静态内部类
 */
public class IdGeneratorForHungry {

    private AtomicLong id = new AtomicLong(0);
    private IdGeneratorForHungry() {}

    /**
     * SingletonHolder 是一个静态内部类，
     *   当外部类 IdGenerator 被加载的时候，并不会创建 SingletonHolder 实例对象。
     *   只有当调用 getInstance() 方法时，SingletonHolder 才会 被加载，这个时候才会创建 instance。
     *   insance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。
     *  所以，这种实现方法既保证了线程安全，又能做到延迟加载。
     */
    private static class SingletonHolder {
        private static final IdGeneratorForHungry instance = new IdGeneratorForHungry();
    }

    public static IdGeneratorForHungry getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }

}


