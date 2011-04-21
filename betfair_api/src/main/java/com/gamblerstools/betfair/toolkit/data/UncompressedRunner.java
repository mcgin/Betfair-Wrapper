package com.gamblerstools.betfair.toolkit.data;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.Ostermiller.util.BadDelimiterException;
import com.Ostermiller.util.CSVParser;

public class UncompressedRunner {
	private int selectionId;
	private int orderIndex;
	private double totalAmountMatched;
	private double lastPriceMatched;
	private double handicap;
	private double  reductionFactor;
	private boolean vacant;
	private double farSPPrice;
	private double nearSPPrice;
	private double actualSPPrice;
	private Map<Double,Double> layPrices;
	private Map<Double,Double> backPrices;


	public UncompressedRunner(String dataString) {
		try {
			String[] runnerData = CSVParser.parse(new StringReader(dataString), '|')[0];
			String[] metaData = CSVParser.parse(new StringReader(runnerData[0]), '~')[0];
			int index=0;
			setSelectionId(Integer.parseInt(metaData[index++]));
			setOrderIndex(Integer.parseInt(metaData[index++]));
			if (!metaData[index++].equals("")) {
				setTotalAmountMatched(Double.parseDouble(metaData[index-1]));
			}
			if (metaData[index++].length()>0) {
				setLastPriceMatched(Double.parseDouble(metaData[index-1]));
			}
			if (!metaData[index++].equals("")) {
				setHandicap(Double.parseDouble(metaData[index-1]));
			}
			if (!metaData[index++].equals("")) {
				setReductionFactor(Double.parseDouble(metaData[index-1]));
			}
			if (!metaData[index++].equals("")) {
				setVacant(metaData[index-1].equalsIgnoreCase("true"));
			}
			if (!metaData[index++].equals("")) {
				setFarSPPrice(Double.parseDouble(metaData[index-1]));
			}
			if (!metaData[index++].equals("")) {
				setNearSPPrice(Double.parseDouble(metaData[index-1]));
			}
			if (!metaData[index++].equals("")) {
				setActualSPPrice(Double.parseDouble(metaData[index-1]));
			}
			
			Map<Double,Double> back = new HashMap<Double,Double>();
			Map<Double,Double> lay = new HashMap<Double,Double>();
			for(int i=1;i<runnerData.length;i++) {
				if ( runnerData[i].length()>0) {
					String[] prices = CSVParser.parse(new StringReader(runnerData[i]), '~')[0];
					int fields = 4;
					for(int j=0;j<prices.length/fields;j++) {
						int mod = 0;
						double price = Double.parseDouble(prices[j*fields+mod++]);
						double amount = Double.parseDouble(prices[j*fields+mod++]);
						if(prices[j*fields+mod++].equalsIgnoreCase("B")) {
							lay.put(price, amount);
						} else if (prices[j*fields+mod-1].equalsIgnoreCase("L")) {
							back.put(price, amount);
						}						
					}
				}
			}
			setBackPrices(back);
			setLayPrices(lay);
			
			
		} catch (BadDelimiterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void setSelectionId(int selectionId) {
		this.selectionId = selectionId;
	}



	public int getSelectionId() {
		return selectionId;
	}



	public void setTotalAmountMatched(double totalAmountMatched) {
		this.totalAmountMatched = totalAmountMatched;
	}



	public double getTotalAmountMatched() {
		return totalAmountMatched;
	}



	public void setLastPriceMatched(double lastPriceMatched) {
		this.lastPriceMatched = lastPriceMatched;
	}



	public double getLastPriceMatched() {
		return lastPriceMatched;
	}



	public void setHandicap(double handicap) {
		this.handicap = handicap;
	}



	public double getHandicap() {
		return handicap;
	}



	public void setReductionFactor(double reductionFactor) {
		this.reductionFactor = reductionFactor;
	}



	public double getReductionFactor() {
		return reductionFactor;
	}



	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}



	public boolean isVacant() {
		return vacant;
	}






	public void setFarSPPrice(double farSPPrice) {
		this.farSPPrice = farSPPrice;
	}



	public double getFarSPPrice() {
		return farSPPrice;
	}



	public void setNearSPPrice(double nearSPPrice) {
		this.nearSPPrice = nearSPPrice;
	}



	public double getNearSPPrice() {
		return nearSPPrice;
	}



	public void setActualSPPrice(double actualSPPrice) {
		this.actualSPPrice = actualSPPrice;
	}



	public double getActualSPPrice() {
		return actualSPPrice;
	}



	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}



	public int getOrderIndex() {
		return orderIndex;
	}



	public  void setLayPrices(Map<Double,Double> layPrices) {
		this.layPrices = layPrices;
	}



	public  Map<Double,Double> getLayPrices() {
		return layPrices;
	}



	public  void setBackPrices(Map<Double,Double> backPrices) {
		this.backPrices = backPrices;
	}



	public  Map<Double,Double> getBackPrices() {
		return backPrices;
	}

}
