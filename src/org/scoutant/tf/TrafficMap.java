package org.scoutant.tf;

import org.scoutant.tf.command.GetTraffic;
import org.scoutant.tf.command.Init;
import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Network;
import org.scoutant.tf.overlay.TrafficOverlay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class TrafficMap extends MapActivity {
	private MapView mapView;
	private MapController mapController;
	
	static final int MENU_ITEM_PREFERENCES=-1;
	static final int MENU_VIEW = 0;
	static final int MENU_REFRESH = 1;
	private static final String tag = "activity";
	public SharedPreferences prefs;
	private Overlay overlay;
	private ArrayAdapter<CharSequence> adapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        Spinner s = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource( this, R.array.cityNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener( new OnItemSelectedListener() {
			@Override
            public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
                showToast("selected position : " + position + " id=" + id);
                Log.d(tag, "Slected : " + adapter.getItem(position));
        		Network n = Model.model().country.find( ""+adapter.getItem(position));
        		if (n!=null) {
        			Log.d(tag, "setting center to : " + n.center);
        			mapController.animateTo( n.center );
        			new GetTrafficTask().execute( n.id);
        		}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
        
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapController = mapView.getController();
        overlay = new TrafficOverlay();
		mapView.getOverlays().add( overlay);
		new Init().execute();
		mapController.setCenter( new LatLng(45.1794,5.7316) );
        mapController.setZoom(13 );
	  }

	  
	@Override
	protected void onResume() {
		super.onResume();
		refresh();
	} 
	  
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
//		menu.add(Menu.NONE, MENU_VIEW, Menu.NONE, "View").setIcon(android.R.drawable.ic_menu_view);
		menu.add(Menu.NONE, MENU_REFRESH, Menu.NONE, "Actualiser").setIcon(android.R.drawable.ic_menu_send);
		menu.add(Menu.NONE, MENU_ITEM_PREFERENCES, Menu.NONE, "Paramètres").setIcon(android.R.drawable.ic_menu_preferences);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == MENU_ITEM_PREFERENCES) {
			startActivity( new Intent(this, Settings.class));
		}
		if (id==MENU_VIEW){
	        mapController.animateTo( new LatLng( 45.2069,5.7882) );
		}
		if (id==MENU_REFRESH){
			refresh();
		}
		return true;
	}
	
	public void refresh() {
		Network n = Model.model().country.find( selected() );
		if (n!=null) {
			Log.d(tag, "setting center to : " + n.center);
			mapController.animateTo( n.center );
		}
		new GetTrafficTask().execute( selected());
	}
	
	public int selected() {
		return new Integer( prefs.getString("city", "38"));
	}
	
	private class GetTrafficTask extends AsyncTask<Integer, Void, Boolean> {
		@Override
		protected Boolean doInBackground(Integer... params) {
//			Log.d(tag, "********************************************* thread *****************************************");
			new GetTraffic().execute( selected() );
			return true;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			mapView.invalidate();
			super.onPostExecute(result);
		}
		
	}
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
	
}