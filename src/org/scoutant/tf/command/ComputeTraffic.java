package org.scoutant.tf.command;

import org.scoutant.tf.model.*;
import org.scoutant.tf.util.PolylineDecoder;

import android.util.Log;

import com.google.android.maps.MapView;

public class ComputeTraffic implements Command {
	private static final String tag = "command";
	PolylineDecoder decoder;
	private MapView map;
	public ComputeTraffic( MapView map){
		this.map = map;
		decoder = new PolylineDecoder();
	}
	
	@Override
	public void execute() {
		map.invalidate();
	}

}
