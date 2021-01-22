package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.Map;

/**
 * @author fred
 * @date 2021/1/7 14:36
 * @description 小于 解释器
 */
public class LessExpression implements Expression {

    private String key;
    private Long value;

    public LessExpression(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public LessExpression(String expression) {

        String[] elements = expression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].equals("-")) {
            throw new RuntimeException("");
        }

        this.key = elements[0];
        this.value = Long.parseLong(elements[2]);


    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        Long statValue = stats.get(key);
        if (statValue == null) {
            return false;
        }
        if (statValue < value) {
            return true;
        }
        return false;
    }
}
