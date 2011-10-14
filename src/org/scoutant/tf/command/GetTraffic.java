package org.scoutant.tf.command;

import java.io.InputStream;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Network;
import org.scoutant.tf.model.Pixel;
import org.scoutant.tf.model.Polyline;
import org.scoutant.tf.model.Road;
import org.scoutant.tf.util.BitmapUtils;
import org.scoutant.tf.util.ColorUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

public class GetTraffic extends HttpGetCommand {
	
	private static final String tag = "http";
	private Bitmap bitmap;

	@Override
	public void execute(int id) {
			trafficFor( Model.model().country.find(id));
	}

	private void trafficFor( Network network) {
		if (!network.done) {
			new InitNetwork().execute(network.code);
		}
		InputStream is = doGet( network.url);
		if (is ==null) {
			Log.e(tag, "skipping (is), for network error encontered with : " + network.name);
			return;
		}
		bitmap = BitmapFactory.decodeStream(is);
		if (bitmap ==null) {
			Log.e(tag, "skipping (bitmap), for network error encontered with : " + network.name);
			return;
		}
		Log.d(tag, "width : " + bitmap.getWidth() +", height : " + bitmap.getHeight());

		for( Road road : network.roads()) {
			Polyline polyline = road.polyline;
			polyline.reset();
			Pixel pixelFrom = null;
			LatLng pointFrom = null;
			for (Pixel pixelTo : road.pixels()) {
				int color = BitmapUtils.getPixel( bitmap, pixelTo.x, pixelTo.y);
				pixelTo.color = color;
				LatLng pointTo = road.polyline.point( pixelTo.lat, pixelTo.lng);
				if (color==0) { 
					Log.e(tag, "ERROR color null! pixelTo : " + pixelTo);
				}
				if (ColorUtil.color(color)==Color.BLACK) {
					Log.e(tag, "ERROR color Blak (hence undefined) arround here?! pixelTo : " + pixelTo);					
				}
				Log.d(tag, "pixel : " + pixelTo +", pointTo : " + pointTo);
				if (pointTo==null) {
					Log.e(tag, "Did not find corresponding latlng!! ");
					return;
				}
				pointTo.color = color;
				int previousColor = color;
				if (pixelFrom!=null) {
					double pixelD = Pixel.distance(pixelFrom, pixelTo);
					int n = new Double(pixelD).intValue()/5;
//					Log.d(tag, "pixelD: " + new Double(pixelD).intValue() + ", n = " + n);
					int dx = pixelTo.x-pixelFrom.x;
					int dy = pixelTo.y-pixelFrom.y;
					double distance = polyline.distance(pointFrom, pointTo);
//					Log.d(tag, "distance: " + new Double(distance).intValue());
					for(int index=1; index<n; index++) {
						Pixel q = new Pixel(pixelFrom.x + index * dx/n, pixelFrom.y + index * dy/n);
						// TODO refactor with BitmapUtils.getPixel?
//						q.color = bitmap.getPixel( q.x, q.y);
						q.color = BitmapUtils.getPixel( bitmap, q.x, q.y);
						// compute a matching point along polyline, by distance interpolation
						LatLng p = polyline.interpolate(pointFrom, pointTo, (distance*index)/n);
						if (p!=null) {
							// Fix! If interpolated point has acceptable color, consider it! if not consider previous point's color
//							p.color = color;
							if (q.color!= Color.BLACK) {
								previousColor = q.color; 
								p.color = q.color;
							} else {
								Log.e(tag, "Warn : nok color extraction for: " + q.color + ColorUtil.toRGB(q.color) + "we extrapolate agains previously interpolated");
								p.color = previousColor;
							}
//							Log.d(tag, "interpolating for point : " + p);
						}
					}
				}
				pixelFrom=pixelTo;
				pointFrom=pointTo;
			}
			Log.d(tag, "road is now : " + road);
		}
	}
}
