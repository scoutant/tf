package org.scoutant.tf.command;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public abstract class HttpGetCommand implements CommandWithInt {

	private static final String tag = "http";
	HttpClient client;
	
	public HttpGetCommand() {
		client = new DefaultHttpClient();
	}

	protected InputStream doGet(String url) {
		InputStream is = null;
		Log.i (tag, "GET : " + url);
		HttpResponse response = null;
		long before = new Date().getTime();
		try {
			response = client.execute( new HttpGet( url));
		} catch (ClientProtocolException e) {
			Log.e(tag, "url : " + url, e);
			return null;
		} catch (IOException e) {
			Log.e(tag, "url : " + url, e);
			return null;
		}
		
		int code = response.getStatusLine().getStatusCode();
		Log.d(tag, "http status : " + code);
		
		try {
			is = response.getEntity().getContent();
		} catch (IllegalStateException e) {
			Log.e(tag, "url : " + url, e);
			return null;
		} catch (IOException e) {
			Log.e(tag, "url : " + url, e);
			return null;
		}
		long duration = (new Date().getTime() - before);
		Log.e(tag, "duration : " + duration + " ms");

		return is;
		// TODO close connection?
	}	
}
