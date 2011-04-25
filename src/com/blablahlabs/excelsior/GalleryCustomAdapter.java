package com.blablahlabs.excelsior;

import java.util.ArrayList;
import java.util.List;

import com.blablahlabs.excelsior.NotaAdapterSeccion.ViewHolder;
import com.blablahlabs.excelsior.asynctasks.AsyncGalleryImage;
import com.blablahlabs.excelsior.beans.notas.FotoGaleria;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.recursos.Recursos;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class GalleryCustomAdapter extends ArrayAdapter<FotoGaleria> {

    private ArrayList<FotoGaleria> items;
	private Activity activity;
	private Context context;
	private ImageView img;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;


    public GalleryCustomAdapter(Activity activity, int textViewResourceId, ArrayList<FotoGaleria> items) {
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
    	
public FotoGaleria getItem(FotoGaleria position) {
        return position;
}

public long getItemId(int position) {
   return position;
}

public static class ViewHolder{
    public TextView title;
    public ImageView image;
}

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            ViewHolder holder;
            if (convertView == null) {
            	v = inflater.inflate(R.layout.row, null);
            	holder = new ViewHolder();
            	
            	holder.title = (TextView)v.findViewById(R.id.title);
            	holder.image = (ImageView)v.findViewById(R.id.icon);
            	v.setTag(holder);
            }
            else {        
            	holder=(ViewHolder)v.getTag();
              	 }
            

            FotoGaleria mGallery = items.get(position);
            if (mGallery != null) {
                holder.title.setText(Html.fromHtml(mGallery.titulo));
                holder.image.setTag(mGallery.idArchivo);
                
                imageLoader.DisplayImage(Recursos.URL_FOTO + mGallery.idArchivo
                		+ Recursos.URL_IMAGEN_NOTA_OUTTRO, activity, holder.image);
                return v;
            }
            return v;
    }
}