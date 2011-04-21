package com.gamblerstools.betfair.toolkit.exception.event;

import com.gamblerstools.betfair.toolkit.exception.BetfairException;

public class BetfairEventException extends BetfairException {

	public BetfairEventException(Throwable e) {
		super(e);
		
	}

	public BetfairEventException() {
		super();
	}

	public BetfairEventException(String string) {
		super(string);
		
	}

	public BetfairEventException(String message, Throwable e) {
		super(message, e);
		
	}

}
