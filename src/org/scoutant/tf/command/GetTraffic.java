package org.scoutant.tf.command;

import java.io.InputStream;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Pixel;
import org.scoutant.tf.model.Polyline;
import org.scoutant.tf.model.Road;
import org.scoutant.tf.util.LatLngUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class GetTraffic extends HttpGetCommand {
	
	private static final String tag = "http";
	private Bitmap bitmap;

	@Override
	public void execute() {
		InputStream is = doGet ("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_grenoble&source1=cir&raster=grenoble");
		bitmap = BitmapFactory.decodeStream(is);
		Log.d(tag, "width : " + bitmap.getWidth() +", height : " + bitmap.getHeight());

		Road road = Model.model().network.road(0);
		Polyline polyline = road.polyline;
		Pixel pixelFrom = null;
		LatLng pointFrom = null;
		
		for (Pixel pixelTo : road.pixels()) {
			int color = bitmap.getPixel(pixelTo.x, pixelTo.y);
			pixelTo.color = color;
			if (color==0) Log.e(tag, "ERROR color null!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			LatLng pointTo = road.polyline.point( pixelTo.lat, pixelTo.lng);
			Log.d(tag, "---------------------------------------------------------------");
			Log.d(tag, "pixel : " + color);
			Log.d(tag, "pointTo : " + pointTo);
			if (pointTo==null) {
				Log.e(tag, "Did not find corresponding latlng!! ");
				return;
			}
			pointTo.color = color;
			if (pixelFrom!=null) {
				double pixelD = Pixel.distance(pixelFrom, pixelTo);
				int n = new Double(pixelD).intValue()/5;
				Log.d(tag, "pixelD: " + new Double(pixelD).intValue() + ", n = " + n);
				int dx = pixelTo.x-pixelFrom.x;
				int dy = pixelTo.y-pixelFrom.y;
				double distance = polyline.distance(pointFrom, pointTo);
				Log.d(tag, "distance: " + new Double(distance).intValue());
				for(int index=1; index<n; index++) {
					Pixel q = new Pixel(pixelFrom.x + index * dx/n, pixelFrom.y + index * dy/n);
					q.color = bitmap.getPixel( q.x, q.y);
					// compute a matching point along polyline, by distance interpolation
					LatLng p = polyline.interpolate(pointFrom, pointTo, distance*index/n);
					p.color = color;
					Log.d(tag, "" + new Double(distance*index/n).intValue() +" ---> " +q+ "  ---  " + p);
					
				}
				road.points.add( pointTo);
			}
			pixelFrom=pixelTo;
			pointFrom=pointTo;
		}
	}

}
