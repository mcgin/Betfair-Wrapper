package com.gamblerstools.bookmaker.alias;

import java.util.HashSet;
import java.util.Set;

public class InMemoryAliasManager implements AliasManager{
	private Set<Alias> aliasCollection;
	private Set<Publisher> publishers;
	
	public InMemoryAliasManager() {
		aliasCollection = new HashSet<Alias>();
		initialize();
	}
	
	private void initialize() {
		Publisher publisher = new Publisher();
		publisher.setId("betfair.com");
		publisher.setName("Betfair");
		publishers.add(publisher);
		
		Alias a;
		
		a = new Alias();
		a.setAliasId("7");
		a.setAliasName("Horse Racing");
		a.setCommonName(a.getAliasName());
		a.setCommonId(17);
		a.setPublisher(lookupPublisher("betfair.com"));
		a.setType(AliasType.SPORT);
		
		aliasCollection.add(a);
	}

	public Alias lookupAlias(Publisher p, AliasType type, String commonName)  throws NoSuchAliasException{
		for(Alias a:aliasCollection) {
			if(a.getPublisher().equals(p) && a.getType().equals(type) 
					&& a.getCommonName().equals(commonName) ) {
				return a;
			}
		}
		throw new NoSuchAliasException(p, type, commonName);	}

	public Alias lookupAlias(Publisher p, AliasType type, String commonName,
			int commonId)  throws NoSuchAliasException{
		for(Alias a:aliasCollection) {
			if(a.getPublisher().equals(p) && a.getType().equals(type) 
					&& a.getCommonName().equals(commonName) && a.getCommonId()==commonId ) {
				return a;
			}
		}
		throw new NoSuchAliasException(p, type, commonName, commonId);
	}

	public Alias lookupCommonName(Publisher p, AliasType type, String aliasName)
			throws NoSuchAliasException {
		// TODO Auto-generated method stub
		return null;
	}

	public Alias lookupCommonName(Publisher p, AliasType type,
			String aliasName, String aliasId) throws NoSuchAliasException {
		// TODO Auto-generated method stub
		return null;
	}

	public Publisher lookupPublisher(String publisherId) {
		// TODO Auto-generated method stub
		return null;
	}


}

/*
Alias Id	Alias Name	Publisher	Common Id	Common Name
1477	Rugby League	betfair.com	1	Rugby League
3503	Darts	betfair.com	2	Darts
3988	Athletics	betfair.com	3	Athletics
4339	Greyhound Racing	betfair.com	4	Greyhound Racing
6422	Snooker	betfair.com	5	Snooker
6423	American Football	betfair.com	6	American Football
7511	Baseball	betfair.com	7	Baseball
7522	Basketball	betfair.com	8	Basketball
7523	Hockey	betfair.com	9	Hockey
7524	Ice Hockey	betfair.com	10	Ice Hockey
1	Soccer	betfair.com	11	Soccer
2	Tennis	betfair.com	12	Tennis
3	Golf	betfair.com	13	Golf
4	Cricket	betfair.com	14	Cricket
5	Rugby Union	betfair.com	15	Rugby Union
6	Boxing	betfair.com	16	Boxing
7	Horse Racing	betfair.com	17	Horse Racing
8	Motor Sport	betfair.com	18	Motor Sport
*/