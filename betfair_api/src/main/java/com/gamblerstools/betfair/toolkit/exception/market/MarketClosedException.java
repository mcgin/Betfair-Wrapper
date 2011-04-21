package com.gamblerstools.betfair.toolkit.exception.market;

public class MarketClosedException extends BetfairMarketException {

	public MarketClosedException(Throwable e) {
		super(e);
		
	}

	public MarketClosedException() {
		super();
	}

	public MarketClosedException(String string) {
		super(string);
		
	}

	public MarketClosedException(String message, Throwable e) {
		super(message, e);
		
	}

}
