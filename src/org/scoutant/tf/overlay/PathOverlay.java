package org.scoutant.tf.overlay;

import java.util.ArrayList;
import java.util.List;

import org.scoutant.tf.model.Fix;
import org.scoutant.tf.util.PointUtils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Paint.Style;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class PathOverlay extends Overlay {
	// private List<Location> locations = new ArrayList<Location>();
	private List<Fix> locations = new ArrayList<Fix>();
	private Context context;
	public Path path = new Path();
	private Paint paint = new Paint();
	public List<Point> points = new ArrayList<Point>();

	public PathOverlay(Context context) {
		this.context = context;
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(4.5f);
		// paint.setColor(0xFFFFA500);
		paint.setColor(0xFFCC0099);
	}

	public void addLocation(Fix l) {
		locations.add(l);
	}

	public void addPoint(Point p) {
		points.add(p);
		// path.lineTo(p.x, p.y);
	}

	private void drawPoints(Canvas canvas, MapView mapView) {
		// mapView.getOverlays().clear();
		Projection pj = mapView.getProjection();
		path.reset();
		path.moveTo(0, 0);
		if (!points.isEmpty())
			path.moveTo(points.get(0).x, points.get(0).y);
		for (Point p : points) {
			path.lineTo(p.x, p.y);
		}
	}

	private void drawLocations(Canvas canvas, MapView mapView) {
		Projection pj = mapView.getProjection();
		Rect viewRect = getDoubleMapViewRect(mapView);
		points.clear();
		for (Fix f : locations) {
			boolean visible = viewRect.contains(f.getLongitudeE6(), f.getLatitudeE6());
			if (visible) {
				Point point = new Point();
				pj.toPixels(f.getGeoPoint(), point);
				addPoint(point);
				// path.lineTo(p.x, p.y);
			}
		}
		drawPoints(canvas, mapView);
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		if (shadow) {
			System.out.println("shadow...");
			return;
		}
		// drawPoints(canvas, mapView);
		drawLocations(canvas, mapView);
		canvas.drawPath(path, paint);
		super.draw(canvas, mapView, shadow);
	}

	@Override
	public boolean onTap(GeoPoint point, MapView mapView) {
		Point tapXY = PointUtils.toPixel(mapView, point);
		System.out.println("tapped! " + tapXY);
		return true;
	}

	Rect getDoubleMapViewRect(MapView mapView) {
		int w = mapView.getLongitudeSpan();
		int h = mapView.getLatitudeSpan();
		int cx = mapView.getMapCenter().getLongitudeE6();
		int cy = mapView.getMapCenter().getLatitudeE6();
//		return new Rect(cx - w / 2, cy - h / 2, cx + w / 2, cy + h / 2);
		return new Rect(cx-w, cy-h, cx+w, cy+h);
	}

}
