package com.learning.fred.design.principle.action.state.stat;


/**
 * @author fred
 * @date 2020/12/30 09:33
 * @description todo
 */
public class ApplicationDemo {

    public static void main(String[] args) {

        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainCape();
        int score = mario.getScore();
        IMario currentState = mario.getCurrentState();

        System.out.println("mario score: " + score + "; state: " + currentState);

        mario.obtainMushRoom();

        System.out.println("mario score: " + mario.getScore() + "; state: " + mario.getCurrentState());

    }
}
