package org.scoutant.tf.command;

import java.io.InputStream;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Pixel;
import org.scoutant.tf.model.Polyline;
import org.scoutant.tf.model.Road;

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
		
		for (Pixel pixel : road.pixels()) {
			int color = bitmap.getPixel(pixel.x, pixel.y);
			pixel.color = color;
			LatLng point = road.polyline.point( pixel.lat, pixel.lng);
			if (point!=null) {
				point.color = color;
				Log.d(tag, "found : " + point);
			}
		}
	}

	public static int[][] ROCADE = { 
		{ 367, 124},
		{ 369,134 },
		{ 370,147 },
		{ 369,159 },
		{ 366, 170},
		{ 361,180 },
		{ 357, 188},
		{ 347, 200},
		{ 337, 211},
		{ 330, 222},
		{ 322, 234},
		{ 316, 245},
		{ 311, 250},
		{ 304, 263},
		{ 299, 272},
		{ 293, 280},
		{ 286, 289},
		{ 282, 295},
		{ 273, 302},
		{ 260, 311},
		{ 245, 316},
		{ 234, 318},
		{ 221, 319},
};	

}
