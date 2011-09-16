package org.scoutant.tf.util;

import java.util.regex.Pattern;

import org.scoutant.tf.model.LatLng;

import android.location.Location;
import android.util.Log;

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

	/**
	 * @return integer value with the 4 decimal of the latitude of provided @param p 
	 */
	public static int lat04( LatLng p) {
//		Log.d("util", "p : " + p);
		String str = ""+p.lat();
		String dec = str.split( Pattern.quote("."))[1];
		if (dec.length()<4) {
//			dec += (dec.length()==3 ? "0" : "00" );
			dec += (dec.length()==3 ? "0" : (dec.length()==2 ? "00" : "000" ) );
		}
		return new Integer( dec.substring(0, 4));
	}
	/**
	 * @return integer value with the 4 decimal of the latitude of provided @param p 
	 */
	public static int lng04( LatLng p) {
		String str = ""+p.lng();
		String dec = str.split( Pattern.quote("."))[1];
		if (dec.length()<4) {
			dec += (dec.length()==3 ? "0" : (dec.length()==2 ? "00" : "000" ) );
		}
		return new Integer( dec.substring(0, 4));
	}
	
}
