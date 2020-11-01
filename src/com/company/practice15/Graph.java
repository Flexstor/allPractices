package com.company.practice15;

import java.util.HashMap;
import java.util.ArrayList;

public class Graph {
    private final ArrayList<State> stateList = new ArrayList<>();
    private final HashMap<Integer, String> transitionAction = new HashMap<>();
    private State S1 = new State(0, 1, 1, 4);
    private State S2 = new State(3, 2, 5, 3);
    private State S3 = new State(5, 3, 1, 4);
    private State S4 = new State(2, 2, 4, 4);
    private State S5 = new State(4, 0, 2, 2);
    private Integer currentState = 0;

    public Graph() {
        setTransitActionMap();
        setStateList();
    }

    public void work(ArrayList<Integer> transitions) {
        for (int i = 0; i < transitions.size(); i++) {
            System.out.println(transitionAction.get(stateList.get(currentState).getActions().get(transitions.get(i))));
            currentState = stateList.get(currentState).getStates().get(transitions.get(i));
        }
    }

    private void setStateList(){
        stateList.add(S1);
        stateList.add(S2);
        stateList.add(S3);
        stateList.add(S4);
        stateList.add(S5);
    }

    private void setTransitActionMap(){
        transitionAction.put(0, "create_project");
        transitionAction.put(1, "add_library");
        transitionAction.put(2, "restart");
        transitionAction.put(3, "test");
        transitionAction.put(4, "deploy");
        transitionAction.put(5, "drop_db");
    }
}
