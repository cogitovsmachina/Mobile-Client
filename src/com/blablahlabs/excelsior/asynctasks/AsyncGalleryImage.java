package com.blablahlabs.excelsior.asynctasks;

import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.Recursos;

public class AsyncGalleryImage extends AsyncTask<URL, Void, Bitmap> {
	
	private Activity activity;
	private Net net;
	private ImageView imagen;
	private Bitmap img2;
	private int idArchivo;
	


	public AsyncGalleryImage (Activity activity, int idArchivo, ImageView imagen ){
		
			this.activity = activity;
			this.idArchivo = idArchivo;
			this.imagen = imagen;
		
		return;
	}
	
	
	@Override
	protected void onPreExecute(){
		this.net = new Net(this.activity.getApplicationContext());
		return;
	}
	
	
	@Override
	protected Bitmap doInBackground(URL... urls) {
		Bitmap img = null;
        try {
        	img = net.getImagenGaleriaLista(idArchivo);
		} catch (Exception e) {
			Log.e(Recursos.APP,"Ocurrio un error");
			Log.e(Recursos.APP,e.toString());
			e.printStackTrace();
		}
        return img;
    }
    

    @Override
	protected void onPostExecute(Bitmap img) {    	
    	int dstWidth = 156;
		int dstHeight = 98;
		boolean filter = false;
		if (img != null)
		img2 = Bitmap.createScaledBitmap(img, dstWidth, dstHeight, filter);
    	imagen.setImageBitmap(img2);
    }
}