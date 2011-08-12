package org.scoutant.tf.util;

import org.scoutant.tf.model.LatLng;

import android.location.Location;

public class LatLngUtils {

	public static double distance( LatLng a, LatLng z) {
		float[] results = new float[3];
		Location.distanceBetween(a.lat(), a.lng(), z.lat(), z.lng(), results);
		return results[0];
	}

	
}
