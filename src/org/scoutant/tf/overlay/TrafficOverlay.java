/**
* @author stephane coutant
*
* This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
* See the GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>
*/
package org.scoutant.tf.overlay;

import java.util.ConcurrentModificationException;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Network;
import org.scoutant.tf.model.Polyline;
import org.scoutant.tf.model.Road;
import org.scoutant.tf.util.ColorUtil;
import org.scoutant.tf.util.MapUtils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class TrafficOverlay extends Overlay {

	public static final int SIZE = 64;
	public static final int green = Color.rgb( 51, 187, 0);
	private static final String tag = "overlay";

	private Paint paint = new Paint();

	public TrafficOverlay() {
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(4.5f);
		paint.setColor( Color.MAGENTA);
		paint.setAntiAlias(true);
		paint.setStrokeCap(Cap.ROUND);
	}

	private void drawTraffic(Canvas canvas, MapView map) {
		for (Network network : Model.model().country.networks() ) {
			drawNetwork(canvas, map, network);
		}
	}
	private void drawNetwork(Canvas canvas, MapView map, Network network) {
		try {
			for(Road road : network.roads()) {
				try {
					drawPolyline(canvas, map, road.polyline);
				} catch (ConcurrentModificationException e) {
					Log.e(tag, "************************ Concurent modification exception : skipping road : " + road.name );
				}
			}
		} catch (ConcurrentModificationException e) {
			Log.e(tag, "************************ Concurent modification exception : skipping the full draw." );
		}
	}
	
	private void drawPolyline(Canvas canvas, MapView map, Polyline polyline ) {
		if (polyline==null || polyline.size()==0) return;
		Projection pj = map.getProjection();
		Rect viewRect = MapUtils.toRectx2(map);
		Point last = null;
		Point lastOnAxis=null;
		int color=ColorUtil.GRAY;
		for (LatLng f : polyline.points()) {
			boolean visible = viewRect.contains(f.getLongitudeE6(), f.getLatitudeE6());
			if (visible) {
				Point p = new Point();
				pj.toPixels(f, p);
				if (lastOnAxis==null) {
					lastOnAxis = new Point(p);
				} else {
					Point o = MapUtils.offset(lastOnAxis, p, 5);
					// if null, hence too close, we just skip the point and consider next in the list 
					if (o!=null) {
						lastOnAxis = new Point(p);
						p.offset(o.x, o.y);
						if (f.color != 0 && f.color != -1) {
							color= ColorUtil.color(f.color);
//							if (color == Color.BLACK)
						}
						if (color == Color.BLACK) color = ColorUtil.GRAY;
						paint.setColor( color);
						if (last!=null)
							canvas.drawLine(last.x, last.y, p.x, p.y, paint);
						last = p;
					}
				}
			}
		}
	}
	
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		if (shadow) return;
		drawTraffic(canvas, mapView);
		super.draw(canvas, mapView, shadow);
	}
	
	@Override
	public boolean onTap(GeoPoint p, MapView mapView) {
		mapView.getController().zoomIn();
		return super.onTap(p, mapView);
	}
}