package com.blablahlabs.excelsior.asynctasks;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.blablahlabs.excelsior.GalleryActivity;
import com.blablahlabs.excelsior.GalleryListActivity;
import com.blablahlabs.excelsior.Home;
import com.blablahlabs.excelsior.VideoListActivity;
import com.blablahlabs.excelsior.beans.ExcelsiorFotoGaleria;
import com.blablahlabs.excelsior.beans.ExcelsiorFotoGaleriaBean;
import com.blablahlabs.excelsior.beans.notas.GetGalleryResponse;
import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;

public class AsyncPhotoGalleryImage extends AsyncTask<URL, Void, Bitmap> {
	
	private Activity activity;
	private Net net;
	private int idFotoGaleria;
	private ExcelsiorFotoGaleriaBean bean;
	private ExcelsiorFotoGaleria excelsiorFotoGaleria;
	
	private ProgressDialog dialog;


	public AsyncPhotoGalleryImage (Activity activity, int idFotoGaleria){
		
			this.activity = activity;
			this.idFotoGaleria = idFotoGaleria;
    		this.excelsiorFotoGaleria = new ExcelsiorFotoGaleria();
		
		return;
	}
	
	
	@Override
	protected void onPreExecute(){
		this.net = new Net(this.activity.getApplicationContext());
		dialog= ProgressDialog.show(activity, "Actualizando", "Descargando la galeria fotogr‡fica, espere un momento ...", true);
		return;
	}
	
	
	@Override
	protected Bitmap doInBackground(URL... urls) {
		Bitmap img = null;
        try {
        	bean = net.getFotoGaleriaBean(idFotoGaleria);
        	
        	
        	bean.getGalleryResponse.remove(0);
        	for (GetGalleryResponse iterator :bean.getGalleryResponse){
        		img = net.getImagenGaleriaLista(iterator.idArchivo);

        		excelsiorFotoGaleria.agregar(img, iterator.descripcion);
        		
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
        
    	dialog.dismiss();
    	
//    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
//    	ObjectOutput out;
//    	try {
//    		out = new ObjectOutputStream(bos);
//    		out.writeObject( excelsiorFotoGaleria );
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    		IU.showToast(activity , "Hubo un error al serializar: " + e.getLocalizedMessage());
//    	}
//    	
//    	byte[] bytes1 = bos.toByteArray();
    	
    	if ( excelsiorFotoGaleria == null  || excelsiorFotoGaleria.excelsiorSingleFotoGaleria.size() <=0 ){
    		IU.showToast(activity.getApplicationContext(), "Ocurrio un error al cargar la FotoGaleria");
    	} 
    	else{
    		((GalleryListActivity) activity).excelsiorFotoGaleria = excelsiorFotoGaleria;
    		activity.startActivity( new Intent(activity, GalleryActivity.class)/*.<putExtra("bean", bytes1)*/);
    	}

    }
}