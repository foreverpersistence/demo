package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author fred
 * @date 2021/1/7 14:52
 * @description  OR 中 只会存在 and 的子集
 */
public class OrExpression implements Expression {

    private List<Expression> expressionList = new ArrayList<>();

    public OrExpression(List<Expression> expressionList) {
        this.expressionList = expressionList;
    }

    public OrExpression(String strExpression) {
        String[] andExpressiones = strExpression.split("\\|\\|");
        for (int i = 0; i < andExpressiones.length; i++) {
            expressionList.add(new AndExpression(andExpressiones[i]));
        }
    }



    @Override
    public boolean interpret(Map<String, Long> stats) {

        for (Expression expression : expressionList) {
            //满足一个 即可
            if (expression.interpret(stats)) {
                return true;
            }
        }
        return false;
    }
}
