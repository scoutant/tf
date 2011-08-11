package org.scoutant.tf.command;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public abstract class HttpGetCommand implements Command {

	private static final String tag = "http";
	HttpClient client;
	
	public HttpGetCommand() {
		client = new DefaultHttpClient();
	}

	protected InputStream doGet(String url) {
		Log.i (tag, "GET : " + url);
		HttpResponse response = null;
		try {
			response = client.execute( new HttpGet( url));
		} catch (ClientProtocolException e) {
			Log.e(tag, "url : " + url, e);
		} catch (IOException e) {
			Log.e(tag, "url : " + url, e);
		}
		
		int code = response.getStatusLine().getStatusCode();
		Log.d(tag, "http status : " + code);
		
		InputStream is = null;
		try {
			is = response.getEntity().getContent();
		} catch (IllegalStateException e) {
			Log.e(tag, "url : " + url, e);
		} catch (IOException e) {
			Log.e(tag, "url : " + url, e);
		}
		return is;
		// TODO close connection?
	}
	
}
