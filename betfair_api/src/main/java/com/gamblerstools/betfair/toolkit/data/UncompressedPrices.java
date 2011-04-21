package com.gamblerstools.betfair.toolkit.data;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import com.Ostermiller.util.BadDelimiterException;
import com.Ostermiller.util.CSVParser;
import com.betfair.service.exchange.BFExchangeServiceStub.MarketStatusEnum;

public class UncompressedPrices {
	private int marketId;
	private String currency;
	private MarketStatusEnum marketStatus;
	private int inPlayDelay;
	private int numberOfWinners;
	private String marketInformation;
	private boolean discountAllowed;
	private double marketBaseRate;
	private long lastRefresh;
	private boolean bspMarket;
	private Collection<UncompressedRunner> runners;
	
	public UncompressedPrices(String data) {
		//
		/**
		 * 20879651~
		 * GBP~
		 * ACTIVE~
		 * 0~
		 * 1~
		 * <additionalinfo>Further additions considered on request.<br>~
		 * true~
		 * 5.0~
		 * 1219591745226~
		 * ~
		 * N
		 */
		try {
			String[] runnerInformation = CSVParser.parse(new StringReader(data), ':')[0];
			String[] marketData = CSVParser.parse(new StringReader(runnerInformation[0]), '~')[0];
			if(marketData.length!=11) {
				throw new IllegalArgumentException("UncompressedPrices.Constructor invalid market data length "+marketData.length);
			}
			int i=0;
			setMarketId(Integer.parseInt(marketData[i++]));
			setCurrency(marketData[i++]);
			setMarketStatus(MarketStatusEnum.Factory.fromValue(marketData[i++]));
			setInPlayDelay(Integer.parseInt(marketData[i++]));
			setNumberOfWinners(Integer.parseInt(marketData[i++]));
			setMarketInformation(marketData[i++]);
			setDiscountAllowed(marketData[i++].equalsIgnoreCase("true"));
			setMarketBaseRate(Double.parseDouble(marketData[i++]));
			setLastRefresh(Long.parseLong(marketData[i++]));
			//NonRunners
			parseNonRunners(marketData[i++]);
			setBspMarket(marketData[i++].equalsIgnoreCase("Y"));
			Collection<UncompressedRunner> uncompressedRunners = new ArrayList<UncompressedRunner>();
			for(int j=1; j<runnerInformation.length;j++) {
				uncompressedRunners.add(new UncompressedRunner(runnerInformation[j]));
			}
			setRunners(uncompressedRunners);
			
			//System.out.println(nonRunnerInformation[0]);
		} catch (BadDelimiterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//:1225831~0~7564.46~7.4~~~false~~~~|7.4~45.94~L~1~7.2~163.78~L~2~7.0~247.16~L~3~|7.6~113.08~B~1~7.8~14.0~B~2~8.0~47.0~B~3~:2085754~1~13104.44~7.4~~~false~~~~|7.4~61.69~L~1~7.2~196.41~L~2~7.0~117.01~L~3~|7.6~24.75~B~1~8.0~2.0~B~2~8.2~50.0~B~3~:1412558~2~8773.28~11.0~~~false~~~~|10.0~57.68~L~1~9.8~25.0~L~2~9.6~93.44~L~3~|11.0~4.0~B~1~11.5~3.0~B~2~12.0~105.0~B~3~:2371307~3~3313.46~13.5~~~false~~~~|13.5~48.39~L~1~13.0~61.0~L~2~12.5~45.65~L~3~|14.5~90.49~B~1~15.0~27.5~B~2~17.5~2.0~B~3~:1213594~4~1416.32~18.0~~~false~~~~|18.0~5.49~L~1~17.5~19.1~L~2~17.0~17.64~L~3~|19.0~28.0~B~1~19.5~4.0~B~2~20.0~21.28~B~3~:2774541~5~2413.64~15.0~~~false~~~~|15.0~39.5~L~1~14.5~28.16~L~2~14.0~75.0~L~3~|16.5~23.93~B~1~17.0~9.0~B~2~18.0~10.0~B~3~:373631~6~2691.6~19.0~~~false~~~~|18.5~18.04~L~1~18.0~14.0~L~2~17.5~12.0~L~3~|20.0~24.95~B~1~21.0~22.99~B~2~23.0~11.0~B~3~:1300501~7~3313.58~22.0~~~false~~~~|21.0~46.47~L~1~20.0~15.0~L~2~19.0~34.87~L~3~|24.0~2.0~B~1~25.0~20.0~B~2~75.0~6.0~B~3~:2206579~8~1308.36~26.0~~~false~~~~|25.0~3.0~L~1~23.0~46.31~L~2~22.0~4.0~L~3~|26.0~4.57~B~1~27.0~52.11~B~2~32.0~14.0~B~3~:2682294~9~2577.46~30.0~~~false~~~~|28.0~28.63~L~1~26.0~25.0~L~2~24.0~48.77~L~3~|30.0~10.91~B~1~32.0~36.4~B~2~34.0~25.0~B~3~:2348111~10~824.86~42.0~~~false~~~~|38.0~7.57~L~1~36.0~9.41~L~2~34.0~15.0~L~3~|42.0~2.0~B~1~46.0~4.54~B~2~70.0~2.0~B~3~:2295231~11~432.28~50.0~~~false~~~~|50.0~32.57~L~1~46.0~5.35~L~2~44.0~30.39~L~3~|75.0~5.9~B~1~100.0~11.99~B~2~490.0~6.0~B~3~:1464389~12~342.58~65.0~~~false~~~~|65.0~15.37~L~1~50.0~17.86~L~2~40.0~3.04~L~3~|90.0~13.96~B~1~200.0~2.0~B~2~:1412555~13~409.54~75.0~~~false~~~~|50.0~36.23~L~1~36.0~5.0~L~2~34.0~12.0~L~3~|75.0~2.32~B~1~80.0~5.0~B~2~90.0~7.98~B~3~:1450309~14~470.2~80.0~~~false~~~~|55.0~24.1~L~1~48.0~13.0~L~2~40.0~40.0~L~3~|100.0~20.0~B~1~110.0~2.79~B~2~120.0~10.0~B~3~:1188946~15~273.1~50.0~~~false~~~~|44.0~42.3~L~1~42.0~11.27~L~2~34.0~32.0~L~3~|85.0~30.0~B~1~95.0~15.32~B~2~120.0~2.31~B~3~:2026876~16~1805.7~38.0~~~false~~~~|34.0~10.0~L~1~32.0~17.0~L~2~28.0~3.0~L~3~|46.0~5.0~B~1~48.0~8.0~B~2~50.0~5.0~B~3~:2669454~17~175.4~100.0~~~false~~~~|140.0~6.39~L~1~130.0~16.0~L~2~120.0~9.92~L~3~|:2019311~18~558.94~120.0~~~false~~~~|75.0~2.09~L~1~70.0~31.64~L~2~46.0~20.0~L~3~|520.0~2.0~B~1~1000.0~2.0~B~2~:2578077~19~37.3~130.0~~~false~~~~|130.0~16.85~L~1~100.0~4.75~L~2~60.0~8.0~L~3~|250.0~4.85~B~1~:236999~20~42.0~130.0~~~false~~~~|130.0~5.78~L~1~120.0~8.33~L~2~90.0~5.5~L~3~|:1536199~21~45.98~140.0~~~false~~~~|140.0~17.99~L~1~110.0~4.5~L~2~65.0~7.5~L~3~|840.0~3.0~B~1~1000.0~2.0~B~2~:834040~22~32.0~140.0~~~false~~~~|140.0~21.17~L~1~110.0~4.69~L~2~60.0~8.0~L~3~|570.0~2.0~B~1~:1216681~23~27.5~300.0~~~false~~~~|140.0~20.39~L~1~120.0~4.0~L~2~110.0~10.0~L~3~|300.0~2.25~B~1~:2809989~24~187.26~75.0~~~false~~~~|70.0~3.29~L~1~65.0~15.0~L~2~60.0~16.0~L~3~|100.0~12.43~B~1~140.0~2.93~B~2~:424423~25~101.9~70.0~~~false~~~~|90.0~5.96~L~1~80.0~18.0~L~2~60.0~15.33~L~3~|120.0~3.05~B~1~750.0~2.0~B~2~:1170593~26~0.0~~~~false~~~~|170.0~18.4~L~1~160.0~2.13~L~2~130.0~3.75~L~3~|:238864~27~31.0~90.0~~~false~~~~|110.0~26.93~L~1~80.0~6.0~L~2~70.0~20.75~L~3~|500.0~3.5~B~1~:1526551~28~0.0~~~~false~~~~|260.0~3.01~L~1~250.0~3.0~L~2~220.0~12.54~L~3~|:1143740~29~56.0~200.0~~~false~~~~|150.0~5.19~L~1~140.0~3.0~L~2~110.0~4.5~L~3~|:2682181~30~9.5~180.0~~~false~~~~|200.0~2.38~L~1~190.0~18.0~L~2~180.0~5.55~L~3~|500.0~3.19~B~1~:1323979~31~25.82~120.0~~~false~~~~|150.0~6.69~L~1~140.0~19.0~L~2~130.0~7.69~L~3~|500.0~3.0~B~1~720.0~4.0~B~2~730.0~2.0~B~3~:1466828~32~16.62~170.0~~~false~~~~|180.0~4.24~L~1~170.0~18.58~L~2~160.0~6.25~L~3~|:118349~33~27.66~100.0~~~false~~~~|100.0~34.11~L~1~60.0~2.0~L~2~50.0~9.39~L~3~|550.0~2.4~B~1~980.0~5.0~B~2~:689452~34~67.0~130.0~~~false~~~~|130.0~7.01~L~1~65.0~6.0~L~2~44.0~10.33~L~3~|390.0~4.0~B~1~500.0~3.0~B~2~650.0~4.0~B~3~:1136067~35~39.92~160.0~~~false~~~~|160.0~21.0~L~1~150.0~2.0~L~2~46.0~7.0~L~3~|300.0~2.0~B~1~400.0~2.0~B~2~500.0~2.0~B~3~
		
		//System.out.println(data);
	}
	


	private void parseNonRunners(String string) {
		// TODO Auto-generated method stub
		Logger.getAnonymousLogger().info("Non Runners still not implemented "+string);
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrency() {
		return currency;
	}
	public void setMarketStatus(MarketStatusEnum marketStatus) {
		this.marketStatus = marketStatus;
	}
	public MarketStatusEnum getMarketStatus() {
		return marketStatus;
	}
	public void setInPlayDelay(int inPlayDelay) {
		this.inPlayDelay = inPlayDelay;
	}
	public int getInPlayDelay() {
		return inPlayDelay;
	}
	public void setNumberOfWinners(int numberOfWinners) {
		this.numberOfWinners = numberOfWinners;
	}
	public int getNumberOfWinners() {
		return numberOfWinners;
	}
	public void setMarketInformation(String marketInformation) {
		this.marketInformation = marketInformation;
	}
	public String getMarketInformation() {
		return marketInformation;
	}
	public void setDiscountAllowed(boolean discountAllowed) {
		this.discountAllowed = discountAllowed;
	}
	public boolean isDiscountAllowed() {
		return discountAllowed;
	}
	public void setMarketBaseRate(double marketBaseRate) {
		this.marketBaseRate = marketBaseRate;
	}
	public double getMarketBaseRate() {
		return marketBaseRate;
	}
	public void setLastRefresh(long lastRefresh) {
		this.lastRefresh = lastRefresh;
	}
	public long getLastRefresh() {
		return lastRefresh;
	}

	public void setBspMarket(boolean bspMarket) {
		this.bspMarket = bspMarket;
	}

	public boolean isBspMarket() {
		return bspMarket;
	}



	public void setRunners(Collection<UncompressedRunner> runners) {
		this.runners = runners;
	}



	public Collection<UncompressedRunner> getRunners() {
		return runners;
	}
	
	
}
