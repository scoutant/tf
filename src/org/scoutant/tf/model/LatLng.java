package org.scoutant.tf.model;

import java.io.Serializable;

import org.scoutant.tf.util.ColorUtil;

import android.location.Location;

import com.google.android.maps.GeoPoint;

public class LatLng extends GeoPoint implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int color;
	
	public LatLng(double lat, double lng) {
		super( new Double(lat*1E6).intValue(), new Double(lng*1E6).intValue() );
	}

	public LatLng(Location location) {
		this(location.getLatitude(), location.getLongitude());
	}

	/** 
	 * with @param string like '45.23864,5.66103'
	 */
	public LatLng(String rep) {
		this( new Double( rep.split(",")[0]), new Double( rep.split(",")[1]));
	}

	public double lat() { return new Double(getLatitudeE6()/1E6); }
	public double lng() { return new Double(getLongitudeE6()/1E6); }
	
	public String toString(){
		String str = "";
		str += "(" + lat() + ", " + lng() +")";
		if (color!=0) str += ",  color : " + color +  ", " + ColorUtil.toRGB(color);
		return str;
	}
	

	
	
}
