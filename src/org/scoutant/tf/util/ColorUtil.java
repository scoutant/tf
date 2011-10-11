package org.scoutant.tf.util;

import android.graphics.Color;
import android.util.Log;

public class ColorUtil {
	
	public static final int GREEN = Color.rgb(0, 206, 0); // ZT Green // 00CE00
	public static final int GREEN2 = Color.rgb(51, 187, 0); // Google green // 33BB00
	public static final int ORANGE = Color.rgb( 253, 129, 38); // FD8126
	// Color.rgb( 255, 212, 38); // Orange
	public static final int RED = Color.RED; 
	// Color.rgb( 158, 11, 11); // Red used by Google
	
	private static final String tag = "util";

	
	public static int color(int bfColor) {
		switch (bfColor) {
		case -16711936: return GREEN;
		case -3394765: return GREEN; 
		case -26368: return ORANGE;
		case -6750208: return RED;
		case -16776961: return RED;
		case -65536: return RED;
		case -52480: return RED;
		// Gray stands for unknow at Bison Futé. let's use green, but somewhat different
		case -9407614: return GREEN2; 
		default:
			Log.e(tag, "ERROR : Bad PNG color extraction... !!!!! Color is : " + bfColor);
			return Color.BLACK;
		}
	}

}
