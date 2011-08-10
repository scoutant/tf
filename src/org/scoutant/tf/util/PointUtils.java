package org.scoutant.tf.util;

import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;

public class PointUtils {

	public static Point toPixel( MapView map, GeoPoint geo) {
		Point point = new Point();
		map.getProjection().toPixels(geo, point);
		return point;
	}
}
