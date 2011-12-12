package org.scoutant.tf.adapter;

import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout.LayoutParams;

/**
 * @author scoutant
 * A customization of ArrayAdapter<T>, for wich corresponding dropdown views are resized to that all the list fits in the screen. 
 * So as not to have to use the scrollbar.
 * Yes, user is not always aware of the scrollbar.
 * Present approach make sense if list stay limited to 10 items.
 */
public class NoScrollArrayAdater<T> extends ArrayAdapter<T> {
	public static final String tag = "adapter";
	private int h;
	
	public static NoScrollArrayAdater<CharSequence> createFromResource (Context context, int textArrayResId, int textViewResId) {
		return new NoScrollArrayAdater<CharSequence>(context, org.scoutant.tf.R.array.cityNames, textViewResId);
	}
	
	@SuppressWarnings("unchecked")
	public NoScrollArrayAdater(Context context, int resource, int textViewResourceId) {
		super( context, textViewResourceId, (T[]) context.getResources().getStringArray( resource));
		String[] names = context.getResources().getStringArray( org.scoutant.tf.R.array.cityNames);

		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		int length = Math.min( names.length, 10);
		h = (int) (display.getHeight() / length / 1.6) ;
	}

	@Override
	public View getDropDownView(int position, View view, ViewGroup parent) {
		view = super.getDropDownView(position, view, parent);
		android.widget.AbsListView.LayoutParams params = new android.widget.AbsListView.LayoutParams( LayoutParams.FILL_PARENT, h, Gravity.TOP);
		view.setLayoutParams(params);
		return view;
	}
}

