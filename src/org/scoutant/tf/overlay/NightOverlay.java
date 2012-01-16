package org.scoutant.tf.overlay;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class NightOverlay extends Overlay {
	
	public static final String KEY = "night-mode";
	public static final int ALPHA = 180;
	
	private Paint paint = new Paint();
	private SharedPreferences prefs;
	public NightOverlay(SharedPreferences prefs){
		super();
		this.prefs = prefs;
		paint.setStyle(Style.FILL);
		paint.setColor(Color.BLACK);
		paint.setAlpha( 255-ALPHA);
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		if (!isNight()) return;
		canvas.drawRect(0, 0, mapView.getWidth(), mapView.getHeight(), paint);
	}

	private boolean isNight() {
		return prefs.getBoolean( KEY, false); 
	}
}
