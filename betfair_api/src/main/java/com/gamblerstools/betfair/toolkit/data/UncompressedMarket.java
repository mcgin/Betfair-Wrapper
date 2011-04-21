package com.gamblerstools.betfair.toolkit.data;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;


public class UncompressedMarket {
	private int marketId;
	private String marketName;
	private String marketType;
	private String marketStatus;
	private long eventDate;
	private String menuPath;
	private String eventHierarchy;
	private String betDelay;
	private int exchangeId;
	private String  iso3CountryCode;
	private long lastRefresh;
	private int numberOfRunners;
	private int numberOfWinners;
	private double totalAmountMatched;
	private boolean bspMarket;
	private boolean turningInPlay;
	
	public UncompressedMarket (String[] params) {
		if(params.length!=16) {
			throw new IllegalArgumentException(this.getClass().getName()+".Constructor invalid arguements " + Arrays.toString(params));
		}
		int i=0;
		setMarketId(Integer.parseInt(params[i++]));
		setMarketName(params[i++]);
		setMarketType(params[i++]);
		setMarketStatus(params[i++]);
		setEventDate(Long.parseLong(params[i++]));
		setMenuPath(params[i++]);
		setEventHierarchy(params[i++]);
		setBetDelay(params[i++]);
		setExchangeId(Integer.parseInt(params[i++]));
		setIso3CountryCode(params[i++]);
		setLastRefresh(Long.parseLong(params[i++]));
		setNumberOfRunners(Integer.parseInt(params[i++]));
		setNumberOfWinners(Integer.parseInt(params[i++]));
		setTotalAmountMatched(Double.parseDouble(params[i++]));
		setBspMarket(params[i++].equalsIgnoreCase("Y"));
		setTurningInPlay(params[i++].equalsIgnoreCase("Y"));
		
	}
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	public String toString() {
		int index = getMenuPath().lastIndexOf("\\");
		String name = index>0?getMenuPath().substring(index+1):getMenuPath();
		Calendar eDate = Calendar.getInstance();
		eDate.setTimeInMillis(getEventDate());
		return dateFormat.format(eDate.getTime())+","+getMarketId() + "," + name;
	}
	
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}
	public String getMarketType() {
		return marketType;
	}
	public void setMarketStatus(String marketStatus) {
		this.marketStatus = marketStatus;
	}
	public String getMarketStatus() {
		return marketStatus;
	}
	public void setEventDate(long eventDate) {
		this.eventDate = eventDate;
	}
	public long getEventDate() {
		return eventDate;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setEventHierarchy(String eventHierarchy) {
		this.eventHierarchy = eventHierarchy;
	}
	public String getEventHierarchy() {
		return eventHierarchy;
	}
	public void setBetDelay(String betDelay) {
		this.betDelay = betDelay;
	}
	public String getBetDelay() {
		return betDelay;
	}
	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}
	public int getExchangeId() {
		return exchangeId;
	}
	public void setIso3CountryCode(String iso3CountryCode) {
		this.iso3CountryCode = iso3CountryCode;
	}
	public String getIso3CountryCode() {
		return iso3CountryCode;
	}
	public void setLastRefresh(long lastRefresh) {
		this.lastRefresh = lastRefresh;
	}
	public long getLastRefresh() {
		return lastRefresh;
	}
	public void setNumberOfRunners(int numberOfRunners) {
		this.numberOfRunners = numberOfRunners;
	}
	public int getNumberOfRunners() {
		return numberOfRunners;
	}
	public void setNumberOfWinners(int numberOfWinners) {
		this.numberOfWinners = numberOfWinners;
	}
	public int getNumberOfWinners() {
		return numberOfWinners;
	}
	public void setTotalAmountMatched(double totalAmountMatched) {
		this.totalAmountMatched = totalAmountMatched;
	}
	public double getTotalAmountMatched() {
		return totalAmountMatched;
	}
	public void setBspMarket(boolean bspMarket) {
		this.bspMarket = bspMarket;
	}
	public boolean isBspMarket() {
		return bspMarket;
	}
	public void setTurningInPlay(boolean turningInPlay) {
		this.turningInPlay = turningInPlay;
	}
	public boolean isTurningInPlay() {
		return turningInPlay;
	}
}
