package com.gamblerstools.bookmaker.alias;

public class Alias {
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public int getCommonId() {
		return commonId;
	}
	public void setCommonId(int commonId) {
		this.commonId = commonId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commmonName) {
		this.commonName = commmonName;
	}
	public String getAliasId() {
		return aliasId;
	}
	public void setAliasId(String aliasId) {
		this.aliasId = aliasId;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public AliasType getType() {
		return type;
	}
	public void setType(AliasType type) {
		this.type = type;
	}
	private Publisher publisher;
	private int commonId;
	private String commonName;
	private String aliasId;
	private String aliasName;
	private AliasType type;
}
