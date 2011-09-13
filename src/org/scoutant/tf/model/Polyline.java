package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.scoutant.tf.util.LatLngUtils;

import android.util.Log;

public class Polyline {
	
	public static final double INTERPOLATE_DIST = 200;
	
	private static final String tag = "model";
	
	private List<LatLng> _points = new ArrayList<LatLng>();
	
	public Polyline(){
	}
	public Polyline( List<LatLng> items){
		this();
		_points = items;
	}
	public Polyline(String rep) {
		this();
		String[] data = rep.split( Pattern.quote("|"));
		for (int i=0; i<data.length;i++) {
			add( new LatLng(data[i]));
		}
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

	
	public LatLng point(double lat, double lng) {
		for (LatLng p : _points) {
			if (p.lat() == lat && p.lng() == lng) {
				return p;
			}
		}
		return null;
	}

	/**
	 * @return cumulated distance along polyline from @param a to @param z
	 */
	public double distance( LatLng a, LatLng z) {
		// verify a and z belong to polyline...
		int iA = _points.indexOf(a);
		int iZ = _points.indexOf(z);
		if (iA<0) {
			Log.e(tag, "Not on polyline : " + a);
		}
		if (iZ<0) {
			Log.e(tag, "Not on polyline : " + z);
		}
		if (iA==iZ) return 0;
		if (iZ<iA) {
			int tmp=iA;
			iA=iZ;
			iZ=tmp;
		}
		double d=0;
		for (int index=iA; index<iZ; index++) {
			d+= LatLngUtils.distance( point(index), point(index+1));
		}
		return d;
	}

	/** 
	 * Considering a is before z in polyline. supposing distance has been processed so that it does not exceed d(a,z). 
	 */
	public LatLng interpolate(LatLng a, LatLng z, double distance) {
		if (distance==0) return a;
		if (distance==0) return a;
		int iA = _points.indexOf(a);
		int iZ = _points.indexOf(z);
		if (iA==iZ) return a;
		// TODO optimize with dichotomie?
		double d=0;
		for (int index=iA; index<iZ; index++) {
			double delta = LatLngUtils.distance( point(index), point(index+1));
			d += delta;
			if (d>=distance) {
				if (delta > INTERPOLATE_DIST) {
					LatLng between = LatLngUtils.interpolate(point(index), point(index+1), INTERPOLATE_DIST*0.85);
//					Log.d(tag, "Caution long dist. Best to interpolate!");
//					Log.d(tag, "inserting at position : " + (index+1) + ", point : " + between);
					synchronized (_points) {
						_points.add(index+1, between);
					}
					return between;
				} else {
					return point(index);
				}
			}
		}
		Log.e(tag, "Bad interpolation along lolyline. a: " + a +", z: " + z);
		return null;
	}
	
	public String toString() {
		String str = "# of points : " + size() +"\n";
//		for (int i=0; i<size();i++) {
//			str += i + " : " + point(i)+"\n";
//		}
		return str;
	}
	
	/**
	 * Just reset the color of the points
	 */
	public void reset() {
		for (LatLng p : _points) {
			p.color = 0;
		}
	}
}
