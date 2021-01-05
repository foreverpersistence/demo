package com.learning.fred.design.principle.action.state.branch;

/**
 * @author fred
 * @date 2020/12/30 09:33
 * @description todo
 */
public class ApplicationDemo {

    public static void main(String[] args) {

        int score = 0;
        State state = State.CAPE;
        MarioStateMachine mario = new MarioStateMachine(score, state);

        mario.obtainMushRoom();

    }
}
