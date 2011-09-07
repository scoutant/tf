package org.scoutant.tf;


import org.scoutant.tf.listener.MyLocationListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



public class WithGpsHome extends Activity {
	public static final String tag = "activity"; 
	private static final int MENU_ITEM_PREFERENCES=-1;
	private static final int MENU_ITEM_START_STOP = 0x1;
	private boolean isStarted = false;
	private LocationManager locationManager = null;
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		double latitude = 45.20906;
		double longitude = 5.795187;
        }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
//		menu.add(Menu.NONE, MENU_VIEW, Menu.NONE, "View").setIcon(android.R.drawable.ic_menu_view);
		menu.add(Menu.NONE, MENU_ITEM_PREFERENCES, Menu.NONE, "Paramètres").setIcon(android.R.drawable.ic_menu_preferences);
		menu.add(Menu.NONE, MENU_ITEM_START_STOP, Menu.NONE, "GPS").setIcon(android.R.drawable.button_onoff_indicator_off);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		super.onPrepareOptionsMenu(menu);
		MenuItem menuItem = menu.findItem(MENU_ITEM_START_STOP);
		if (isStarted) {
			menuItem.setTitle("GPS");
			menuItem.setIcon(android.R.drawable.button_onoff_indicator_on);
		} else {
			menuItem.setTitle("GPS");
			menuItem.setIcon(android.R.drawable.button_onoff_indicator_off);
		}
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == MENU_ITEM_PREFERENCES) {
			startActivity( new Intent(this, Settings.class));
		}
		if (id == MENU_ITEM_START_STOP && !isStarted) {
			startTracking();
			return true;
		}
		if (id == MENU_ITEM_START_STOP && isStarted) {
			stopTracking();
		}
		return false;
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	
	private MyLocationListener listener = new MyLocationListener();
	private void startTracking(){
		Log.d(tag, "start tracking");
		isStarted = true;
		locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 1000, 10, listener);
	}
	
	private void stopTracking(){
		Log.d(tag, "stop tracking");
		isStarted = false;
		locationManager.removeUpdates(listener);
		
	}
	
}