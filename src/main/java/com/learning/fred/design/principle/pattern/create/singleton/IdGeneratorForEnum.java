package com.learning.fred.design.principle.pattern.create.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fred
 * @date 2020/12/14 16:51
 * @description 枚举 单利
 */
public enum  IdGeneratorForEnum {

    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
