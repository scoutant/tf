package org.scoutant.tf.util;

import org.scoutant.tf.model.LatLng;

import android.location.Location;

public class LatLngUtils {

	public static double distance( LatLng a, LatLng z) {
		float[] results = new float[3];
		Location.distanceBetween(a.lat(), a.lng(), z.lat(), z.lng(), results);
		return results[0];
	}

	/** 
	 * Very local interpolation only!
	 */ 
	public static LatLng interpolate( LatLng a, LatLng z, double distance ) {
		if (a==z) return a;
		double ratio = distance / distance(a, z);
		return new LatLng((1-ratio)*a.lat()+ratio*z.lat() , (1-ratio)*a.lng()+ratio*z.lng());
	}
	
}
