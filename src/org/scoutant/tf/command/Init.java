package org.scoutant.tf.command;

import org.scoutant.tf.model.Country;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Network;

import android.util.Log;

/**
 * During dev may use http://blog.scoutant.org/assets/markers.html
 */
public class Init implements Command {
	private static final String tag = "command";
	Country country = Model.model().country;

	@Override
	public void execute() {
		Log.d(tag, "***************************************************************************************");
		country.add( new Network("Toulouse", 0, 31, 43.604, 1.447)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_toulouse&source1=cir&raster=toulouse"));
		country.add( new Network("Bordeaux", 1, 33, 44.8375, -0.5795)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_alienor&source1=cir&raster=bordeaux"));
		country.add( new Network("Grenoble", 2, 38, 45.1794, 5.7316)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_grenoble&source1=cir&raster=grenoble"));
		country.add( new Network("Strasbourg", 3, 67, 48.567, 7.746)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_gutenberg&source1=cir&raster=strasbourg"));
		country.add( new Network("Lyon", 4, 69, 45.763, 4.91)
			.set("http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_coraly&source1=cir&raster=lyon"));
		// Bison Futé integrates data from Sytadin:
		country.add( new Network("Paris, IdF", 5, 75, 48.855, 2.33).set("http://www.sytadin.fr/raster/segment_IDF.gif"));
	
		// http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_marseille&source1=cir&raster=marseille
		// http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_allegro&source1=cir&raster=lille
		// http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_nantes&source1=cir&raster=nantes
		// http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_dor_breizh&source1=cir&raster=rennes
		// http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_toulon&source1=cir&raster=toulon
		// http://www.bison-fute.equipement.gouv.fr/asteccli/servlet/clientleger?format=png&source0=cigt_stetienne&source1=cir&raster=stetienne
		// http://www.sytadin.fr/raster/segment_IDF.gif
		// speed : http://www.sytadin.fr/raster/arc_IDF.gif
	}
}