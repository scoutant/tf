package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

public class Network {

//	private List<Polyline> _polylines = new ArrayList<Polyline>();
//	
//	public Polyline polyline(int location) {
//		return _polylines.get(location);
//	}
//	public Network add(Polyline item) {
//		_polylines.add(item);
//		return this;
//	}
//	public List<Polyline> polylines() {
//		return _polylines;
//	}
	
	private List<Road> _roads = new ArrayList<Road>();
	public Road road(int location) {
		return _roads.get(location);
	}
	public Network add(Road item) {
		_roads.add(item);
		return this;
	}
	public List<Road> roads() { return _roads; }
	
	
	
}
