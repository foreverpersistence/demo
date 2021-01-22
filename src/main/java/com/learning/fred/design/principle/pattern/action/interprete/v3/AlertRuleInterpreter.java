package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.Map;

/**
 * @author fred
 * @date 2021/1/7 11:35
 * @description 告警规则 判断
 */
public class AlertRuleInterpreter {

    private Expression expression;

    //key1>100&&key2<1000||key3==200
    public AlertRuleInterpreter(String ruleExpression) {
        //获取 规则
        this.expression = new OrExpression(ruleExpression);
    }

    //<String, Long> apiStat = new HashMap<>();
    //apiStat.put("key1", 103);
    //apiStat.put("key2", 987);
    public boolean interpret(Map<String, Long> stats) {

        return expression.interpret(stats);
    }


}
