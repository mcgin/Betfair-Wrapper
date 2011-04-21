package com.gamblerstools.betfair.toolkit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.betfair.service.global.BFGlobalServiceStub.EventType;
import com.betfair.service.global.BFGlobalServiceStub.GetEventTypesResp;
import com.gamblerstools.betfair.toolkit.BetfairAPIUtility.Service;
import com.gamblerstools.betfair.toolkit.exception.BetfairException;
import com.gamblerstools.bookmaker.BookmakerException;
import com.gamblerstools.bookmaker.BookmakerInterface;
import com.gamblerstools.bookmaker.Event;
import com.gamblerstools.bookmaker.Market;
import com.gamblerstools.bookmaker.Sport;
import com.gamblerstools.bookmaker.alias.AliasManager;
import com.gamblerstools.bookmaker.alias.AliasType;
import com.gamblerstools.bookmaker.alias.InMemoryAliasManager;
import com.gamblerstools.bookmaker.alias.NoSuchAliasException;
import com.gamblerstools.bookmaker.alias.Publisher;

public class BetfairFacade implements BookmakerInterface {

	private static final String PUBLISHER_ID = "betfair.com";
	private static Logger logger  = Logger.getLogger(BetfairFacade.class);
	private AliasManager aliasManager;
	private BetfairAPIUtility API;
	private Publisher publisher;
	
	public BetfairFacade() {
		API = BetfairAPIUtility.getInstance();
		aliasManager = new InMemoryAliasManager();
		publisher = aliasManager.lookupPublisher(PUBLISHER_ID);
	}
	
	public List<Market> getMarkets(Sport sport, Calendar date) throws BookmakerException {
		
		return null;
	}

	public boolean login(String user, String password) throws BookmakerException {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("Username", user);
		// params.put("Username", "a");
		params.put("Password", password);
		params.put("ProductId", Integer.parseInt(API.getProperty("BETFAIR_PRODUCT_ID")));
		params.put("IpAddress", "0");
		try {
			API.invokeBetfairService(Service.login, 0, params);
		} catch (BetfairException e) {
			logger.warn("Unable to login",e);
			return false;
		}
		return true;
	}

	public boolean logout() throws BookmakerException {
		API.invokeBetfairService(Service.logout, 0, new HashMap<String, Object>());
		return true;
	}

	public List<Event> getEvents(Sport sport) throws BookmakerException {
		List<Event> events = new ArrayList<Event>();
		
		try {
			aliasManager.lookupAlias(publisher, AliasType.SPORT, sport.name());
		} catch (NoSuchAliasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GetEventTypesResp resp = (GetEventTypesResp)API.invokeBetfairService(Service.getAllEventTypes, 0, new HashMap<String, Object>());
		for(EventType t:resp.getEventTypeItems().getEventType()) {
			System.out.println(t.getExchangeId()+"\t"+t.getId()+"\t"+t.getName());
		}
		API.invokeBetfairService(Service.getEvents, 0, new HashMap<String, Object>());
		
		return events;
	}

}
