package com.learning.fred.design.principle.pattern.action.state.branch;

/**
 * 状态
 */
public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
