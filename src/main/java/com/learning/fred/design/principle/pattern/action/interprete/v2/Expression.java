package com.learning.fred.design.principle.pattern.action.interprete.v2;

/**
 * 规则 解析器
 */
public interface Expression {

    long interpret();
}

/**
 * 数字 解释器
 */
class NumberExpression implements Expression {

    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {
        return this.number;
    }
}

class AdditionExpression implements Expression {

    private Expression exp1;
    private Expression exp2;

    public AdditionExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public long interpret() {
        return exp1.interpret() + exp2.interpret();
    }
}

class SubstractionExpression implements Expression {

    private Expression exp1;
    private Expression exp2;

    public SubstractionExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public long interpret() {
        return exp1.interpret() - exp2.interpret();
    }
}

class MultiplicationExpression implements Expression {

    private Expression exp1;
    private Expression exp2;

    public MultiplicationExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public long interpret() {
        return exp1.interpret() * exp2.interpret();
    }
}

class DivisionExpression implements  Expression {

    private Expression exp1;
    private Expression exp2;

    public DivisionExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public long interpret() {
        return exp1.interpret() / exp2.interpret();
    }
}