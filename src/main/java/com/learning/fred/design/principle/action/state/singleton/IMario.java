package com.learning.fred.design.principle.action.state.singleton;

import com.learning.fred.design.principle.action.state.branch.State;

/**
 * @author fred
 * @date 2020/12/30 19:05
 * @description todo
 */
public interface IMario {
    State getName();
    void obtainMushRoom(MarioStateMachine stateMachine);
    void obtainCape(MarioStateMachine stateMachine);
    void obtainFireFlower(MarioStateMachine stateMachine);
    void meetMonster(MarioStateMachine stateMachine);
}
