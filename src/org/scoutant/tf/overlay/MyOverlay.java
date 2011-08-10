package org.scoutant.tf.overlay;

import org.scoutant.tf.model.LatLng;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MyOverlay extends Overlay {
    private Paint paint = new Paint();
    private int rad = 40;
    private GeoPoint point = new LatLng(45.20909, 5.79291);
	public MyOverlay(){
		super();
	    paint.setARGB(160, 255, 165, 0);
	    paint.setAntiAlias(true);
	    paint.setFakeBoldText(true);
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		System.out.println("redrawing");
	  if (shadow == false) {
		  Point myPoint = new Point();
	    mapView.getProjection().toPixels( point, myPoint);

	    // Create the circle
	    RectF oval = new RectF(myPoint.x-rad, myPoint.y-rad, myPoint.x+rad, myPoint.y+rad);
	    canvas.drawOval(oval, paint);
	  }
	}	

	@Override
	public boolean onTap(GeoPoint point, MapView mapView) {
		System.out.println("tapped!");
		this.point = point;
		// to force redraw...
		mapView.invalidate();
	    return true;
	}
	
	
}
