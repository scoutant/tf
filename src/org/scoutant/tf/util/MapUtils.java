package org.scoutant.tf.util;

import android.graphics.Point;
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
	
	/**
	 * So as to draw a polyline aside with @param dist offset...
	 * @return 'null' if @param from and @param to are to close each other... 
	 */
	public static Point offset(Point from, Point to, double d) {
		double a = to.x-from.x;
		double b = to.y-from.y;
		if (a*a+b*b < 25) return null;
		// aX + bY + c = 0 is a normal line whatever c. Line that crosses 'to' is aX + bY = a*to.x + b*to.y 
		// (a,b) is vector for polyline. (b,-a) is vector for normal line.
		// x = b*t; y=-a*t is parametrise expression of normal line.
		// The one that crosses 'to' is
		// x-to.x = b*t; y-to.y = -a*t;
		// we are looking for t to have offset of 'dist'
		// b²t² + a²t² = d² --> t = sqrt(d²/(a²+b²));
		double t = Math.sqrt( d*d/(a*a+b*b));  
		Point p = new Point();
		p.x = new Double(b*t).intValue() ;
		p.y = -new Double(a*t).intValue() ;
		return p;
	}
	
	
	
}
