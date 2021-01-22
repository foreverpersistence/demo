package com.learning.fred.design.principle.pattern.action.state.singleton;

/**
 * @author fred
 * @date 2020/12/30 19:05
 * @description 单例状态机
 * 状态模式， 引入 很多类
 */
public class MarioStateMachine {

    private int score;
    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = null;
    }

    public void obtainMushRoom() { this.currentState.obtainMushRoom(this);
    }
    public void obtainCape() { this.currentState.obtainCape(this);
    }
    public void obtainFireFlower() { this.currentState.obtainFireFlower(this);
    }
    public void meetMonster() { this.currentState.meetMonster(this);
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
