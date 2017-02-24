package com.innoq.statemachine;

import java.util.List;

import com.innoq.statemachine.domain.Request;

public class StateMachine {
	private List<Transition>	transitions;
	private Request				request;

	/**
	 * Create StateMachine instance
	 * 
	 */
	public static StateMachine build(TransitionConfiguration config, Request request) {
		return new StateMachine(config, request);
	}

	private StateMachine(TransitionConfiguration config, Request request) {
		this.request = request;
		this.transitions = config.getTransitions();
	}

	/**
	 * Apply a new action to the current request
	 * 
	 */
	public StateMachine apply(Action action) {
		for (Transition transition : transitions) {
			boolean currentStateMatches = transition.from.equals(request.getState());
			boolean conditionsMatch = transition.action.equals(action);

			if (currentStateMatches && conditionsMatch) {
				System.out.println("Applying " + transition.to + " to request");

				request.setState(transition.to);
				break;
			}
		}

		return this;
	}
}
