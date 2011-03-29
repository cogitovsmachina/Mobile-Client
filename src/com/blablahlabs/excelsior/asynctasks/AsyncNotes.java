package com.blablahlabs.excelsior.asynctasks;

import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.blablahlabs.excelsior.Home;
import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.Recursos;


public class AsyncNotes extends AsyncTask<URL, Void, ExcelsiorBean> {
    
	
	private Activity activity;
	private ProgressDialog dialog;
	private Net net;
	


	public AsyncNotes (Activity activity){
		this.activity = activity; 
		return;
	} 
	
	@Override
	protected void onPreExecute(){
		this.net = new Net(activity.getApplicationContext());
		dialog= ProgressDialog.show(activity, "Actualizando", "Descargando noticias, espere un momento ...", true);
		return;
	}
	
	
	@Override
	protected ExcelsiorBean doInBackground(URL... urls) {
		
		ExcelsiorBean ans = null;
        try {
        	ans = net.getDataBean();
        	


		} catch (Exception e) {
			Log.e(Recursos.APP,"Ocurrio un error");
			Log.e(Recursos.APP,e.toString());
			e.printStackTrace();
		}
	
        return ans ;
    }
    

    @Override
	protected void onPostExecute(ExcelsiorBean excelsiorBean_) {
    	dialog.dismiss();
    	if (excelsiorBean_ == null){
    		Toast.makeText(activity.getApplicationContext(), "Ha ocurrido un error, inténtalo más tarde", Toast.LENGTH_SHORT).show();
    	}
    	else{
    		((Home) activity).excelsiorBean=excelsiorBean_;
    		((Home) activity).showMainList();
    	
    }        		        		
    		
    	}
  
}