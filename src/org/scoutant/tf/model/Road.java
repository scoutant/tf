package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

public class Road {

	public Polyline polyline = null;
	public String name;
	
	public List<LatLng> points = new ArrayList<LatLng>();

	private List<Pixel> _pixels = new ArrayList<Pixel>();
	public List<Pixel> pixels() { return _pixels; }
	
	public Pixel pixel(int location ) { return _pixels.get(location); }
	
	public Road add(Pixel object) {
		_pixels.add(object);
		return this;
	}
	
	public Road set(String polyline) {
		this.polyline = new Polyline( polyline);
		return this;
	}
	
	public int[][] track;
	
	public Road(String name) {
		this.name = name;
	}
	
	public Road( int[][] track) {
		for (int p=0;p<track.length;p++){
			add( new Pixel(track[p][0], track[p][1]));
		}
	}
	
	public String toString() {
		String str ="";
		str += name + ", # points : " + polyline.size() + ", # pixels : " + _pixels.size();
		str += polyline;
		return str;
	}
	
}
