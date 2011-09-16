package org.scoutant.tf.util;

import java.util.ArrayList;
import java.util.Collections;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

public class BitmapUtils {
	
	private static final String tag = "util";

	/**
	 * if pixel happen to be 0 at position (x,y), detect color around and returns dominant color around.
	 */
	public static int getPixel( Bitmap bitmap, int x, int y){
		int color = bitmap.getPixel(x, y);
		if (color != 0) return color;
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++) {
				int c = bitmap.getPixel(x+i, y+j);
//				Log.d(tag, "color was null for " +x +", " + y + ". We are looking around among: " + c);
				if (c!=0) values.add(c);
			}
		}
		if (values.size()==0) {
			Log.e(tag, "Only null pixel!! arrond here : " + x +", " + y);
			return Color.BLUE;
		}
		// what is the dominant value?
		Collections.sort( values);
		int dominant=0;
		int occurences=0;
		for( int v : values) {
			int f = Collections.frequency(values , v); 
			if ( f> occurences) {
				occurences = f;
				dominant = v;
			}
		}
		Log.d(tag, "Yep, color is null for pixel " + x +", " + y +".  We looked arround and diminant color is : " + dominant);
		return dominant;
	}

}
