package com.blablahlabs.excelsior;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blablahlabs.excelsior.asynctasks.AsyncNotes;
import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.NotaBean;
import com.blablahlabs.excelsior.beans.notas.VideosPagina;
import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;
public class ViewNoteActivity extends Activity {
	
	private ProgressDialog dialog;
	private int idNota;
	private int idFoto;
	private TextView title;
	private TextView content;
	private NotaBean bean;
	private ImageView image;
	public ExcelsiorBean excelsiorBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        IU.setCustomTitle(this);
		setContentView(R.layout.noteactivity);
	     Bundle extras = getIntent().getExtras();
         idNota = extras != null ? extras.getInt("id_nota") : -1;
         idFoto = extras != null ? extras.getInt("id_foto") : -1;
         
          title = (TextView)findViewById(R.id.note_title);
          content = (TextView)findViewById(R.id.note_content);
          image = (ImageView)findViewById(R.id.note_image);
          new PostNote(this, idNota, idFoto).execute();
	}

    
    /*
	*      Inflating the option Menu
	*/
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.note_menu, menu);
        return true;
    }
    
	
	/*
	*  Giving logic to the option menu 
	*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_image:  
            	ShareMenu.buildShareMenu(getApplicationContext(), Recursos.TITULO_COMPARTIR,
            			bean.singleResponse.titulo +"  " +
            			" http://www.excelsior.com.mx/index.php?m=nota&id_nota="
            			+ bean.singleResponse.idNota);
                                break;
            case R.id.gallery_image:
            	ByteArrayOutputStream byteAO = new ByteArrayOutputStream();
            	ObjectOutput output;
            	try {
            		output = new ObjectOutputStream(byteAO);
            		excelsiorBean = Home.excelsiorBean;
            		output.writeObject(excelsiorBean.getFotoGaleria());
            	} catch (IOException e) {
            		e.printStackTrace();
            		IU.showToast(ViewNoteActivity.this , "Hubo un error al serializar: " + e.getLocalizedMessage());
            	}   
            	byte[] bytes = byteAO.toByteArray();
				startActivity( new Intent(this, GalleryListActivity.class).putExtra("bean", bytes));
            	
                                break;
            case R.id.movies_image:     
            	ByteArrayOutputStream bos = new ByteArrayOutputStream();
            	ObjectOutput out;
            	try {
            		out = new ObjectOutputStream(bos);
            		excelsiorBean = Home.excelsiorBean;
            		out.writeObject(excelsiorBean.getVideosPagina());
            	} catch (IOException e) {
            		e.printStackTrace();
            		IU.showToast(ViewNoteActivity.this , "Hubo un error al serializar: " + e.getLocalizedMessage());
            	}   
            	byte[] bytes1 = bos.toByteArray();
            	
				startActivity( new Intent(this, VideoListActivity.class).putExtra("bean", bytes1));
                                break;
        }
        return true;
    }
    
   
    
    private class PostNote extends AsyncTask<URL, Void, ImageBean> {
    	
    	private Activity activity;
		private int idNota;
		private int idFoto;
		private Net net;
		private int dstWidth;
		private int dstHeight;
		private ImageView imagen;
		private Bitmap img2;


		public PostNote (Activity activity, int idNota, int idFoto){
    		
    			this.activity = activity;
    			this.idNota = idNota;
    			this.idFoto = idFoto;
    		
    		return;
    	}
    	
    	
		@Override
		protected void onPreExecute(){
			this.net = new Net(activity.getApplicationContext());
    		dialog= ProgressDialog.show(activity, "Actualizando", "Actualizando los contenidos", true);
    		return;
    	}
    	
    	
    	@Override
		protected ImageBean doInBackground(URL... urls) {

    		NotaBean bean = null;
    		Bitmap imagen = null;
            try {
            	bean = net.getNotaBean(idNota);
            	imagen = net.getImagenDetalle(idFoto);
			} catch (Exception e) {
				Log.e(Recursos.APP,"Ocurrio un error");
				Log.e(Recursos.APP,e.toString());
				e.printStackTrace();
			}
			
			ImageBean imagenBean = new ImageBean();
			imagenBean.bean = bean;
			imagenBean.imagen = imagen;
			
            return imagenBean;
        }
        

        @Override
		protected void onPostExecute(ImageBean bean_) {
        	dialog.dismiss();
        	if (bean_.bean == null){
        		IU.showInfoDialog(activity);
        	}
        	else{
        		title.setText(Html.fromHtml(bean_.bean.singleResponse.titulo));
        		content.setText(Html.fromHtml(bean_.bean.singleResponse.contenido));
        		bean = bean_.bean ;
        	}        		        		
        	
        	if (bean_.imagen != null){
        		dstWidth = 480;
        		dstHeight = 100;
        		boolean filter = false;
        		image.setImageBitmap(bean_.imagen);
        		img2 = Bitmap.createScaledBitmap(bean_.imagen, dstWidth, dstHeight, filter);
    			image.setImageBitmap(img2);
        	}
        	else
        		image.setBackgroundResource(R.drawable.note_default_image);
        }
    }
	
    
    public class ImageBean {
    	public NotaBean bean = null;
		public Bitmap imagen = null; 
    	
    }
}
