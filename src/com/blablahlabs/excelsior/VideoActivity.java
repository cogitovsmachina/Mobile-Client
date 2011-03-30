package com.blablahlabs.excelsior;

import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.blablahlabs.excelsior.beans.notas.VideosPagina;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;



public class VideoActivity extends Activity {
	
	 List<VideosPagina> bean;
	
	boolean temp;
	
	@SuppressWarnings("unchecked")
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
			bean =  (List<VideosPagina>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			IU.showToast(VideoActivity.this , "Hubo un error al deserializar: " + e.getLocalizedMessage());
		}
		
		temp = false;
		
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.videos_menu, menu);
        return true;
    }
	
	/*
	*  Giving logic to the option menu 
	*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_image: 
            	ShareMenu.buildShareMenu(getApplicationContext(),
            			 Recursos.TITULO_COMPARTIR,
            			 Recursos.COMPARTIR_HOME);
                                break;
            case R.id.gallery_image:     
            	IU.showToast(getApplicationContext(), "You want to go to gallery!");
                                break;
            case R.id.movies_image: 
            	IU.showToast(getApplicationContext(), "You want to go to main menu!");
                                break;
            case R.id.refresh: 
//            	refresh();
                                break;
        }
        return true;
    }


}
