package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author fred
 * @date 2021/1/7 14:44
 * @description and 解释器， 存在 基本（大于，小于，等于）的子集
 */
public class AndExpression implements Expression {

    List<Expression> expressions = new ArrayList<>();

    public AndExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public AndExpression(String expression) {

        String[] expressiones = expression.trim().split("&&");
        for (String subExpression : expressiones) {
            if (subExpression.contains("<")) {
                expressions.add(new LessExpression(subExpression));
            } else if (subExpression.contains(">")) {
                expressions.add(new GreaterExpression(subExpression));
            } else if (subExpression.contains("==")) {
                expressions.add(new EqualExpression(subExpression));
            } else {
                throw new RuntimeException("Expression is invalid:" + subExpression);
            }
        }
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if (!expression.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
