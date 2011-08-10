package org.scoutant.tf.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

public class MyLocationListener implements LocationListener {

	public static final String tag = "listener";
	
	@Override
	public void onLocationChanged(Location location) {
		Log.d(tag, "new location : " + location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		Log.i(tag, "provider disabled" + provider);
	}

	@Override
	public void onProviderEnabled(String provider) {
		Log.i(tag, "provider enabled" + provider);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Log.i(tag, "status changed to " + status);
	}

}
