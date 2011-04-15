package com.blablahlabs.excelsior;

import java.util.ArrayList;

import com.blablahlabs.excelsior.asynctasks.AsyncMainListImage;
import com.blablahlabs.excelsior.beans.notas.Nota;
import com.blablahlabs.excelsior.beans.notas.NotaOpinion;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.recursos.Recursos.ListaNota;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
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


    public NotaAdapterOpinion(Activity activity, int textViewResourceId, ArrayList<NotaOpinion> items) {
            super(activity.getApplicationContext(), textViewResourceId, items);
            this.items = items;
            this.activity = activity;
            this.context = activity.getApplicationContext();
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);     
            }
            else {          
//            	v.findViewById(R.id.icon).setBackgroundResource(R.drawable.row_photo);
            	v.findViewById(R.id.icon).setBackgroundDrawable(null);
              }
            
            NotaOpinion mnota = items.get(position);
            if (mnota != null) {
                    TextView tt = (TextView) v.findViewById(R.id.title);
                    TextView bt = (TextView) v.findViewById(R.id.shot);
                    ImageView img = (ImageView) v.findViewById(R.id.icon);
                    if (tt != null)
                          tt.setText(Html.fromHtml(mnota.autor));
                    if(bt != null)
                          bt.setText(Html.fromHtml(mnota.titulo));
    
                   int idImagen =Integer.parseInt(mnota.imageVertical.substring(0, mnota.imageVertical.length()-6));
                    new AsyncMainListImage(activity, idImagen, img, ListaNota.OPINION).execute();
            }
            return v;
    }
}