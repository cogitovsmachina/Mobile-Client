package com.blablahlabs.excelsior;

import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.notas.VideosPagina;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.commonsware.cwac.merge.MergeAdapter;



public class VideoActivity extends ListActivity {
	
	 List<VideosPagina> bean;
	
	private MergeAdapter listVideoAdapter;

	private ExcelsiorBean excelsiorBean;

	private VideoCustomAdapter nAdapter;
	
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
				
		buildVideoList();
		
	}
	
	private void buildVideoList() {
   		listVideoAdapter=new MergeAdapter();
		
   		
		
		 nAdapter = new VideoCustomAdapter(VideoActivity.this, R.layout.row_video, (ArrayList<VideosPagina>) bean);
		 listVideoAdapter.addAdapter(nAdapter);	
		
		//commit para actualizar la vista 
		setListAdapter(listVideoAdapter);

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
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String temp = bean.get(position).nombreVideo;
		startActivity( new Intent(this, VideoPlayer.class).putExtra("nombre_video", temp));
		
			
		
    }


}
