package com.gamblerstools.betfair.toolkit.exception.market;

public class MarketSuspendedException extends BetfairMarketException {

	public MarketSuspendedException(Throwable e) {
		super(e);
	}

	public MarketSuspendedException() {
		super();
	}

	public MarketSuspendedException(String string) {
		super(string);
	}

	public MarketSuspendedException(String message, Throwable e) {
		super(message, e);
	}

}
