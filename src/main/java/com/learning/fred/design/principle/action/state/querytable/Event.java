package com.learning.fred.design.principle.action.state.querytable;

/**
 * @author fred
 * @date 2020/12/30 10:08
 * @description todo
 */
public enum  Event {

    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);

    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
