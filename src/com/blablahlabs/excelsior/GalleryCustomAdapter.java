package com.blablahlabs.excelsior;

import java.util.ArrayList;
import java.util.List;

import com.blablahlabs.excelsior.asynctasks.AsyncGalleryImage;
import com.blablahlabs.excelsior.beans.notas.FotoGaleria;

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


    public GalleryCustomAdapter(Activity activity, int textViewResourceId, ArrayList<FotoGaleria> items) {
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

            
            FotoGaleria mGallery = items.get(position);
            if (mGallery != null) {
                    TextView tt = (TextView) v.findViewById(R.id.title);
                    ImageView img = (ImageView) v.findViewById(R.id.icon);
                    if (tt != null)
                          tt.setText(Html.fromHtml(mGallery.titulo));
                    new AsyncGalleryImage(activity, mGallery.idArchivo, img).execute();
            }
            return v;
    }
}