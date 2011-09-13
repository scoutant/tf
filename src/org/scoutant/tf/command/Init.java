package org.scoutant.tf.command;

import org.scoutant.tf.model.Country;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Network;

import android.util.Log;

/**
 * During dev may use http://blog.scoutant.org/assets/markers.html
 *
 */
public class Init implements Command {
	private static final String tag = "command";
	Country country = Model.model().country;

	@Override
	public void execute() {
		Log.d(tag, "***************************************************************************************");
		country.add( new Network("Lyon", 69, 45.763, 4.91)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_coraly&source1=cir&raster=lyon")
		);
		country.add( new Network("Grenoble", 38, 45.1794, 5.7316)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_grenoble&source1=cir&raster=grenoble")
		);
		Log.d(tag, ""+country);
	}
}