package com.learning.fred.design.principle.action.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2020/12/25 13:48
 * @description 2、策略的创建
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        //无状态， 可缓存
        strategies.put("1", new ConcreteStrategyA());
        strategies.put("2", new ConcreteStrategyB());

        //有状态，可 新建
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty");
        }

        return strategies.get(type);
    }
}
