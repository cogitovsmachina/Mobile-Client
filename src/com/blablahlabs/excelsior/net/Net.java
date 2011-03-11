package com.blablahlabs.excelsior.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.ExcelsiorGson;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.google.gson.Gson;

public class Net {
	
	
	
	public  static ExcelsiorBean  getDataJson() throws IllegalStateException, IOException, URISyntaxException, JSONException{

		String ansHttpGet = null;
		Gson gson = new Gson();
		
		ansHttpGet = getHttpGet();
		ExcelsiorBean excelsiorBean = new ExcelsiorBean(gson.fromJson(ansHttpGet, ExcelsiorGson.class));
		
		return excelsiorBean;
		
	} 
	
	
	private static String getHttpGet() throws IllegalStateException, IOException, URISyntaxException{
		
		URI myURI = null;
		InputStream input = null;
		
		myURI = new URI(Recursos.URL);
		//if (myURI == null) {return null;}
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet(myURI);
		HttpResponse webServerResponse = null;
		
		webServerResponse = httpClient.execute(getMethod);

		HttpEntity httpEntity = webServerResponse.getEntity();
		
		if (httpEntity != null) {
			 input = httpEntity.getContent();
		}
		
		
		return slurp(input);
	}
	
		
	public static String slurp (InputStream in) throws IOException {
	    StringBuilder out = new StringBuilder();
	    byte[] b = new byte[4096];
	    for (int n; (n = in.read(b)) != -1;) {
	        out.append(new String(b, 0, n));
	    }
	    return out.toString();
	}

}                                          