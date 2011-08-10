package org.scoutant.tf;

import org.scoutant.tf.command.GetTraffic;
import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.overlay.PolylineOverlay;
import org.scoutant.tf.overlay.TrafficOverlay;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class TrafficMap extends MapActivity {
	private MapView mapView;
	private MapController mapController;
	
	static final int MENU_VIEW = 0;
	static final int MENU_SEARCH = 1;
	static final int MENU_ACTION = 2;
	static final int MENU_ITEM = 3;
	
	  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapController = mapView.getController();
        //| 45.2073,5.7833
        mapController.setCenter( new LatLng(45.1794,5.7316) );
        mapController.setZoom(13 );
		mapView.getOverlays().add( new TrafficOverlay( ));
//		mapView.getOverlays().add( new PolylineOverlay( ));

		new GetTraffic(mapView).execute();
	  }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, MENU_VIEW, Menu.NONE, "View").setIcon(android.R.drawable.ic_menu_view);
		menu.add(Menu.NONE, MENU_SEARCH, Menu.NONE, "Search").setIcon(android.R.drawable.ic_menu_search);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem menuItem) {
		if (menuItem.getItemId()==MENU_VIEW){
	        mapController.animateTo( new LatLng( 45.2069,5.7882) );
		}
		if (menuItem.getItemId()==MENU_SEARCH){
//			new Directions().execute();
			new GetTraffic(mapView).execute();
		}
		return true;
	}
}