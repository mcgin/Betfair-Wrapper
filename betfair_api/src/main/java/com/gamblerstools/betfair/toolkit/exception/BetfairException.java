package com.gamblerstools.betfair.toolkit.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;
import java.util.SortedMap;

import com.gamblerstools.betfair.toolkit.BetfairAPIUtility.Service;
import com.gamblerstools.bookmaker.BookmakerException;
public class BetfairException extends BookmakerException{
	
	private static SortedMap<String, String> exceptionMap;
	private String errorCode;
	private String minorCode;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMinorCode() {
		return minorCode;
	}
	public void setMinorCode(String minorCode) {
		this.minorCode = minorCode;
	}
	static {
		exceptionMap = new TreeMap<String, String>();
		//TODO: Load exception mapping from prop file
		exceptionMap.put("ACCOUNT_CLOSED", "com.gamblerstools.betfair.toolkit.exception.LoginException");
		exceptionMap.put("ACCOUNT_SUSPENDED", "com.gamblerstools.betfair.toolkit.exception.LoginException");
		exceptionMap.put("BBM_DAEMON_NOT_AVAILABLE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("BET_ID_INVALID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("BET_IN_PROGRESS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("CANNOT_CONVERT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EVENT_CLOSED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EVENT_INACTIVE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EVENT_SUSPENDED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EXCEEDED_THROTTLE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("FAILED_MESSAGE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INTERNAL_ERROR", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_AMOUNT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_ASIAN_LINE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_BET_STATUS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_BET_STATUS_FOR_MARKET", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_COUNTRY_CODE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_CURRENCY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_EVENT_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_EVENT_TYPE_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_FROM_CURRENCY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCAL_DEFAULTING_TO_ENGLISH", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCALE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCALE_DEFAULTING_TO_ENGLISH", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCATION", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_MARKET", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_MARKET_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_MARKET_TYPE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_NUMBER_OF_MARKETS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_NUMER_OF_CANCELLATIONS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_ORDER_BY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_ORDER_BY_FOR_STATUS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_PRODUCT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_RECORD_COUNT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_RUNNER", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_START_RECORD", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_TO_CURRENCY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_USERNAME_OR_PASSWORD", "com.gamblerstools.betfair.toolkit.exception.LoginException");
		exceptionMap.put("INVALID_VENDOR_SOFTWARE_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_FAILED_ACCOUNT_LOCKED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_REQUIRE_TERMS_AND_CONDITIONS_ACCEPTANCE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_RESTRICTED_LOCATION", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_UNAUTHORIZED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_CLOSED", "com.gamblerstools.betfair.toolkit.exception.market.MarketClosedException");
		exceptionMap.put("MARKET_IDS_DONT_MATCH", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_STATUS_INVALID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_TYPE_NOT_SUPPORTED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_RESULT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_RESULTS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_SESSION", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_SILKS_AVAILABLE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("OK", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("OK_MESSAGES", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("POKER_T_AND_C_ACCEPTANCE_REQUIRED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("PRODUCT_REQUIRES_FUNDED_ACCOUNT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SERVICE_NOT_AVAILABLE_FOR_LOGIN_STATUS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SERVICE_NOT_AVAILABLE_IN_PRODUCT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SUBSCRIPTION_INACTIVE_OR_SUSPENDED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SUSPENDED_MARKET", "com.gamblerstools.betfair.toolkit.exception.market.MarketSespendedException");
		exceptionMap.put("T_AND_C_ACCEPTANCE_REQUIRED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("TOO_MANY_BETS_REQUESTED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("TOO_MANY_REQUESTS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("UNSUPPORTED_MARKET_TYPE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("USER_NOT_ACCOUNT_OWNER", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("USER_NOT_SUBSCRIBED_TO_PRODUCT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("VENDOR_SOFTWARE_INACTIVE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("VENDOR_SOFTWARE_INVALID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
	}

	public BetfairException(Throwable e) {
		super(e);
	}
	public BetfairException() {
		super();
	}

	public BetfairException(String string) {
		super(string);
	}
	public BetfairException(String message, Throwable e) {
		super(message,e);
	}
	public static BetfairException handleError(Service service, Object errorCode, String minor, String message)  {
		BetfairException exception = null;
		Class errorClass = errorCode.getClass();
		try {
			
			Method valueMethod = errorClass.getMethod("getValue", null);
			String errorValue = valueMethod.invoke(errorCode, null).toString();
			String exceptionClassString = exceptionMap.get(errorValue);
			//Default to BetfairException
			exceptionClassString = exceptionClassString==null?
					BetfairException.class.getName():exceptionClassString;
			
			Class exceptionClass =  Class.forName(exceptionClassString);
			Constructor con = exceptionClass.getConstructor(String.class);
			Object o = con.newInstance("Error executing " + service.getServiceName() + " : " + message);
			exception = (BetfairException) o;
			exception.setErrorCode(errorValue);
			exception.setMinorCode(minor);

		} catch (Exception e) {
			return new BetfairException(message, e);
		} 
		
		return exception;
		
		
	}
/**
Read only Error Codes
================
		exceptionMap.put("ACCOUNT_CLOSED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("ACCOUNT_SUSPENDED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("BBM_DAEMON_NOT_AVAILABLE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("BET_ID_INVALID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("BET_IN_PROGRESS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("CANNOT_CONVERT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EVENT_CLOSED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EVENT_INACTIVE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EVENT_SUSPENDED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("EXCEEDED_THROTTLE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("FAILED_MESSAGE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INTERNAL_ERROR", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_AMOUNT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_ASIAN_LINE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_BET_STATUS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_BET_STATUS_FOR_MARKET", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_COUNTRY_CODE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_CURRENCY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_EVENT_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_EVENT_TYPE_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_FROM_CURRENCY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCAL_DEFAULTING_TO_ENGLISH", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCALE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCALE_DEFAULTING_TO_ENGLISH", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_LOCATION", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_MARKET", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_MARKET_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_MARKET_TYPE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_NUMBER_OF_MARKETS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_NUMER_OF_CANCELLATIONS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_ORDER_BY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_ORDER_BY_FOR_STATUS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_PRODUCT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_RECORD_COUNT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_RUNNER", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_START_RECORD", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_TO_CURRENCY", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_USERNAME_OR_PASSWORD", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("INVALID_VENDOR_SOFTWARE_ID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_FAILED_ACCOUNT_LOCKED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_REQUIRE_TERMS_AND_CONDITIONS_ACCEPTANCE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_RESTRICTED_LOCATION", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("LOGIN_UNAUTHORIZED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_CLOSED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_IDS_DONT_MATCH", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_STATUS_INVALID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MARKET_TYPE_NOT_SUPPORTED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("MarketDisplayErrorEnum", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_RESULT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_RESULTS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_SESSION", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("NO_SILKS_AVAILABLE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("OK", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("OK_MESSAGES", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("POKER_T_AND_C_ACCEPTANCE_REQUIRED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("PRODUCT_REQUIRES_FUNDED_ACCOUNT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SERVICE_NOT_AVAILABLE_FOR_LOGIN_STATUS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SERVICE_NOT_AVAILABLE_IN_PRODUCT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SUBSCRIPTION_INACTIVE_OR_SUSPENDED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("SUSPENDED_MARKET", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("T_AND_C_ACCEPTANCE_REQUIRED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("TOO_MANY_BETS_REQUESTED", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("TOO_MANY_REQUESTS", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("UNSUPPORTED_MARKET_TYPE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("USER_NOT_ACCOUNT_OWNER", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("USER_NOT_SUBSCRIBED_TO_PRODUCT", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("VENDOR_SOFTWARE_INACTIVE", "com.gamblerstools.betfair.toolkit.exception.BetfairException");
		exceptionMap.put("VENDOR_SOFTWARE_INVALID", "com.gamblerstools.betfair.toolkit.exception.BetfairException");


 */
	/**
KeepAlive
GetAllCurrencies
---------



APIErrorEnum
OK
INTERNAL_ERROR
EXCEEDED_THROTTLE
USER_NOT_SUBSCRIBED_TO_PRODUCT
SUBSCRIPTION_INACTIVE_OR_SUSPENDED
VENDOR_SOFTWARE_INACTIVE
VENDOR_SOFTWARE_INVALID
SERVICE_NOT_AVAILABLE_IN_PRODUCT
NO_SESSION
TOO_MANY_REQUESTS
PRODUCT_REQUIRES_FUNDED_ACCOUNT
SERVICE_NOT_AVAILABLE_FOR_LOGIN_STATUS


LoginErrorEnum (minorErrorCode)
OK
ACCOUNT_CLOSED
ACCOUNT_SUSPENDED
API_ERROR
FAILED_MESSAGE
INVALID_LOCATION
INVALID_PRODUCT
INVALID_USERNAME_OR_PASSWORD
INVALID_VENDOR_SOFTWARE_ID
LOGIN_FAILED_ACCOUNT_LOCKED
LOGIN_REQUIRE_TERMS_AND_CONDITIONS_ACCEPTANCE
LOGIN_RESTRICTED_LOCATION
LOGIN_UNAUTHORIZED
OK_MESSAGES
POKER_T_AND_C_ACCEPTANCE_REQUIRED
T_AND_C_ACCEPTANCE_REQUIRED
USER_NOT_ACCOUNT_OWNER


LogoutErrorEnum
OK
API_ERROR


ConvertCurrencyErrorEnum
OK
API_ERROR
CANNOT_CONVERT
INVALID_AMOUNT
INVALID_FROM_CURRENCY
INVALID_TO_CURRENCY


GetEventsErrorEnum
OK
API_ERROR
INVALID_EVENT_ID
INVALID_LOCALE_DEFAULTING_TO_ENGLISH
NO_RESULTS

GetEventsErrorEnum
OK
API_ERROR
INVALID_EVENT_ID
INVALID_LOCAL_DEFAULTING_TO_ENGLISH
NO_RESULTS


GetAllMarketsErrorEnum
OK
API_ERROR
INVALID_COUNTRY_CODE
INVALID_EVENT_TYPE_ID
INVALID_LOCALE


GetBetErrorEnum
OK
API_ERROR
BET_ID_INVALID
INVALID_LOCALE_DEFAULTING_TO_ENGLISH
MARKET_TYPE_NOT_SUPPORTED
NO_RESULTS


GetBetHistoryErrorEnum
OK
API_ERROR
INVALID_BET_STATUS
INVALID_EVENT_TYPE_ID
INVALID_LOCAL_DEFAULTING_TO_ENGLIGH
INVALID_MARKET_TYPE
INVALID_ORDER_BY
INVALID_RECORD_COUNT
INVALID_START_RECORD
NO_RESULTS


GetCompleteMarketPricesErrorEnum
OK
API_ERROR
INVALID_CURRENCY
INVALID_MARKET
MARKET_TYPE_NOT_SUPPORTED
EVENT_CLOSED
EVENT_SUSPENDED
EVENT_INACTIVE


GetCurrentBetsErrorEnum
OK
API_ERROR
INVALID_BET_STATUS
INVALID_BET_STATUS_FOR_MARKET
INVALID_MARKET_ID
INVALID_ORDER_BY_FOR_STATUS
INVALID_RECORD_COUNT
INVALID_START_RECORD
NO_RESULT



GetDetailedAvailMktDepthErrorEnum
OK
API_ERROR
INVALID_ASIAN_LINE
INVALID_CURRENCY
INVALID_MARKET
INVALID_RUNNER
MARKET_TYPE_NOT_SUPPORTED
NO_RESULTS
SUSPENDED_MARKET


GetEventsErrorEnum
OK
API_ERROR
INVALID_EVENT_ID
INVALID_LOCALE_DEFAULTING_TO_ENGLISH
NO_RESULTS


GetInPlayMarketsErrorEnum
OK
API_ERROR
INVALID_LOCALE

GetMarketErrorEnum
OK
API_ERROR
INVALID_LOCALE_DEFAULTING_TO_ENGLISH
INVALID_MARKET
MARKET_TYPE_NOT_SUPPORTED

GetMarketPricesErrorEnum
OK
API_ERROR
INVALID_CURRENCY
INVALID_MARKET
MARKET_TYPE_NOT_SUPPORTED


GetMUBetsErrorEnum
OK
API_ERROR
INVALID_BET_STATUS
INVALID_MARKET_ID
INVALID_ORDER_BY_FOR_STATUS
INVALID_RECORD_COUNT
INVALID_START_RECORD
NO_RESULT
TOO_MANY_BETS_REQUESTED

GetMarketProfitAndLossErrorEnum
OK
API_ERROR
INVALID_MARKET
MARKET_CLOSED
UNSUPPORTED_MARKET_TYPE


GetMarketTradedVolumeErrorEnum
OK
API_ERROR
INVALID_ASIAN_LINE
INVALID_CURRENCY
INVALID_MARKET
INVALID_RUNNER
MARKET_CLOSED
MARKET_TYPE_NOT_SUPPORTED
NO_RESULTS


GetMarketTradedVolumeCompressedErrorEnum
OK
API_ERROR
INVALID_CURRENCY
INVALID_MARKET
EVENT_CLOSED
EVENT_INACTIVE
EVENT_SUSPENDED
MARKET_TYPE_NOT_SUPPORTED


GetPrivateMarketsErrorEnum
OK
API_ERROR
INVALID_LOCALE
INVALID_EVENT_TYPE_ID
INVALID_MARKET_TYPE
NO_RESULTS


GetSilksErrorEnum
OK
API_ERROR
INVALID_LOCALE
INVALID_NUMBER_OF_MARKETS


MarketDisplayErrorEnum
OK
INVALID_MARKET
NO_SILKS_AVAILABLE


---------------------------------------
CancelBetsErrorEnum
OK
API_ERROR
BET_IN_PROGRESS
BBM_DAEMON_NOT_AVAILABLE
INVALID_MARKET_ID
INVALID_NUMER_OF_CANCELLATIONS
MARKET_IDS_DONT_MATCH
MARKET_STATUS_INVALID
MARKET_TYPE_NOT_SUPPORTED


	 */
}
