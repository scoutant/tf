package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
	
	private List<LatLng> _points = new ArrayList<LatLng>();
	
	public Polyline(){
	}
	public Polyline( List<LatLng> items){
		this();
		_points = items;
	}
	
	public List<LatLng> points(){
		return _points;
	}
	public LatLng point(int location){
		return _points.get(location);
	}
	public int size(){
		return _points.size();
	}
	public Polyline add(LatLng item) {
		_points.add( item);
		return this;
	}
	
}
