package com.blablahlabs.excelsior;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.blablahlabs.excelsior.asynctasks.AsyncNotes;
import com.blablahlabs.excelsior.asynctasks.AsyncPhotoGalleryImage;
import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.ExcelsiorFotoGaleria;
import com.blablahlabs.excelsior.beans.notas.FotoGaleria;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.commonsware.cwac.merge.MergeAdapter;



public class GalleryListActivity extends ListActivity {
		
	private MergeAdapter listGalleryAdapter;

	private ExcelsiorBean excelsiorBean;

	private GalleryCustomAdapter nAdapter;

	private Activity activity;

	private int idArchivo;

	private List<FotoGaleria> bean;
	
	public static ExcelsiorFotoGaleria excelsiorFotoGaleria;
	


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        IU.setCustomTitle(this);	
		setContentView(R.layout.video_section);
		
		Bundle extras = getIntent().getExtras();
		byte[] bytes =  extras.getByteArray("bean");
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInput in;
		try {
			in = new ObjectInputStream(bis);
			bean =  (List<FotoGaleria>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			IU.showToast(GalleryListActivity.this , "Hubo un error al deserializar: " + e.getLocalizedMessage());
		}
				
		buildGalleryList();
		
		activity = this;
	}
	

	private void buildGalleryList() {
		listGalleryAdapter = new MergeAdapter();
				
  		 nAdapter = new GalleryCustomAdapter(GalleryListActivity.this, R.layout.row_gallery, (ArrayList<FotoGaleria>) bean);

  		listGalleryAdapter.addAdapter(nAdapter);	
		
		//commit para actualizar la vista 
		setListAdapter(listGalleryAdapter);

	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gallery_menu, menu);
        return true;
    }
	
	/*
	*  Giving logic to the option menu 
	*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        
        case R.id.home_image: 
        	startActivity( new Intent(this, Home.class) );
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
            		IU.showToast(GalleryListActivity.this , "Hubo un error al serializar: " + e.getLocalizedMessage());
            	}   
            	byte[] bytes1 = bos.toByteArray();
            	
				startActivity( new Intent(this, VideoListActivity.class).putExtra("bean", bytes1));
                                break;
                                
            case R.id.share_image: 
            	ShareMenu.buildShareMenu(getApplicationContext(),
            			 Recursos.TITULO_COMPARTIR,
            			 Recursos.COMPARTIR_HOME);
                                break;
        }
        return true;
    }
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		//String temp = bean.get(position).titulo;
		new AsyncPhotoGalleryImage(activity, bean.get(position).idGaleria).execute();


//		startActivity( new Intent(this, ViewGallery.class).putExtra("titulo", temp));
		
			
		
    }


}
