package com.learning.fred.design.principle.pattern.action.state.stat;

import com.learning.fred.design.principle.pattern.action.state.branch.State;

/**
 * @author fred
 * @date 2020/12/30 13:45
 * @description todo
 */
public class FireMario implements IMario {
    private MarioStateMachine stateMachine;

    public FireMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
