package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

public class Network {

	public String name;
	public int id;
	public int code;
	public boolean done =false;
	public String url;
	public LatLng center;
	
	public Network done() {
		this.done = true;
		return this;
	}
	
	public Network(String name, int id, int code, double lat, double lng) {
		this.name = name;
		this.id = id;
		this.code = code;
		center = new LatLng(lat, lng);
	}
	
	public Network set(String url) {
		this.url = url;
		return this;
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
