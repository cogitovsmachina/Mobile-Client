                                                        package com.blablahlabs.excelsior;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.recursos.IU;


public class VideoPlayer extends Activity {
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	
	  private ExcelsiorBean excelsiorBean;

	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        IU.setCustomTitle(this);
	        setContentView(R.layout.video_player);
	       
	        Bundle extras = getIntent().getExtras();
			String video = extras.getString("nombre_video");
			String video_without_mp4 = video.substring(0, video.length()-3);
			
//			String path="http://www.ted.com/talks/download/video/8584/talk/761";
//		    String path1="http://commonsware.com/misc/test2.3gp";
//
//		    Uri uri=Uri.parse(path);
			

			
	        //Calling VideoView
	        VideoView videoView = (VideoView) findViewById(R.id.VideoView);
			MediaController mediaController = new MediaController(this);
			mediaController.setAnchorView(videoView);
			String resource= "http://148.240.229.64/Video/" + video_without_mp4 +"mp4";
			mediaController = new MediaController(this);
			mediaController.setMediaPlayer(videoView); 
//			Uri uri = Uri.parse(resource);
//			videoView.setVideoURI(uri);
			videoView.setVideoPath(resource);  
			videoView.setMediaController(mediaController); 
			videoView.start(); 
			videoView.requestFocus();
			mediaController.show();

	  }

}
