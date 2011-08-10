package org.scoutant.tf.util;

import java.util.List;

import org.scoutant.tf.model.LatLng;


public class PolylineUtils {

	public static String toString(List<LatLng> polyline) {
		String str = "[ ";
		for( LatLng p : polyline) {
			str += p;
		}
		return str + " ]";
	}

	public static String toMarkers(List<LatLng> polyline) {
		String str = "";
		for( LatLng p : polyline) {
			str += "|" + p.getLat()+","+p.getLng();
		}
		return str.substring(1, str.length());
	}

}
