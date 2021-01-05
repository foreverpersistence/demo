package com.learning.fred.design.principle.action.state.stat;

import com.learning.fred.design.principle.action.state.branch.State;

public interface IMario { //所有状态类的接口

    State getName();
    //以下是定义的事件
    void obtainMushRoom();
    void obtainCape();
    void obtainFireFlower();
    void meetMonster();
}
