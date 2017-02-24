package com.innoq.statemachine;

import com.innoq.statemachine.domain.State;

public class Transition {
	State	from;
	Action	action;
	State	to;

	public Transition(State from, Action action, State to) {
		this.from = from;
		this.action = action;
		this.to = to;
	}
}
