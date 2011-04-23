package com.blablahlabs.excelsior.asynctasks;

import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.blablahlabs.excelsior.R;
import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.blablahlabs.excelsior.recursos.Recursos.ListaNota;


public class AsyncMainListImage extends AsyncTask<URL, Void, Bitmap> {
	
	private Activity activity;
	private int idFoto;
	private Net net;
	private ImageView imagen;
	private Bitmap img2;
	private ListaNota lNota;
	


	public AsyncMainListImage (Activity activity, int idFoto, ImageView imagen, ListaNota lNota ){
		
			this.activity = activity;
			this.idFoto = idFoto;
			this.imagen = imagen;
			this.lNota = lNota;
		
		return;
	}
	
	
	@Override
	protected void onPreExecute(){
		this.net = new Net(this.activity.getApplicationContext());
		this.imagen.setBackgroundResource(R.drawable.row_photo);
		return;
	}
	
	
	@Override
	protected Bitmap doInBackground(URL... urls) {

		Bitmap img = null;
        try {
    		if(lNota == ListaNota.SECCION){
        	img = net.getImagenListaPrincipal(this.idFoto);
    		}
    		else if(lNota == ListaNota.OPINION){
   			String temp = Recursos.URL_FOTO_OPINION + idFoto +"_v"+ Recursos.URL_IMAGEN_NOTA_OUTTRO;
    		img = net.getImagen(Recursos.URL_FOTO_OPINION + idFoto +"_v"+ Recursos.URL_IMAGEN_NOTA_OUTTRO);
    		}  	
		} catch (Exception e) {
			Log.e(Recursos.APP,"Ocurrio un error");
			Log.e(Recursos.APP,e.toString());
			e.printStackTrace();
		}
        return img;
    }
    

    @Override
	protected void onPostExecute(Bitmap img) {    	
    	int dstWidth = 101; 
		int dstHeight = 160; 
		boolean filter = false;
		if (img != null)
		img2 = Bitmap.createScaledBitmap(img, dstWidth, dstHeight, filter);
    	imagen.setImageBitmap(img2);
    }
}