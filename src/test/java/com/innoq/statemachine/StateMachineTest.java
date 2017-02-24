package com.innoq.statemachine;

import org.junit.Assert;
import org.junit.Test;

import com.innoq.statemachine.domain.Request;
import com.innoq.statemachine.domain.State;

public class StateMachineTest {
	
	// change state
	@Test
	public void testSUBMITRequestDRAFT() {
		Request request = new Request("MyRequest1", State.DRAFT);

		StateMachine.build(TransitionConfiguration.DEFAULT, request).apply(Action.SUBMIT_REQUEST);

		Assert.assertEquals(State.IN_APPROVAL, request.getState());
	}
	
	// do not change state
	@Test
	public void testASK_FOR_CHANGERequestDRAFT() {
		Request request = new Request("MyRequest1", State.DRAFT);

		StateMachine.build(TransitionConfiguration.DEFAULT, request).apply(Action.ASK_FOR_CHANGE);

		Assert.assertEquals(State.DRAFT, request.getState());
	}
}
