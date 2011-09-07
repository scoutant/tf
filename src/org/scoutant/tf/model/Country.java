package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A Country is a set of networks. A network standing for a set of road around a city.
 */
public class Country {

	public List<Network> _networks = new ArrayList<Network>() ;
	
	public Country add(Network network) {
		_networks.add( network);
		return this;
	}
	
	public Network network(int location) {
		return _networks.get(location);
	}
	public List<Network> networks() { return _networks; }
	
	public String toString(){
		String str="";
		for(Network network : networks()) {
			str += network + "\n";
		}
		return str;
	}
	
	public Network find(String name) {
		for (Network n : _networks) {
			if (n.name.equals( name)) {
				return n;
			}
		}
		return null;
	}
	
}
