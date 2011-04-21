package com.gamblerstools.bookmaker.alias;

public class NoSuchAliasException extends Exception {

	public NoSuchAliasException(Publisher p, AliasType type, String aliasName,
			String aliasId) {
		super("Aliasname: "+aliasName+", AliasId: "+aliasId+
				", Publisher: "+p.toString()+", Type: "+type.toString());
	}

	public NoSuchAliasException(Publisher p, AliasType type, String aliasName) {
		super("Aliasname: "+aliasName+
				", Publisher: "+p.toString()+", Type: "+type.toString());
	}

	public NoSuchAliasException(Publisher p, AliasType type, String commonName,
			int commonId) {
		super("CommonName: "+commonName+", CommonId: "+commonId+
				", Publisher: "+p.toString()+", Type: "+type.toString());
	}

}
