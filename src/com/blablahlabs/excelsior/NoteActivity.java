package com.blablahlabs.excelsior;

import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.blablahlabs.excelsior.beans.NotaBean;
import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;

public class NoteActivity extends Activity {
	
	private ProgressDialog dialog;
	private Net net;
	private int idNota;
	private TextView title;
	private TextView content;
	private NotaBean bean;
	private Activity activity;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setCustomTitle();
		setContentView(R.layout.noteactivity);
		net = new Net(getApplicationContext());
	     Bundle extras = getIntent().getExtras();
         idNota = extras != null ? extras.getInt("id_nota") : -1;
         
          title = (TextView)findViewById(R.id.note_title);
          content = (TextView)findViewById(R.id.note_content);
          activity = this;
          new PostNote().execute();
	}

    
    /*
	*      Inflating the option Menu
	*/
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    
	
	/*
	*  Giving logic to the option menu 
	*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_image:   
            	buildShareMenu();
                                break;
            case R.id.gallery_image:     
            	Toast.makeText(this, "You want to go to gallery!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.movies_image: 
            	Toast.makeText(this, "You want to go to movies!", Toast.LENGTH_LONG).show();
                                break;
        }
        return true;
    }
    
    /*
     *  Method to create ACTION_SEND Implementation :) 
     */
    private void buildShareMenu() {
    	Intent mIntent = new Intent(android.content.Intent.ACTION_SEND);
    	mIntent.setType("text/plain");
    	mIntent.putExtra(Intent.EXTRA_TEXT, bean.singleResponse.titulo +"   http://www.excelsior.com.mx/index.php?m=nota&id_nota=" + bean.singleResponse.idNota);
    	startActivity(Intent.createChooser(mIntent, "Compartir en"));		
    }
    
    
    private class PostNote extends AsyncTask<URL, Void, NotaBean> {





		protected void onPreExecute(){
    		dialog= ProgressDialog.show(NoteActivity.this, "Actualizando", "Actualizando los contenidos", true);
    		return;
    	}
    	
    	
    	protected NotaBean doInBackground(URL... urls) {
    		
    		
           // int count = urls.length;
    		NotaBean ans = null;
            try {
            	ans = net.getNotaBean(idNota);
            	


			} catch (Exception e) {
				Log.e(Recursos.APP,"Ocurrio un error");
				Log.e(Recursos.APP,e.toString());
				e.printStackTrace();
			}
			
		
            return ans ;
        }
        

        protected void onPostExecute(NotaBean bean_) {
        	dialog.dismiss();
        	if (bean_ == null){
        		IU.showInfoDialog(activity);
        		
        	}
        	else{
        		title.setText(Html.fromHtml(bean_.singleResponse.titulo));
        		content.setText(Html.fromHtml(bean_.singleResponse.contenido));
        		
        		bean = bean_ ;
        	}        		        		
        		
        }


		

    }
	
    public void setCustomTitle() {
    	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
	}
}
