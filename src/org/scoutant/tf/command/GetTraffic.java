package org.scoutant.tf.command;

import java.io.InputStream;

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

		Log.d(tag, "orange : " + bitmap.getPixel(133, 149));
		Log.d(tag, "green  : " + bitmap.getPixel(88, 94));
		Log.d(tag, "red    : " + bitmap.getPixel(82, 106));
		Log.d(tag, "grey   : " + bitmap.getPixel(370, 144));

	
		Log.d(tag, "orange : " + bitmap.getPixel(143, 276));
		Log.d(tag, "green  : " + bitmap.getPixel(129, 384));
		Log.d(tag, "red    : " + bitmap.getPixel(238, 318));
		Log.d(tag, "grey   : " + bitmap.getPixel(290, 404));

		Road road = new Road( Road.ROCADE);
		
		
		
		
		
	}

}
