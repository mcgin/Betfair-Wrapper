package com.gamblerstools.betfair.toolkit;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.betfair.service.exchange.BFExchangeServiceStub.ArrayOfInt;
import com.betfair.service.exchange.BFExchangeServiceStub.GetAccountFundsResp;
import com.betfair.service.exchange.BFExchangeServiceStub.GetAllMarketsResp;
import com.betfair.service.exchange.BFExchangeServiceStub.GetMarketInfoResp;
import com.betfair.service.exchange.BFExchangeServiceStub.GetMarketPricesCompressedResp;
import com.betfair.service.exchange.BFExchangeServiceStub.GetMarketPricesResp;
import com.betfair.service.exchange.BFExchangeServiceStub.GetMarketResp;
import com.betfair.service.global.BFGlobalServiceStub.EventType;
import com.betfair.service.global.BFGlobalServiceStub.GetEventTypesResp;
import com.betfair.service.global.BFGlobalServiceStub.GetPaymentCardResp;
import com.betfair.service.global.BFGlobalServiceStub.LoginResp;
import com.betfair.service.global.BFGlobalServiceStub.LogoutResp;
import com.betfair.service.global.BFGlobalServiceStub.PaymentCard;
import com.betfair.service.global.BFGlobalServiceStub.ViewProfileResp;
import com.gamblerstools.betfair.toolkit.BetfairAPIUtility.Exchange;
import com.gamblerstools.betfair.toolkit.BetfairAPIUtility.Service;
import com.gamblerstools.betfair.toolkit.data.UncompressedMarket;
import com.gamblerstools.betfair.toolkit.data.UncompressedPrices;
import com.gamblerstools.betfair.toolkit.data.UncompressedRunner;
import com.gamblerstools.betfair.toolkit.exception.BetfairException;

import junit.framework.TestCase;

public class BetfairAPIUtilityTest {
	
	private static Logger logger  = Logger.getLogger(BetfairAPIUtilityTest.class);;

	private BetfairAPIUtility betfairApi;
	private Properties properties;
	

	@Before public void setUp() throws Exception {
		//super.setUp();
		Properties p = new Properties();
		try {
			p.load(BetfairAPIUtilityTest.class.getResourceAsStream("/betfair_toolkit_test.properties"));
		} catch (IOException e) {
			//fail("Unable to load test properties");
		}
		betfairApi = new BetfairAPIUtility(p);
	}
	
	@After public void tearDown() {
		//betfairApi.logoff();
	}


	@Test
	public void testLogin() {
		
	}

/*
	public void testSomething() {
		
		try {
			//System.out.println(Exchange.AU.getUrl());
			Map<String, Object> params = new HashMap<String, Object>();

			//betfairApi.login(properties.getProperty("User"),properties.getProperty(""));
			

			
			betfairApi.invokeBetfairService(Service.keepAlive, 0, params);

			// Not supported in free API
			// params.put("Amount", 21d);
			// params.put("FromCurrency", "USD");
			// params.put("ToCurrency", "GBP");
			// ConvertCurrencyResp convertCurrencyResp =
			// (ConvertCurrencyResp)callGlobalService
			// ("convertCurrency",params,"ConvertCurrencyErrorEnum"
			// ,"ConvertCurrency","ConvertCurrencyReq");
			ArrayOfInt ints = new ArrayOfInt();
			int[] intArray = { 7 };
			ints.set_int(intArray);
			// Test getAllMarkets
			params.put("EventTypeIds", ints);
			GetAllMarketsResp getAllMarketsResp = (GetAllMarketsResp) betfairApi.invokeBetfairService(
					Service.getAllMarkets, 1, params);
			logger.info(getAllMarketsResp.getMarketData());
			// logger.info(getAllMarketsResp.getErrorCode());
			Collection<UncompressedMarket> unCompressedMarkets = betfairApi.uncompressMarkets(getAllMarketsResp
					.getMarketData());
			UncompressedMarket selectedMarket = null;
			for (UncompressedMarket market : unCompressedMarkets) {
				if (market.getMarketStatus().equalsIgnoreCase("ACTIVE")) {
					selectedMarket = market;
					break;
				}
			}
			// Test getMarket
			params = new HashMap<String, Object>();
			params.put("MarketId", new Integer(selectedMarket.getMarketId()));

			GetMarketResp getMarketResp = (GetMarketResp) betfairApi.invokeBetfairService(
					Service.getMarket, selectedMarket.getExchangeId(), params);
			// Test getMarketPrices
			GetMarketPricesResp getMarketPricesResp = (GetMarketPricesResp) betfairApi.invokeBetfairService(
					Service.getMarketPrices, selectedMarket.getExchangeId(),
					params);
			logger.info(getMarketPricesResp.getMarketPrices().getMarketInfo());

			// Test getMarketInfo

			for (int i = 0; i < 7; i++) {
				GetMarketInfoResp getMarketInfoResp = (GetMarketInfoResp) betfairApi.invokeBetfairService(
						Service.getMarketInfo, selectedMarket.getExchangeId(),
						params);

				logger.info(getMarketInfoResp.getMarketLite().getMarketTime());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Test getMarketPricesCompressed
			GetMarketPricesCompressedResp getMarketPricesCompressedResp = (GetMarketPricesCompressedResp) betfairApi.invokeBetfairService(
					Service.getMarketPricesCompressed, selectedMarket
							.getExchangeId(), params);

			UncompressedPrices uncompressedPrices = new UncompressedPrices(
					getMarketPricesCompressedResp.getMarketPrices());
			logger.info(uncompressedPrices.getMarketId());
			for (UncompressedRunner runner : uncompressedPrices.getRunners()) {
				logger.info("Runner: " + runner.getSelectionId()
						+ "\tLast Matched: " + runner.getLastPriceMatched());
				logger.info("BackPrices: " + runner.getBackPrices().toString());
				logger.info("LayPrices: " + runner.getLayPrices().toString());
			}

			// Test getAccountFunds
			params = new HashMap<String, Object>();
			GetAccountFundsResp getAccountFundsResp = (GetAccountFundsResp) betfairApi.invokeBetfairService(
					Service.getAccountFunds, 2, params);

			logger.info(getAccountFundsResp.getBalance());

			GetEventTypesResp getActiveEventTypesResp = (GetEventTypesResp) betfairApi.invokeBetfairService(
					Service.getActiveEventTypes, 0, params);
			GetEventTypesResp getAllEventTypesResp = (GetEventTypesResp) betfairApi.invokeBetfairService(
					Service.getAllEventTypes, 0, params);
			for (EventType et : getActiveEventTypesResp.getEventTypeItems()
					.getEventType()) {
				 logger.debug(et.getName());
			}

			GetPaymentCardResp getPaymentCardResp = (GetPaymentCardResp) betfairApi.invokeBetfairService(
					Service.getPaymentCard, 0, params);
			for (PaymentCard card : getPaymentCardResp.getPaymentCardItems()
					.getPaymentCard()) {
				// logger.debug(card.getNickName());
			}
			ViewProfileResp viewProfileResp = (ViewProfileResp) betfairApi.invokeBetfairService(
					Service.viewProfile, 0, params);
			logger.debug(viewProfileResp.getFirstName());

			params = new HashMap<String, Object>();
			LogoutResp logoutResp = (LogoutResp) betfairApi.invokeBetfairService(
					Service.logout, 0, params);

			logger.debug("DONE");
		} catch (BetfairException be) {
			// TODO: Handle exception
			logger.info("Exception thrown in main execution");
			be.printStackTrace();
		}
	}
*/
}
