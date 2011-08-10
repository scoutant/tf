package org.scoutant.tf.util;

import android.graphics.Rect;

import com.google.android.maps.MapView;

public class MapUtils {

	/**
	 * @return Rect corresponding to @param mapView viewport
	 */
	public static Rect toRect(MapView mapView) {
		int w = mapView.getLongitudeSpan();
		int h = mapView.getLatitudeSpan();
		int cx = mapView.getMapCenter().getLongitudeE6();
		int cy = mapView.getMapCenter().getLatitudeE6();
		return new Rect(cx-w/2, cy-h/2, cx+w/2, cy+h/2);
	}

	/**
	 * @return Rect corresponding to twice the @param mapView viewport
	 */
	public static Rect toRectx2(MapView mapView) {
		int w = mapView.getLongitudeSpan();
		int h = mapView.getLatitudeSpan();
		int cx = mapView.getMapCenter().getLongitudeE6();
		int cy = mapView.getMapCenter().getLatitudeE6();
		return new Rect(cx-w, cy-h, cx+w, cy+h);
	}
}
