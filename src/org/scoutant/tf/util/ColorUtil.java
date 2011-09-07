package org.scoutant.tf.util;

import android.graphics.Color;
import android.util.Log;

public class ColorUtil {
	
	private static final String tag = "util";

	public static int color(int bfColor) {
		switch (bfColor) {
		case -16711936: return Color.rgb(51, 187, 0); 
		case -26368: return Color.rgb( 255, 212, 38); // Orange
//		case -6750208: return Color.rgb( 158, 11, 11); // Red used by Google
		// Two color for Red? -6750208 and -16776961
		case -6750208: return Color.RED;
		case -16776961: return Color.RED;
		// Gray stands for unknow at Bison Futé. extrapolate to last know?
		case -9407614: return Color.WHITE; 
		default:
			Log.e(tag, "ERROR : Bad PNG color extraction... !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return Color.GRAY;
		}
	}

}
