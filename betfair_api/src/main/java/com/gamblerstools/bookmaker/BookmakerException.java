package com.gamblerstools.bookmaker;

public class BookmakerException extends Exception {

	public BookmakerException(Throwable e) {
		super(e);
	}

	public BookmakerException() {
		super();
	}

	public BookmakerException(String string) {
		super(string);
	}

	public BookmakerException(String message, Throwable e) {
		super(message,e);
	}

}
