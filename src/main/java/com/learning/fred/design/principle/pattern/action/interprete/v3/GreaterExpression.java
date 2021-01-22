package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.Map;

/**
 * @author fred
 * @date 2021/1/7 11:45
 * @description > 规则解释器
 */
public class GreaterExpression implements Expression {

    private String key;
    private Long value;

    public GreaterExpression(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public GreaterExpression(String strExpression) {
        String[] elements = strExpression.trim().split("\\s+");

        if (elements.length != 3 || !elements[1].trim().equals(">")) {
            throw new RuntimeException("Expression is invalid:" + strExpression);
        }

        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());

    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(key)) {
            return false;
        }
        long statValue = stats.get(key);
        return statValue > value;
    }
}
