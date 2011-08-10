package org.scoutant.tf;


import android.os.Bundle;
import android.preference.PreferenceActivity;

/** Magaging app preferences following tutorial : http://jetpad.org/2011/01/creating-a-preference-activity-in-android */
public class Settings extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}

}
