package com.learning.fred.design.principle.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fred
 * @date 2020/12/14 16:52
 * @description 双重检查
 *   指令重排序。
 *     new，
 *     初始化
 *     赋值
 *
 *     volatile
 */
public class IdGeneratorForCheck {

    private AtomicLong id = new AtomicLong(0);

    private static volatile IdGeneratorForCheck instance;
    private IdGeneratorForCheck() {}

    public static IdGeneratorForCheck getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorForCheck.class) {
                if (instance == null) {
                    instance = new IdGeneratorForCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
