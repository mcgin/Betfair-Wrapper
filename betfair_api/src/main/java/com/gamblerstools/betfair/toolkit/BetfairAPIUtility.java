package com.gamblerstools.betfair.toolkit;
//a comment
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Stub;
import org.apache.log4j.Logger;

import com.Ostermiller.util.CSVParser;
import com.betfair.service.exchange.BFExchangeServiceStub;
import com.betfair.service.global.BFGlobalServiceStub;
import com.gamblerstools.betfair.toolkit.data.UncompressedMarket;
import com.gamblerstools.betfair.toolkit.exception.BetfairException;
import com.gamblerstools.betfair.toolkit.exception.SessionException;

/**
 * BetfairAPI
 *
 * @author ajmcgin
 * @version $Id$
 */
public class BetfairAPIUtility {

	private BFGlobalServiceStub globalStub;
	private String session;
	private Map<String, Method> betfairServiceMethods;
	private Properties properties;
	
	private static final String DEFAULT_PROP_FILE = "/betfair_toolkit.properties";
	private static final String PROP_GLOBAL_ENDPOINT = "GLOBAL_ENDPOINT";
	private static Logger logger  = Logger.getLogger(BetfairAPIUtility.class);;
	
	
	public BetfairAPIUtility() {
		Properties p = new Properties();
		try {
			p.load(BetfairAPIUtility.class.getResourceAsStream(DEFAULT_PROP_FILE));
		} catch (Exception e) {
			logger.error("Unable to load properties: "+DEFAULT_PROP_FILE);
		}
		
		loadProperties(p);
		loadStubs();
	}
	public BetfairAPIUtility(Properties props) {
		loadProperties(props);
		loadStubs();
	}
	private void loadProperties(Properties propFile) {
		//InputStream propStream = null;
		//propStream = BetfairAPIUtility.class
		//		.getResourceAsStream(propFile);
		properties = new Properties(propFile);
		/*try {
			if (propStream != null) {
				properties.load(propStream);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/
		//System.out.println(propFile + "Properties size"+properties.size());
		for(Object o:properties.keySet()) {
			logger.debug("Loaded property: "+o.toString()+"\t"+properties.getProperty(o.toString()));
		}
	}
	private void loadStubs() {
		if(globalStub==null) {
			try {
				globalStub = new BFGlobalServiceStub(properties.getProperty(PROP_GLOBAL_ENDPOINT));
			} catch (AxisFault e) {
				throw new RuntimeException(e);
			}
			betfairServiceMethods = new TreeMap<String, Method>();
			
			for (Method m : globalStub.getClass().getMethods()) {
				betfairServiceMethods.put(m.getName(), m);
			}
			for (Method m : Exchange.UK.getStub().getClass().getMethods()) {
				betfairServiceMethods.put(m.getName(), m);
			}
		}
	}
	


	


	public static Collection<UncompressedMarket> uncompressMarkets(
			String marketData) {
		// Parse by : for the markets
		Collection<UncompressedMarket> markets = new ArrayList<UncompressedMarket>();
		try {
			String[] allMarketsString = CSVParser.parse(new StringReader(
					marketData), ':')[0];
			for (String marketString : allMarketsString) {
				if (marketString != null && marketString.length() != 0) {
					String[] marketDataString = CSVParser.parse(
							new StringReader(marketString), '~')[0];
					markets.add(new UncompressedMarket(marketDataString));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return markets;
	}

	@SuppressWarnings("unchecked")
	public synchronized Object invokeBetfairService(Service service,
			int exchangeId, Map<String, Object> params) throws BetfairException {

		long startTime = System.currentTimeMillis();
		String errorClassName = service.getServiceErrorEnumClass();
		String msgClassName = service.getServiceMessageClass();
		String requestClassName = service.getServiceRequestClass();
		String serviceName = service.getServiceName();

		// Setup the stub
		Stub stub = lookupExchange(exchangeId).getId() == exchangeId ? lookupExchange(
				exchangeId).getStub()
				: globalStub;

		Object returnObject = null;
		try {
			Class messageClass = Class.forName(stub.getClass()
					.getCanonicalName()
					+ "$" + msgClassName);
			Class requestClass = Class.forName(stub.getClass()
					.getCanonicalName()
					+ "$" + requestClassName);
			Object msgObject = messageClass.newInstance();
			Object requestObject = requestClass.newInstance();
			for (String key : params.keySet()) {
				Class paramClass = params.get(key).getClass();

				if (paramClass.equals(Integer.class))
					paramClass = Integer.TYPE;
				else if (paramClass.equals(Byte.class))
					paramClass = Byte.TYPE;
				else if (paramClass.equals(Short.class))
					paramClass = Short.TYPE;
				else if (paramClass.equals(Character.class))
					paramClass = Character.TYPE;
				else if (paramClass.equals(Long.class))
					paramClass = Long.TYPE;
				else if (paramClass.equals(Float.class))
					paramClass = Float.TYPE;
				else if (paramClass.equals(Double.class))
					paramClass = Double.TYPE;
				else if (paramClass.equals(Boolean.class))
					paramClass = Boolean.TYPE;
				else if (paramClass.equals(java.util.GregorianCalendar.class))
					paramClass = java.util.Calendar.class;

				Method setMethod = requestClass.getMethod("set" + key,
						paramClass);
				setMethod.invoke(requestObject, params.get(key));
			}

			Method setRequest = messageClass.getMethod("setRequest",
					requestClass);
			setRequest.invoke(msgObject, requestObject);
			try {
				// Set the session information of the request
				if (session == null && service != Service.login) {
					throw new SessionException(service.getServiceName()
							+ ": No valid session");
				}
				Class apiHeaderClass = Class.forName(stub.getClass()
						.getCanonicalName()
						+ "$APIRequestHeader");
				Object apiHeaderObject = apiHeaderClass.newInstance();
				Method setSessionMethod = apiHeaderClass.getMethod(
						"setSessionToken", String.class);
				setSessionMethod.invoke(apiHeaderObject, session);
				Method setHeaderMethod = requestClass.getMethod("setHeader",
						apiHeaderClass);
				setHeaderMethod.invoke(requestObject, apiHeaderObject);
			} catch (NoSuchMethodException e) {
				// setHeader Method doesn't exist for Login
				logger.debug(requestClassName + " has no setHeader method: "
						+ e.getMessage());
			}

			Method method = betfairServiceMethods.get(serviceName);
			Object response = method.invoke(stub, msgObject);
			Method resultMethod = response.getClass().getMethod("getResult",
					null);

			Object responseObject = resultMethod.invoke(response, null);
			Method headerMethod = responseObject.getClass().getMethod(
					"getHeader", null);
			Object headerObject = headerMethod.invoke(responseObject, null);
			Method sessionMethod = headerObject.getClass().getMethod(
					"getSessionToken", null);
			session = (String) sessionMethod.invoke(headerObject, null);

			try {
				Method errorCodeMethod = responseObject.getClass().getMethod(
						"getErrorCode", null);
				Object errorCode = errorCodeMethod.invoke(responseObject, null);

				Class errorClass = Class.forName(stub.getClass()
						.getCanonicalName()
						+ "$" + errorClassName);
				Field okField = errorClass.getField("OK");
				Field apiErrorField = errorClass.getField("API_ERROR");

				if (apiErrorField.get(errorCode).equals(errorCode)) {
					// TODO: API_ERRORS need to be handled separate to service
					// errors.
					// TODO: ErrorCode is API_ERROR, Minor Error Code defines
					// the actual error.
					String apiCodeString = "";
					try {
						Method apiCodeMethod = headerObject.getClass()
								.getMethod("getErrorCode", null);
						Object apiCode = apiCodeMethod.invoke(headerObject,
								null);

						apiCodeString = apiCode.toString();
						logger.debug("APIErrorCode is " + apiCodeString);
						
						
					} catch (Exception e) {
						// TODO: Handle the error
						logger.debug(e.toString(), e);
					}
					throw BetfairException.handleError(service, errorCode,
							apiCodeString, errorCode.toString()
									+ " Minor Error Code:" + apiCodeString);
				} else if (!okField.get(errorCode).equals(errorCode)) {
					String minorCodeString = "";
					try {
						Method minorCodeMethod = responseObject.getClass()
								.getMethod("getMinorErrorCode", null);
						Object minorCode = minorCodeMethod.invoke(
								responseObject, null);
						// minorCode can be null
						if (minorCode != null) {
							minorCodeString = minorCode.toString();
						}

						logger.debug("MinorErrorCode is " + minorCodeString);
					} catch (Exception e) {
						// Ignore Exception, not all services have a minor code
						logger.debug(e.toString(), e);
					}
					throw BetfairException.handleError(service, errorCode,
							minorCodeString, errorCode.toString() + " Minor:"
									+ minorCodeString);
				}
			} catch (NoSuchMethodException e) {
				logger.debug(requestClassName + " has no getErrorCode method: "
						+ e.getMessage());
			}
			returnObject = resultMethod.invoke(response, null);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		logger.debug(serviceName + " took " + (endTime - startTime));
		return returnObject;
	}



	/**
	 * Determine the exchange from the id
	 *
	 * @param id
	 *            the exchangeId to lookup
	 * @return an Exchange corresponding to the id. If no match is found then
	 *         default to the UK
	 */
	public static Exchange lookupExchange(int id) {
		for (Exchange e : Exchange.values()) {
			if (e.exchangeId == id) {
				return e;
			}
		}
		return Exchange.UK;
	}
	
	public enum Exchange {
		UK(1, "https://api.betfair.com/exchange/v5/BFExchangeService"), 
		AU(2, "https://api-au.betfair.com/exchange/v5/BFExchangeService");
		private final String url;
		private final int exchangeId;
		private final BFExchangeServiceStub stub;

		Exchange(int id, String endpoint) {
			url = endpoint;
			exchangeId = id;
			try {
				stub = new BFExchangeServiceStub(url);
			} catch (AxisFault e) {
				throw new RuntimeException(e);
			}

		}

		public BFExchangeServiceStub getStub() {
			return stub;
		}

		public String getUrl() {
			return url;
		}

		public int getId() {
			return exchangeId;
		}

	}

	public static enum Service {
		// General API Services
		// General API Services
		login("login", "LoginErrorEnum", "Login", "LoginReq"), keepAlive(
				"keepAlive", "KeepAliveErrorEnum", "KeepAlive", "KeepAliveReq"), logout(
				"logout", "LogoutErrorEnum", "Logout", "LogoutReq"),
		// Read Only services
		convertCurrency("convertCurrency", "ConvertCurrencyErrorEnum",
				"ConvertCurrency", "ConveryCurrencyReq"), getActiveEventTypes(
				"getActiveEventTypes", "GetEventsErrorEnum",
				"GetActiveEventTypes", "GetEventTypesReq"), getAllCurrencies(
				"getAllCurrencies", "GetAllCurrenciesErrorEnum",
				"GetAllCurrencies", "GetCurrenciesReq"), getAllEventTypes(
				"getAllEventTypes", "GetEventsErrorEnum", "GetAllEventTypes",
				"GetEventTypesReq"), getAllMarkets("getAllMarkets",
				"GetAllMarketsErrorEnum", "GetAllMarkets", "GetAllMarketsReq"), getBet(
				"getBet", "GetBetErrorEnum", "GetBet", "GetBetReq"), getBetHistory(
				"getBetHistory", "GetBetHistoryErrorEnum", "GetBetHistory",
				"GetBetHistoryReq"), getBetLite("getBetLite",
				"GetBetErrorEnum", "GetBetLite", "GetBetLiteReq"), getBetMatchesLite(
				"getBetMatchesLite", "GetBetErrorEnum", "GetBetMatchesLite",
				"GetBetMatchesLiteReq"), getCompleteMarketPricesCompressed(
				"getCompleteMarketPricesCompressed",
				"GetCompleteMarketPricesErrorEnum",
				"GetCompleteMarketPricesCompressed",
				"GetCompleteMarketPricesCompressedReq"), getCurrentBets(
				"getCurrentBets", "GetCurrentBetsErrorEnum", "GetCurrentBets",
				"GetCurrentBetsReq"), getCurrentBetsLite("getCurrentBetsLite",
				"GetCurrentBetsErrorEnum", "GetCurrentBetsLite",
				"GetCurrentBetsLiteReq"), getDetailAvailableMarketDepth(
				"getDetailAvailableMarketDepth",
				"GetDetailAvailableMarketDepthErrorEnum",
				"GetDetailAvailableMarketDepth",
				"GetDetailAvailableMarketDepthReq"), getEvents("getEvents",
				"GetEventsErrorEnum", "GetEvents", "GetEventsReq"), getInPlayMarkets(
				"getInPlayMarkets", "GetInPlayMarketsErrorEnum",
				"GetInPlayMarkets", "GetInPlayMarketsReq"), getMarket(
				"getMarket", "GetMarketErrorEnum", "GetMarket", "GetMarketReq"), getMarketInfo(
				"getMarketInfo", "GetMarketErrorEnum", "GetMarketInfo",
				"GetMarketInfoReq"), getMarketPrices("getMarketPrices",
				"GetMarketPricesErrorEnum", "GetMarketPrices",
				"GetMarketPricesReq"), getMarketPricesCompressed(
				"getMarketPricesCompressed", "GetMarketPricesErrorEnum",
				"GetMarketPricesCompressed", "GetMarketPricesCompressedReq"), getMUBets(
				"getMUBets", "GetMUBetsErrorEnum", "GetMUBets", "GetMUBetsReq"), getMUBetsLite(
				"getMUBetsLite", "GetMUBetsErrorEnum", "GetMUBetsLite",
				"GetMUBetsLiteReq"), getMarketProfitAndLoss(
				"getMarketProfitAndLoss", "GetMarketProfitAndLossErrorEnum",
				"GetMarketProfitAndLoss", "GetMarketProfitAndLossReq"), getMarketTradedVolume(
				"getMarketTradedVolume", "GetMarketTradedVolumeErrorEnum",
				"GetMarketTradedVolume", "GetMarketTradedVolumeReq"), getMarketTradedVolumeCompressed(
				"getMarketTradedVolumeCompressed",
				"GetMarketTradedVolumeCompressedErrorEnum",
				"GetMarketTradedVolumeCompressed",
				"GetMarketTradedVolumeCompressedReq"), getPrivateMarkets(
				"getPrivateMarkets", "GetPrivateMarketsErrorEnum",
				"GetPrivateMarkets", "GetPrivateMarketsReq"), getSilks(
				"getSilks", "GetSilksErrorEnum", "GetSilks", "GetSilksReq"),
		// Account Management Services
		addPaymentCard("addPaymentCard", "AddPaymentCardErrorEnum",
				"AddPaymentCard", "AddPaymentCardReq"), deletePaymentCard(
				"deletePaymentCard", "DeletePaymentCardErrorEnum",
				"DeletePaymentCard", "DeletePaymentCardReq"), depositFromPaymentCard(
				"depositFromPaymentCard", "DepositFromPaymentCardErrorEnum",
				"DepositFromPaymentCard", "DepositFromPaymentCardReq"), forgotPassword(
				"forgotPassword", "ForgotPasswordErrorEnum", "ForgotPassword",
				"ForgotPasswordReq"), getAccountFunds("getAccountFunds",
				"GetAccountFundsErrorEnum", "GetAccountFunds",
				"GetAccountFundsReq"), getPaymentCard("getPaymentCard",
				"GetPaymentCardErrorEnum", "GetPaymentCard",
				"GetPaymentCardReq"), getSubscriptionInfo(
				"getSubscriptionInfo", "GetSubscriptionInfoErrorEnum",
				"GetSubscriptionInfo", "GetSubscriptionInfoReq"), modifyPassword(
				"modifyPassword", "ModifyPasswordErrorEnum", "ModifyPassword",
				"ModifyPasswordReq"), modifyProfile("modifyProfile",
				"ModifyProfileErrorEnum", "ModifyProfile", "ModifyProfileReq"), retrieveLIMBMessage(
				"retrieveLIMBMessage", "RetrieveLIMBMessageErrorEnum",
				"RetrieveLIMBMessage", "RetrieveLIMBMessageReq"), selfExclude(
				"selfExclude", "SelfExcludeErrorEnum", "SelfExclude",
				"SelfExcludeReq"), submitLIMBMessage("submitLIMBMessage",
				"SubmitLIMBMessageErrorEnum", "SubmitLIMBMessage",
				"SubmitLIMBMessageReq"), transferFunds("transferFunds",
				"TransferFundsErrorEnum", "TransferFunds", "TransferFundsReq"), updatePaymentCard(
				"updatePaymentCard", "UpdatePaymentCardErrorEnum",
				"UpdatePaymentCard", "UpdatePaymentCardReq"), viewProfile(
				"viewProfile", "ViewProfileErrorEnum", "ViewProfile",
				"ViewProfileReq"), viewReferAndEarn("viewReferAndEarn",
				"ViewReferAndEarnErrorEnum", "ViewReferAndEarn",
				"ViewReferAndEarnReq"), withdrawToPaymentCard(
				"withdrawToPaymentCard", "WithdrawToPaymentCardErrorEnum",
				"WithdrawToPaymentCard", "WithdrawToPaymentCardReq"),
		// Bet Placement API Services
		cancelBets("cancelBets", "CancelBetsErrorEnum", "CancelBets",
				"CancelBetsReq"), placeBets("placeBets", "PlaceBetsErrorEnum",
				"PlaceBets", "PlaceBetsReq"), updateBets("updateBets",
				"UpdateBetsErrorEnum", "UpdateBets", "UpdateBetsReq"), cancelBetsByMarket(
				"cancelBetsByMarket", "CancelBetsByMarketErrorEnum",
				"CancelBetsByMarket", "CancelBetsByMarketReq");

		private final String serviceName;
		private final String serviceErrorEnumClass;
		private final String serviceMessageClass;
		private final String serviceRequestClass;

		Service(String name, String error, String message, String request) {
			serviceName = name;
			serviceErrorEnumClass = error;
			serviceMessageClass = message;
			serviceRequestClass = request;
		}

		public String getServiceName() {
			return serviceName;
		}

		public String getServiceErrorEnumClass() {
			return serviceErrorEnumClass;
		}

		public String getServiceMessageClass() {
			return serviceMessageClass;
		}

		public String getServiceRequestClass() {
			return serviceRequestClass;
		}


	}

	public static BetfairAPIUtility getInstance() {
		return new BetfairAPIUtility();
	}
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
