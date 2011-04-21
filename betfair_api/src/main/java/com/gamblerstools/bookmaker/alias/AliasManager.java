package com.gamblerstools.bookmaker.alias;

public interface AliasManager {
/*
 * 	private Publisher publisher;
	private String aliasId;
	private String aliasName;
	private AliasType type;
 */
	public Publisher lookupPublisher(String publisherId);
	public Alias lookupAlias(Publisher p, AliasType type, String commonName) throws NoSuchAliasException;
	public Alias lookupAlias(Publisher p, AliasType type, String commonName, int commonId) throws NoSuchAliasException;
	public Alias lookupCommonName(Publisher p, AliasType type, String aliasName) throws NoSuchAliasException;
	public Alias lookupCommonName(Publisher p, AliasType type, String aliasName, String aliasId) throws NoSuchAliasException;
}
