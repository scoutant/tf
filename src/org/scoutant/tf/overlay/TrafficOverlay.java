package org.scoutant.tf.overlay;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Polyline;
import org.scoutant.tf.util.MapUtils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class TrafficOverlay extends Overlay {
	private static final String tag = "overlay";

	private Paint paint = new Paint();

	public TrafficOverlay(Context context) {
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(3.5f);
		paint.setColor(0xFFCC0099);
	}
	
	private void drawTracks(Canvas canvas, MapView map) {
		Polyline track = Model.model().polyline;
		if (track==null || track.size()==0) return;
//		Log.d(tag, "drawing # of points " + track.size());
		Projection pj = map.getProjection();
		Rect viewRect = MapUtils.toRectx2(map);
		Point last = null;
		for (LatLng f : track.points()) {
			boolean visible = viewRect.contains(f.getLongitudeE6(), f.getLatitudeE6());
			if (visible) {
				Point p = new Point();
				pj.toPixels(f, p);
				if (last!=null) {
//					paint.setColor( ColorUtils.toTrafficLight( new Float( 255 * f.getSpeed()/max ).intValue() ));
					paint.setColor(0xFFCC0099);
					canvas.drawLine(last.x, last.y, p.x, p.y, paint);
				}
				last = p;
			}
		}
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		if (shadow) return;
		drawTracks(canvas, mapView);
		super.draw(canvas, mapView, shadow);
	}
}
