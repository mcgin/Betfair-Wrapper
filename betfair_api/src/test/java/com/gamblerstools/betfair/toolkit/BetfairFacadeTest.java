package com.gamblerstools.betfair.toolkit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.gamblerstools.bookmaker.BookmakerException;
import com.gamblerstools.bookmaker.BookmakerInterface;
import com.gamblerstools.bookmaker.Sport;

public class BetfairFacadeTest {
	BookmakerInterface facade;
	Properties properties;
	
	private static final String PROP_USER = "USER";
	private static final String PROP_PASSWORD = "PASSWORD";
	
	@Before 
	public void setUp() throws Exception {
		//super.setUp();
		properties = new Properties();
		try {
			properties.load(BetfairAPIUtilityTest.class.getResourceAsStream("/betfair_toolkit_test.properties"));
		} catch (IOException e) {
			fail("Unable to load test properties");
		}
		facade = new BetfairFacade();
	}
	
	@Test
	public void testLogin(){
		try {
			assertTrue(facade.login(properties.getProperty(PROP_USER), properties.getProperty(PROP_PASSWORD)));
			assertTrue(facade.logout());
		} catch (BookmakerException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetEvents() {
		try {
			facade.login(properties.getProperty(PROP_USER), properties.getProperty(PROP_PASSWORD));
			facade.getEvents(Sport.HORSE_RACING);
		}catch (BookmakerException e) {
			fail(e.getMessage());
		}
		//facade.
	}
}
