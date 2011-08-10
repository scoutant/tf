package org.scoutant.tf.model;

import java.io.Serializable;

import android.location.Location;

import com.google.android.maps.GeoPoint;

public class LatLng extends GeoPoint implements Serializable{
	private static final long serialVersionUID = 1L;
	public LatLng(double lat, double lng) {
		super( new Double(lat*1E6).intValue(), new Double(lng*1E6).intValue() );
	}

	public LatLng(Location location) {
		this(location.getLatitude(), location.getLongitude());
	}
	
	public double getLat() { return new Double(getLatitudeE6()/1E6); }
	public double getLng() { return new Double(getLongitudeE6()/1E6); }
}
