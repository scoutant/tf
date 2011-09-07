package org.scoutant.tf.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

public class BitmapUtils {
	
	private static final String tag = "util";

	/**
	 * if pixel happen to be 0 at position (x,y), try to detect color around...
	 */
	public static int getPixel( Bitmap bitmap, int x, int y){
		int color = bitmap.getPixel(x, y);
		if (color != 0) return color;
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++) {
				int c = bitmap.getPixel(x, y);
				// TODO consider average value?
				Log.d(tag, "color was null for " +x +", " + y + ". We looked arround and considered : " + c);
				if (c!=0) return c;
			}
		}
		return Color.BLUE;
	}

}
