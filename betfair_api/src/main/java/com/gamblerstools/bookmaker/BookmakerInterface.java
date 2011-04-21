package com.gamblerstools.bookmaker;

import java.util.Calendar;
import java.util.List;

import com.gamblerstools.betfair.toolkit.exception.BetfairException;

public interface BookmakerInterface {
	public boolean login(String user, String password) throws BookmakerException;
	public boolean logout() throws BookmakerException;
	
	public List<Market> getMarkets(Sport sport, Calendar date) throws BookmakerException;
	public List<Event> getEvents(Sport sport) throws BookmakerException;
}
