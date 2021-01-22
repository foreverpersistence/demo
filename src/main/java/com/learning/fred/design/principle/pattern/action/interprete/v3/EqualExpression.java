package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.Map;
import java.util.Objects;

/**
 * @author fred
 * @date 2021/1/7 14:40
 * @description 相等 解释器
 */
public class EqualExpression implements Expression {

    private String key;
    private Long value;

    public EqualExpression(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public EqualExpression(String expression) {
        String[] elements = expression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].equals("=")) {
            throw new RuntimeException("");
        }

        this.key = elements[0];
        this.value = Long.parseLong(elements[2]);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        Long statsValue = stats.get(key);
        if (statsValue == null) {
            return false;
        }

        if (Objects.equals(statsValue, value)) {
            return true;
        }
        return false;
    }
}
