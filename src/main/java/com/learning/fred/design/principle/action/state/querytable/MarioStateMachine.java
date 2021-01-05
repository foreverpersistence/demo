package com.learning.fred.design.principle.action.state.querytable;

import com.learning.fred.design.principle.action.state.branch.State;

import static com.learning.fred.design.principle.action.state.branch.State.*;

/**
 * @author fred
 * @date 2020/12/30 10:10
 * @description 查表法
 */
public class MarioStateMachine {

    private int score;
    private State currentState;

    private static final State[][] transitionTable = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}
    };

    private static final  int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SMALL;
    }
    public void obtainMushRoom() { executeEvent(Event.GOT_MUSHROOM);
    }
    public void obtainCape() { executeEvent(Event.GOT_CAPE);
    }
    public void obtainFireFlower() { executeEvent(Event.GOT_FIRE);
    }
    public void meetMonster() { executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score = actionTable[stateValue][eventValue];
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
