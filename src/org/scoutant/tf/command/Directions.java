package org.scoutant.tf.command;

import java.net.URI;
import java.net.URISyntaxException;

import org.scoutant.tf.model.Model;
import org.scoutant.tf.util.PolylineDecoder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;

/**
 * http://maps.google.com/maps/api/directions/xml?sensor=false&language=fr&origin=Meylan,france&destination=gare,grenoble,france
 */
public class Directions extends XmlHttpGetCommand {
	private static final String tag = "http";
	private PolylineDecoder decoder = new PolylineDecoder();

	public void execute() {
		URI uri = null;
		try {
			String query = "sensor=false&language=fr";
			query += "&origin=28 chemin du vieux chene, Meylan,france";
			query += "&destination=gare,grenoble,france";
			uri = new URI("http", "maps.google.com", "/maps/api/directions/xml", query, null); 
		} catch (URISyntaxException e) {
			Log.e( tag, "bad Url!", e);
		}

		Document doc = doGet( uri);
		
    	NodeList items = doc.getElementsByTagName("overview_polyline");
    	String polyline = null;
    	for (int i = 0; i< items.getLength(); i++) {
    		Node node = items.item(i);
    		polyline = valueFor(node, "points");
    		Log.d( tag, "polyline : " + polyline);
    	}
    	
		Model.model().polyline = decoder.polyline( polyline);
	}
	
}