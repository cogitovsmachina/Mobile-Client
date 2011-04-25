package com.blablahlabs.excelsior;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.recursos.Recursos;

class NotaAdapterSeccion extends ArrayAdapter<NotaSeccion> {

    private ArrayList<NotaSeccion> items;
	private Activity activity;
	private Context context;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;
	


    public NotaAdapterSeccion(Activity activity, int textViewResourceId, ArrayList<NotaSeccion> items) {
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
    	
    public NotaSeccion getItem(NotaSeccion position) {
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
            
            NotaSeccion mNota = items.get(position);
          
            if (mNota != null) {
                    
                    holder.title.setText(Html.fromHtml(mNota.titulo));
                    holder.shot.setText(Html.fromHtml(mNota.balazo));
                    holder.image.setTag(mNota.idFotoPortada);
                    
                    imageLoader.DisplayImage(Recursos.URL_IMAGEN_NOTA_LISTA_INTRO +
                    		mNota.idFotoPortada + Recursos.URL_IMAGEN_NOTA_OUTTRO, activity, holder.image);
                    return v;
             }
            return v;
    }
}