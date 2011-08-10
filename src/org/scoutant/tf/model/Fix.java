package org.scoutant.tf.model;

import java.io.Serializable;

import com.google.android.maps.GeoPoint;

import android.location.Location;

public class Fix extends Location implements Serializable {
	private static final long serialVersionUID = 1L;
	public Fix(Location location){
		super( location);
		setLatitude( Math.floor(this.getLatitude()*1E6)/ 1E6) ;
		setLongitude( Math.floor(this.getLatitude()*1E6)/ 1E6) ;
		// TODO regarder accuracy et si pas assez précis alors passer à null!
	}

	
	public Fix(double lat, double lng) {
		super (new Location("gps"));
		this.setLatitude(lat);
		this.setLongitude(lng);
	}

	public Fix(LatLng p) {
		this( p.getLat(), p.getLng());
	}
	
	
	@Override
	public String toString(){
		return "(" + getLatitude() + ", " + getLongitude() + "), " + getTime();
	}
	
	public GeoPoint getGeoPoint() {
	    return new GeoPoint((int) (getLatitude()*1E6), (int) (getLongitude()*1E6));
	}
	public int getLatitudeE6() { return (int) (getLatitude()*1E6); }
	public int getLongitudeE6() { return (int) (getLongitude()*1E6); }
	
}
