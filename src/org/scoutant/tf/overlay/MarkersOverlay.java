package org.scoutant.tf.overlay;
import java.util.ArrayList;

import org.scoutant.tf.util.PointUtils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MarkersOverlay extends ItemizedOverlay<OverlayItem>  {
	private ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
	private Context mContext;
	
	public MarkersOverlay(Drawable defaultMarker, Context context) {
	    super(boundCenterBottom(defaultMarker));
	    mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		items.add(overlay);
	    populate();
	}
	
	@Override
	protected OverlayItem createItem(int i) {
	  return items.get(i);
	}

	@Override
	public int size() {
	  return items.size();
	}

	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = items.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}	

	/** Am I tapping on a marker? */
	@Override
	public boolean onTap(GeoPoint point, MapView mapView) {
		if (!super.onTap(point, mapView)) {
			Point tapXY = PointUtils.toPixel( mapView, point);
			System.out.println("tapped! " + tapXY);
			for (OverlayItem item : items) {
				Point itemXY = PointUtils.toPixel( mapView, item.getPoint());
				System.out.println("item : " + itemXY);
				/*
				if ( ( Math.abs( tapXY.x - itemXY.x) < 100 )  && ( Math.abs( tapXY.y - itemXY.y) < 100 ) ) {
					onTap (items.indexOf(item));
					return false;
				}
				*/
			}
			addOverlay( new OverlayItem(point, "Coucou!", "Zêtes a : " + point));
		}
	    return true;
	}
	
}
