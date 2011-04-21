package com.gamblerstools.betfair.toolkit.exception;

public class LoginException extends BetfairException {

	public LoginException(Throwable e) {
		super(e);
	}

	public LoginException() {
		super();
	}

	public LoginException(String string) {
		super(string);
	}

	public LoginException(String message, Throwable e) {
		super(message, e);
	}

}
