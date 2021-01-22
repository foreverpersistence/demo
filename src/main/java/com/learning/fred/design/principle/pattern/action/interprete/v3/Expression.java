package com.learning.fred.design.principle.pattern.action.interprete.v3;

import java.util.Map;

/**
 * @author fred
 * @date 2021/1/7 11:44
 * @description todo
 */
public interface Expression {

    boolean interpret(Map<String, Long> stats);
}
