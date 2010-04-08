package com.android.rockband;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class HttpREST {
	public String getHMXSonglist(String url) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpclient.execute(get);
			Log.i("Gettings results from HMX Http Request: ", "HTTP STATUS:[ "+response.getStatusLine().toString()+" ]");
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				InputStream is = entity.getContent();
				String result = convertStreamToString(is);
				Log.i("Got Results. RAWK!", "Input Stream Conversion:[ "+result+"]");
				is.close();
				return result;
			}
		} catch (ClientProtocolException cpe) {
			Log.e(":(", "There was an IO stream error. I R Sad. :(", cpe);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return null;
	}
	
	public String convertStreamToString(InputStream is) {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
		return sb.toString();
	}
}
