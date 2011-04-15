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
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.ExcelsiorFotoGaleriaBean;
import com.blablahlabs.excelsior.beans.ExcelsiorGson;
import com.blablahlabs.excelsior.beans.NotaBean;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.google.gson.Gson;

public class Net {
	
	private Context context;
	private SharedPreferences preferences;

	public Net(Context context){
		this.context = context;
    	this.preferences  = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public  ExcelsiorBean  getDataBean() throws IllegalStateException, IOException, URISyntaxException, JSONException{

		String ansHttpGet = null;
		Gson gson = new Gson();
		ExcelsiorBean excelsiorBean = null;
		
		if (isOnline() )
			ansHttpGet = inputStreamToString (getHttpGet(Recursos.URL_GENERAL) );
		else{
			ansHttpGet = loadData();			
		}
		
		if (ansHttpGet != null){
			excelsiorBean = new ExcelsiorBean(gson.fromJson(ansHttpGet, ExcelsiorGson.class));
			saveData(ansHttpGet);
		}
		
		return excelsiorBean;
		
	} 
	
	
	public NotaBean getNotaBean(int idNota)throws IllegalStateException, IOException, URISyntaxException, JSONException{
		
		String ansHttpGet = null;
		Gson gson = new Gson();
		NotaBean notaBean = null;
	
		if (isOnline() )
			ansHttpGet = inputStreamToString (getHttpGet(Recursos.URL_NOTA_DETALLE_INTRO + idNota + Recursos.URL_NOTA_DETALLE_OUTTRO) ) ;
		
		if (ansHttpGet != null){
			notaBean = gson.fromJson(ansHttpGet, NotaBean.class);
			
		}
		
		
		return notaBean;
	}
	
	public ExcelsiorFotoGaleriaBean getFotoGaleriaBean(int idFotoGaleria) throws IllegalStateException, IOException, URISyntaxException, JSONException{
		
		String ansHttpGet = null;
		Gson gson = new Gson();
		ExcelsiorFotoGaleriaBean bean = null;
		
		if (isOnline() )
			ansHttpGet = inputStreamToString(getHttpGet(Recursos.URL_GALERIA_FOTOS + idFotoGaleria + Recursos.URL_NOTA_DETALLE_OUTTRO));
		
		if (ansHttpGet != null){
			bean = gson.fromJson(ansHttpGet, ExcelsiorFotoGaleriaBean.class);
			
		}
		
		return bean;
	}

	
	public Bitmap getImagenDetalle (int idNota)throws IllegalStateException, IOException, URISyntaxException{
		
		Bitmap image = null;
		String url;
		InputStream input;
		
		if (isOnline() ){
			url = Recursos.URL_IMAGEN_NOTA_INTRO + idNota + Recursos.URL_IMAGEN_NOTA_OUTTRO;
			input = getHttpGet(url);
			image = inputStreamToBitMap (input ) ;
		}
		return image;
	}
	
	public Bitmap getImagenListaPrincipal (int idNota)throws IllegalStateException, IOException, URISyntaxException{
		
		Bitmap image = null;
		if (idNota != 0){
			if (isOnline() )
				image = inputStreamToBitMap (getHttpGet(Recursos.URL_IMAGEN_NOTA_LISTA_INTRO + idNota + Recursos.URL_IMAGEN_NOTA_OUTTRO) ) ;
		}
		
		return image;
		
	}
	
	public Bitmap getImagenVideoLista (int idArchivo)throws IllegalStateException, IOException, URISyntaxException{
		
		Bitmap image = null;
		if(idArchivo != 0){
			if (isOnline() )
				image = inputStreamToBitMap (getHttpGet(Recursos.URL_FOTO + idArchivo + Recursos.URL_IMAGEN_NOTA_OUTTRO) ) ;
		}
		return image;
	}
	
	public Bitmap getImagenGaleriaLista (int idArchivo)throws IllegalStateException, IOException, URISyntaxException{
		
		Bitmap image = null;
		if(idArchivo != 0){
			if (isOnline() )
				image = inputStreamToBitMap (getHttpGet(Recursos.URL_FOTO + idArchivo + Recursos.URL_IMAGEN_NOTA_OUTTRO) ) ;
		}
		return image;
	}
	
	public Bitmap getImagen(String url)throws IllegalStateException, IOException, URISyntaxException{
		
		Bitmap image = null;
		if(url != null){
			if (isOnline() )
				image = inputStreamToBitMap (getHttpGet(url)) ;
		}
		return image;
	}
	
	
	
	private  InputStream getHttpGet(String url) throws IllegalStateException, IOException, URISyntaxException{
		
		URI myURI = null;
		InputStream input = null;
		
		myURI = new URI(url);
		
		HttpParams httpParameters = new BasicHttpParams();
		// Set the timeout in milliseconds until a connection is established.
		int timeoutConnection = 3000;
		HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		// Set the default socket timeout (SO_TIMEOUT) 
		// in milliseconds which is the timeout for waiting for data.
		int timeoutSocket = 5000;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		
		HttpClient httpClient = new DefaultHttpClient(httpParameters);
		HttpGet getMethod = new HttpGet(myURI);
		HttpResponse webServerResponse = null;
		
		webServerResponse = httpClient.execute(getMethod);

		HttpEntity httpEntity = webServerResponse.getEntity();
		
		if (httpEntity != null) {
			 input = httpEntity.getContent();
		}
		
		return input;
		//return slurp(input);
	}
	
		
	public String inputStreamToString (InputStream in) throws IOException {
	    StringBuilder out = new StringBuilder();
	    byte[] b = new byte[4096];
	    for (int n; (n = in.read(b)) != -1;) {
	        out.append(new String(b, 0, n));
	    }
	    return out.toString();
	}

	public  Bitmap inputStreamToBitMap (InputStream in) throws IOException {
		Bitmap bitmap = null;
		
		bitmap=BitmapFactory.decodeStream( in ); 
		
		
		return bitmap;
	}
	
	
	
	private  boolean isOnline() {		
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

		boolean ans = false;
		final NetworkInfo network_info = cm.getActiveNetworkInfo();
				
		if ( network_info != null && network_info.isConnected() ) {
	    	Log.e("Testing Internet Connection", "We have internet");
	    	ans =  true; 
		}
		else {
			Log.e("Testing Internet Connection", "We dont have internet");
			ans =  false; 
		}
		
		return ans;

	}
	

	 private void saveData (String stringJson){
		 	 
		 SharedPreferences.Editor editor = preferences.edit();	
		 editor.putString("stringJson",stringJson);
		 editor.commit();
	    	
	 }
	    
	    
	   
	 private String loadData(){
		 return preferences.getString("stringJson", null);
	 }
		
}
