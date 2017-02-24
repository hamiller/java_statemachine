package com.innoq.statemachine;

import java.util.List;

import com.google.common.collect.Lists;
import com.innoq.statemachine.domain.State;

public enum TransitionConfiguration {
	DEFAULT(Lists.newArrayList(
			new Transition(State.DRAFT, 		Action.SUBMIT_REQUEST, 			State.IN_APPROVAL),	
            new Transition(State.IN_CHANGE, 	Action.RESUBMIT_REQUEST, 		State.IN_APPROVAL),	
            new Transition(State.IN_APPROVAL, 	Action.APPROVE_REQUEST, 		State.APPROVED), 	
            new Transition(State.IN_APPROVAL, 	Action.ASK_FOR_CHANGE, 			State.IN_CHANGE)
    ));

    private List<Transition> transitions;

    TransitionConfiguration(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
