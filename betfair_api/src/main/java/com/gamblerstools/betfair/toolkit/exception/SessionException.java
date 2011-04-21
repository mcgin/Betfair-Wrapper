package com.gamblerstools.betfair.toolkit.exception;

public class SessionException extends BetfairException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634252276260581546L;

	public SessionException(Throwable e) {
		super(e);
	}

	public SessionException() {
		super();
	}

	public SessionException(String string) {
		super(string);
	}

	public SessionException(String message, Throwable e) {
		super(message, e);
	}

}
