package com.learning.fred.design.principle.pattern.action.state.branch;

/**
 * @author fred
 * @date 2020/12/30 09:32
 * @description todo
 */
public class MarioStateMachine {

    private int score;
    private State currentState;

    public MarioStateMachine(int score, State currentState) {
        this.score = score;
        this.currentState = currentState;
    }

    public void obtainMushRoom() {
        //TODO
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }
    public void obtainCape() {
        //TODO
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER) ) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }
    public void obtainFireFlower() {
        //TODO
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER) ) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }
    public void meetMonster() {
        //TODO
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
