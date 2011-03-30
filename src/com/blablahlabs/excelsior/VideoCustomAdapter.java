package com.blablahlabs.excelsior;

import java.util.ArrayList;
import java.util.List;

import com.blablahlabs.excelsior.asynctasks.AsyncImage;
import com.blablahlabs.excelsior.beans.notas.VideosPagina;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class VideoCustomAdapter extends ArrayAdapter<VideosPagina> {

    private ArrayList<VideosPagina> items;
	private Activity activity;
	private Context context;


    public VideoCustomAdapter(Activity activity, int textViewResourceId, ArrayList<VideosPagina> items) {
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

            
            VideosPagina mVideos = items.get(position);
            if (mVideos != null) {
                    TextView tt = (TextView) v.findViewById(R.id.title);
//                    ImageView img = (ImageView) v.findViewById(R.id.icon);
                    if (tt != null)
                          tt.setText(Html.fromHtml(mVideos.titulo));
//                    new AsyncImage(activity, mVideos.idArchivo, img).execute();
            }
            return v;
    }
}