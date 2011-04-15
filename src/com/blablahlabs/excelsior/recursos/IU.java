package com.blablahlabs.excelsior.recursos;

import com.blablahlabs.excelsior.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.widget.Toast;

	public class IU {


		public IU (Context context){
		}
		
		public static void showToast(Context context, String mensaje){    	
			Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
			return;
	    }
		
		public static void showInfoDialog(final Activity activity){
			
			AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			builder.setTitle("Excelsior en Android")
					.setMessage(Recursos.ERROR_NOTA)
					.setCancelable(false)
					.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			               activity.finish();
	
			           }
			       });
	
			AlertDialog alert = builder.create();
			
			alert.show();
			
		}

		public static void setCustomTitle (Activity activity){
			
			activity.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
			activity.setContentView(R.layout.main);
			activity.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
			
			return;
		}

	
}
