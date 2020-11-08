package com.company.practice15_16;

import java.util.ArrayList;

public class State {
    private ArrayList<Integer> transitions = new ArrayList<>();
    private ArrayList<Integer> actions = new ArrayList<>();
    private ArrayList<Integer> states = new ArrayList<>();

    public State (int actAt0, int stateAt0, int actAt1, int stateAt1)
    {
        actions.add(actAt0);
        actions.add(actAt1);
        states.add(stateAt0);
        states.add(stateAt1);
    }

    public ArrayList<Integer> getActions() {
        return actions;
    }

    public ArrayList<Integer> getStates() {
        return states;
    }
}
