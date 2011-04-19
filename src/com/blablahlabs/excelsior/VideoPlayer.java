package com.blablahlabs.excelsior;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;


public class VideoPlayer extends Activity {
	
	  private ExcelsiorBean excelsiorBean;

	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        IU.setCustomTitle(this);
	        setContentView(R.layout.video_player);
	       
	        Bundle extras = getIntent().getExtras();
			String video = extras.getString("nombre_video");
			String video_without_mp4 = video.substring(0, video.length()-3);
			
	        //Calling VideoView
	        VideoView videoView = (VideoView) findViewById(R.id.VideoView);
			MediaController mediaController = new MediaController(this);
			mediaController.setAnchorView(videoView);
			
			String resource= "http://148.240.229.64/Video/" + video_without_mp4 + "3gp" ;
			mediaController = new MediaController(this);
			mediaController.setMediaPlayer(videoView);
			videoView.setVideoPath(resource); 
			videoView.setMediaController(mediaController);
			videoView.requestFocus();
			videoView.start();
			mediaController.show();
	  }

}
