package com.learning.fred.design.principle.action.state.singleton;

import com.learning.fred.design.principle.action.state.branch.State;

/**
 * @author fred
 * @date 2020/12/30 19:07
 * @description todo
 */
public class SmallerMario implements IMario {
    //singleton
    private static final SmallerMario instance = new SmallerMario();
    private SmallerMario() {}

    public static SmallerMario getInstance() {
        return instance;
    }


    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
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
