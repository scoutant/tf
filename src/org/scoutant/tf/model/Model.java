package org.scoutant.tf.model;

public class Model {

	private static Model _instance;
	public  static Model model() {
		if (_instance==null) _instance = new Model();
		return _instance;
	}

	public Country country = new Country();
}
