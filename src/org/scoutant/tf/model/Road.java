package org.scoutant.tf.model;

import java.util.ArrayList;
import java.util.List;

public class Road {

	public Polyline polyline = Polyline.GrenobleSO;
	
	public List<LatLng> points = new ArrayList<LatLng>();
	

	private List<Pixel> _pixels = new ArrayList<Pixel>();
	public List<Pixel> pixels() { return _pixels; }
	
	public Pixel pixel(int location ) { return _pixels.get(location); }
	
	public Road add(Pixel object) {
		_pixels.add(object);
		return this;
	}
	
	public int[][] track;
	
	public Road(String polyline) {
		this.polyline = new Polyline( polyline);
	}
	
	public Road( int[][] track) {
		for (int p=0;p<track.length;p++){
			add( new Pixel(track[p][0], track[p][1]));
		}
	}

	// 			{ 367, 124 , 45.19833, 5.7808},

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
