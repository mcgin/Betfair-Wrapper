package com.gamblerstools.betfair.toolkit.exception.market;

import com.gamblerstools.betfair.toolkit.exception.BetfairException;

public class BetfairMarketException extends BetfairException {

	public BetfairMarketException(Throwable e) {
		super(e);
	}

	public BetfairMarketException() {
		super();
	}

	public BetfairMarketException(String string) {
		super(string);
	}

	public BetfairMarketException(String message, Throwable e) {
		super(message, e);
	}

}
