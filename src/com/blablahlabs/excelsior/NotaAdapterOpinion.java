package com.blablahlabs.excelsior;

import java.util.ArrayList;

import com.blablahlabs.excelsior.NotaAdapterSeccion.ViewHolder;
import com.blablahlabs.excelsior.asynctasks.AsyncMainListImage;
import com.blablahlabs.excelsior.beans.notas.Nota;
import com.blablahlabs.excelsior.beans.notas.NotaOpinion;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.blablahlabs.excelsior.recursos.Recursos.ListaNota;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class NotaAdapterOpinion extends ArrayAdapter<NotaOpinion> {

    private ArrayList<NotaOpinion> items;
	private Activity activity;
	private Context context;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;


    public NotaAdapterOpinion(Activity activity, int textViewResourceId, ArrayList<NotaOpinion> items) {
            super(activity.getApplicationContext(), textViewResourceId, items);
            this.items = items;
            this.activity = activity;
            this.context = activity.getApplicationContext();
            
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            imageLoader=new ImageLoader(activity.getApplicationContext());
    }
    
public int getCount() {
        return items.size();
    }
    	
public NotaOpinion getItem(NotaOpinion position) {
        return position;
    }
    

public long getItemId(int position) {
        return position;
    }
    
public static class ViewHolder{
        public TextView title;
        public ImageView image;
        public TextView shot;
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            ViewHolder holder;
           
            if (convertView == null) {
            	v = inflater.inflate(R.layout.row, null);
            	holder = new ViewHolder();
            	
            	holder.title = (TextView)v.findViewById(R.id.title);
            	holder.shot = (TextView)v.findViewById(R.id.shot);
            	holder.image = (ImageView)v.findViewById(R.id.icon);
            	v.setTag(holder);
            }
            else {        
            	holder=(ViewHolder)v.getTag();
              	 }
            
            NotaOpinion mNota = items.get(position);
            
            if (mNota != null) {
            	
            	 holder.title.setText(Html.fromHtml(mNota.autor));
                 holder.shot.setText(Html.fromHtml(mNota.titulo));
                 holder.image.setTag(mNota.imageVertical);
                
                 imageLoader.DisplayImage(Recursos.URL_FOTO_OPINION +
                    		mNota.imageVertical, activity, holder.image);
            }
            return v;
    }
}