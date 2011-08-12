package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

public class Network {

	
	public String name;
	
	public Network(String name) {
		this.name = name;
	}
	
	private List<Road> _roads = new ArrayList<Road>();
	public Road road(int location) {
		return _roads.get(location);
	}
	public Network add(Road item) {
		_roads.add(item);
		return this;
	}
	public List<Road> roads() { return _roads; }
	
	public String toString() {
		String str= "Network " + name + "\n";
		for(Road road : roads()) {
			str += road + "\n";
		}
		return str;
	}
	
}
