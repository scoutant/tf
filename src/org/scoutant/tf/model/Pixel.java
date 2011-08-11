package org.scoutant.tf.model;

public class Pixel {

	public Pixel(int x, int y) {
		this.x = x;
		this.y =y ;
	}
	public Pixel(int x, int y, int color) {
		this(x,y);
		this.color = color;
	}
	
	public int x;
	public int y;
	public int color;
	public double lat;
	public double lng;

	public Pixel(int x, int y, double lat, double lng) {
		this(x,y);
		this.lat = lat;
		this.lng = lng;
	}
	
	
	public String toString() {
		return "(" + x +"," + y + ") : " + color;
	}
	
	/** @return distance */ 
	public static double distance( Pixel a, Pixel z) {
		return Math.sqrt( (z.x-a.x)*(z.x-a.x) + (z.y-a.y)*(z.y-a.y)); 
	}
	
	
	
}
