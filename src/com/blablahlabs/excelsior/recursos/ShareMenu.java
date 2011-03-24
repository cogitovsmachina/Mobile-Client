package com.blablahlabs.excelsior.recursos;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ShareMenu{
	private Context context;
	

	public ShareMenu(Context context){
		this.context = context;
		
	}
	
	public static void buildHomeShareMenu(Context context) {
        Intent mIntent = new Intent(android.content.Intent.ACTION_SEND);
    	mIntent.setType("text/plain");
    	mIntent.putExtra(Intent.EXTRA_TEXT, Recursos.COMPARTIR_HOME);
//    	//mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    	context.startActivity(Intent.createChooser(mIntent, Recursos.TITULO_COMPARTIR));
		Intent i = Intent.createChooser(mIntent, Recursos.TITULO_COMPARTIR);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
    }
	
	public static void buildNoteShareMenu(final Activity activity) {
    	Intent mIntent = new Intent(android.content.Intent.ACTION_SEND);
    	mIntent.setType("text/plain");
    	mIntent.putExtra(Intent.EXTRA_TEXT, Recursos.COMPARTIR_HOME);
    	activity.startActivity(Intent.createChooser(mIntent, Recursos.TITULO_COMPARTIR));		
    }


}
