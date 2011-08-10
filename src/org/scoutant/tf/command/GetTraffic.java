package org.scoutant.tf.command;

import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Polyline;
import org.scoutant.tf.util.PolylineDecoder;

import android.util.Log;

import com.google.android.maps.MapView;

public class GetTraffic implements Command {
	private static final String tag = "command";
	PolylineDecoder decoder;
	private MapView map;
	public GetTraffic( MapView map){
		this.map = map;
		decoder = new PolylineDecoder();
	}
	
	@Override
	public void execute() {
		Polyline line = Polyline.grenobleSud;
		Model.model().polyline = line;
		map.invalidate();
		Log.d(tag, "get traffic...");
	}

}
