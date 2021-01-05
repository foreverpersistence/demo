package com.learning.fred.design.principle.action.state.stat;

/**
 * @author fred
 * @date 2020/12/30 13:47
 * @description todo
 */
public class MarioStateMachine {

    private int score;
    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = new SmallMario(this);
    }

    public void obtainMushRoom() { this.currentState.obtainMushRoom();
    }
    public void obtainCape() { this.currentState.obtainCape();
    }
    public void obtainFireFlower() { this.currentState.obtainFireFlower();
    }
    public void meetMonster() { this.currentState.meetMonster();
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
