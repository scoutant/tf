package org.scoutant.tf.util;

import java.util.ArrayList;
import java.util.List;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Polyline;


/**
 * Port to Java of Mark McClures Javascript PolylineEncoder :
 * http://facstaff.unca.edu/mcmcclur/GoogleMaps/EncodePolyline/decode.js
 */
public class PolylineDecoder {

	public List<LatLng> decode(String encoded) {
		List<LatLng> track = new ArrayList<LatLng>();
		int index = 0;
		int lat = 0, lng = 0;

		while (index < encoded.length()) {
			int b, shift = 0, result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lat += dlat;

			shift = 0;
			result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lng += dlng;

			LatLng p = new LatLng( (double)lat/1E5, (double)lng/1E5 );
			track.add(p);
		}
		return track;
	}
	
	public Polyline polyline(String encoded) {
		return new Polyline( decode(encoded));
	}
	
	
}
