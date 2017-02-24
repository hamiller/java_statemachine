package com.innoq.statemachine.domain;

public class Request {

	private String	objectName;
	private State	state;

	public Request(String objectName, State currentState) {
		this.objectName = objectName;
		this.state = currentState; 
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
