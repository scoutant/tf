package org.scoutant.tf;

import java.util.List;

import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.overlay.HelloItemizedOverlay;
import org.scoutant.tf.overlay.MyOverlay;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class HelloGoogleMaps extends MapActivity {

	static final int MENU_VIEW = 0;
	static final int MENU_SEARCH = 1;
	static final int MENU_ACTION = 2;
	static final int MENU_ITEM = 3;
	
	private MapView mapView;
	  private MapController mapController;

	  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapController = mapView.getController();
        mapController.setCenter( new LatLng(45.20909, 5.79291) );
        mapController.setZoom(17 );
//		mapView.getOverlays().add( new MyOverlay());
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
		menu.add(Menu.NONE, MENU_ACTION, Menu.NONE, "My Location").setIcon(android.R.drawable.ic_menu_mylocation);
		menu.add(Menu.NONE, MENU_ITEM, Menu.NONE, "My Location").setIcon(android.R.drawable.ic_menu_info_details);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem menuItem) {
		if (menuItem.getItemId()==MENU_VIEW){
	        mapController.animateTo( new LatLng( 45.2069,5.7882) );
		}
		if (menuItem.getItemId()==MENU_SEARCH){
//			List<Overlay> overlays = mapView.getOverlays();		
//			HelloItemizedOverlay markers = new HelloItemizedOverlay( this.getResources().getDrawable(R.drawable.icon));    
//			overlays.add( markers);
			
			mapView.getOverlays().add( new MyOverlay());
		}
		if (menuItem.getItemId()==MENU_ACTION){
			MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, mapView);
	        mapView.getOverlays().add( myLocationOverlay);
			myLocationOverlay.enableCompass();
			// If GPS provider where active, this would be enough
			myLocationOverlay.enableMyLocation();
		}
		if (menuItem.getItemId()==MENU_ITEM){

			List<Overlay> mapOverlays = mapView.getOverlays();
			Drawable drawable = this.getResources().getDrawable(R.drawable.marker2);
//			Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
			HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable, this);
			
			GeoPoint point = new LatLng( 45.2069,5.7882);
			OverlayItem overlayitem = new OverlayItem(point, "Coucou!", "Zêtes a : " + point);
			// Pas l'air de marcher ceci!! marche que s ic'est le defaultmarker!
			//overlayitem.setMarker( getResources().getDrawable(R.drawable.marker2));
			
			itemizedoverlay.addOverlay(overlayitem);
			mapOverlays.add(itemizedoverlay);
		}
		return true;
	}

}