/**
* @author stephane coutant
*
* This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
* See the GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>
*/
package org.scoutant.tf;

import java.util.Timer;
import java.util.TimerTask;

import org.scoutant.tf.command.GetTraffic;
import org.scoutant.tf.command.Init;
import org.scoutant.tf.model.LatLng;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Network;
import org.scoutant.tf.overlay.TrafficOverlay;
import org.scoutant.tf.util.BusyIndicator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
	static final int MENU_HELP = 0;
	static final int MENU_REFRESH = 1;
	static final int MENU_VOTE = 2;
	private static final String tag = "activity";
	public SharedPreferences prefs;
	private Overlay overlay;
	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;
	private Timer timer;
	private BusyIndicator indicator;
	private Toast toast;
	public static final int ALPHA=146;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        ((ImageView) findViewById(R.id.help)).setAlpha(ALPHA);
        ((ImageView) findViewById(R.id.plus)).setAlpha(ALPHA);
        ((ImageView) findViewById(R.id.minus)).setAlpha(ALPHA);
        findViewById(R.id.minus).setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				mapController.zoomOut();
			}
		});
        findViewById(R.id.help).setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				openOptionsMenu();
			}
		});
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Log.d(tag, "onCreate");
        timer = new Timer(true);
        
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource( this, R.array.cityNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapController = mapView.getController();
        overlay = new TrafficOverlay();
		mapView.getOverlays().add( overlay);
		new Init().execute();
		mapController.setCenter( new LatLng(45.1794,5.7316) );
        mapController.setZoom(13 );
        mapView.setBuiltInZoomControls(false);
        
        View progress = findViewById(R.id.ProgressBar);
        indicator = new BusyIndicator(this, progress);
        
    	toast = new Toast(this);
    	toast.setView( getLayoutInflater().inflate(R.layout.wellcome_toast, (ViewGroup) findViewById(R.id.toast)));
    	toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 200);
    	toast.setDuration(Toast.LENGTH_SHORT);
	  }

	  
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(tag, "on resume...");
		showToast(null);
        if (isAirplaneModeOn(this)) {
			new AlertDialog.Builder(this)
			.setMessage("Pour utiliser cette application, il faut autoriser la connexion internet! Typiquement désactiver le mode 'Avion' \nAller dans Accueil > menu > paramètres > Sans fil et réseau > Mode avion.")
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
					}
				})
			.create()
			.show();
			return;
        }
        spinner.setSelection( preferred());
        if (spinner.getOnItemSelectedListener()!=null) {
        	refresh();
        } else {
        	// Yes, setting the listener will trigger it! How come?
	        spinner.setOnItemSelectedListener( new OnItemSelectedListener() {
				@Override
	            public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
	        		Network n = Model.model().country.find( position);
	        		if (n!=null) {
	        			saveSelected(position);
	        			refresh();
	        		}
				}
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					Log.d(tag, "nothing selected or no different selection? ");
				}
	        });
        }
	} 
	  
	@Override
	protected void onPause() {
		Log.d(tag, "onPause");
		timer.cancel();
		timer.purge();
		indicator.hide();
		super.onPause();
	}
	@Override
	protected void onDestroy() {
		Log.d(tag, "onDestroy");
		super.onDestroy();
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	/** 
	 * Icons from http://commons.wikimedia.org/wiki/Crystal_Clear, With licence Creative Commons share Alike, CC BY-SA
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, MENU_HELP, Menu.NONE, "Aide").setIcon( R.drawable.help_48);
//		menu.add(Menu.NONE, MENU_REFRESH, Menu.NONE, "Rafraichir").setIcon( R.drawable.refresh_48);
		menu.add(Menu.NONE, MENU_VOTE, Menu.NONE, "votre avis").setIcon( R.drawable.love_48);
//		menu.add(Menu.NONE, MENU_ITEM_PREFERENCES, Menu.NONE, "Paramètres").setIcon( R.drawable.parameter_48);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == MENU_ITEM_PREFERENCES) 
			startActivity( new Intent(this, org.scoutant.tf.Settings.class));
		if (id==MENU_HELP)
	        startActivity( new Intent(this, Help.class));
		if (id==MENU_REFRESH)
			refresh();
		if (id==MENU_VOTE) {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=org.scoutant.tf")); 
			startActivity(intent);
			//	addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		}
		return true;
	}
	
	
	public void refresh() {
		Network n = Model.model().country.find( preferred() );
		if (n!=null) {
			mapController.setZoom( n.zoom);
			mapController.animateTo( n.center );
		}
		timer.cancel();
		timer.purge();
		timer = new Timer(true);
		// the web services are refreshed every 6 min. Here we are poling at half period.
		timer.schedule( new RepetedGetTrafficTask(), 0, 3*60*1000);
	}
	
	public int preferred() {
		// Grenoble as default...
		return new Integer( prefs.getString("city", "2"));
	}
	
	public void saveSelected(int id) {
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("city", ""+id);
		editor.commit();
		Log.d(tag, "saving preference : " + id);
	}
	
	
	private class RepetedGetTrafficTask extends TimerTask {
		@Override
		public void run() {
			Log.d(tag, "********************************************* THREAD by TIMER *****************************************");
			indicator.show();
			try {
				new GetTraffic().execute( preferred() );
			} catch (Exception e) {
				Log.e(tag, "Could not get traffic for : " + preferred(), e);
			}
			indicator.hide();
			mapView.postInvalidate();
		}
		
	}
	
	private void showToast(CharSequence msg) {
    	toast.show();
    }

    /**
     * Gets the state of Airplane Mode.
     * @param context
     * @return true if enabled.
     */
    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0;
    }
	
}