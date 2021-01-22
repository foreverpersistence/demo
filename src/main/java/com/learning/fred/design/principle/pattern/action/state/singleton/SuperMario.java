package com.learning.fred.design.principle.pattern.action.state.singleton;

import com.learning.fred.design.principle.pattern.action.state.branch.State;

/**
 * @author fred
 * @date 2020/12/30 19:09
 * @description todo
 */
public class SuperMario implements IMario {
    private static final SuperMario instance = new SuperMario();
    private SuperMario() {}
    public static SuperMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {


    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {

    }
}
