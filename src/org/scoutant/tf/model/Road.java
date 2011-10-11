package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

import org.scoutant.tf.util.LatLngUtils;

import android.util.Log;

public class Road {

	private static final String tag = "model";
	public Polyline polyline = null;
	public String name;
	
//	public List<LatLng> points = new ArrayList<LatLng>();

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

	public Road addA( int x, int y) {
		add( new Pixel( x, y, polyline.point( 0)));
		return this;
	}
	public Road addZ( int x, int y) {
		int nb = polyline.points().size();
		add( new Pixel( x, y, polyline.point( nb-1)));
		return this;
	}

	/** 
	 * Adds a new Pixel(x,y) with the unique LatLng from polyline for which the 4 decimal of the latitude is given by @param lat04   
	 */
	public Road add( int x, int y, int lat04) {
		LatLng f = find( lat04);
		Log.d(tag, "adding (" + x + ", " + y + ") -------- " + f);		
		this.add( new Pixel(x, y, f));
		return this;
	}
	public Road addlng( int x, int y, int lng04) {
		LatLng f = findLng( lng04);
		Log.d(tag, "adding (" + x + ", " + y + ") -------- " + f);		
		this.add( new Pixel(x, y, f));
		return this;
	}
	
	// TODO refactor so as not check for unicity any longer once validated...
	public LatLng find(int lat04) {
		LatLng result = null;
		for (LatLng p : polyline.points()) {
			int v = LatLngUtils.lat04(p);
//			Log.d(tag, " v : " + v);
			if (v==lat04) {
				if (result!=null) {
					// not unique!
					Log.e(tag, "!!! Not unique LatLng lookup : " + lat04);
					result = null;
				}
				result = p;
			}
		}
		return result;
	}
	
	// TODO refactor so as not check for unicity any longer once validated...
	public LatLng findLng(int lng04) {
		LatLng result = null;
		for (LatLng p : polyline.points()) {
			int v = LatLngUtils.lng04(p);
			if (v==lng04) {
				if (result!=null) {
					// not unique!
					Log.e(tag, "!!! Not unique LatLng lookup : " + lng04);
					result = null;
				}
				result = p;
			}
		}
		return result;
	}


}
