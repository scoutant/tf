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
		country.add( new Network("Lyon", 2, 69, 45.763, 4.91)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_coraly&source1=cir&raster=lyon")
		);
		country.add( new Network("Grenoble", 1, 38, 45.1794, 5.7316)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_grenoble&source1=cir&raster=grenoble")
		);
		country.add( new Network("Bordeaux", 0, 33, 44.8375, -0.5795)
		.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_alienor&source1=cir&raster=bordeaux")
	);
//		Log.d(tag, ""+country);
	}
}