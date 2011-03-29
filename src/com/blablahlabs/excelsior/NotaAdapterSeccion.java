package com.blablahlabs.excelsior;

import java.util.ArrayList;

import com.blablahlabs.excelsior.asynctasks.AsyncImage;
import com.blablahlabs.excelsior.beans.notas.Nota;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class NotaAdapterSeccion extends ArrayAdapter<NotaSeccion> {

    private ArrayList<NotaSeccion> items;
	private Activity activity;
	private Context context;


    public NotaAdapterSeccion(Activity activity, int textViewResourceId, ArrayList<NotaSeccion> items) {
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
            NotaSeccion mnota = items.get(position);
            if (mnota != null) {
                    TextView tt = (TextView) v.findViewById(R.id.title);
                    TextView bt = (TextView) v.findViewById(R.id.shot);
                    ImageView img = (ImageView) v.findViewById(R.id.icon);
                    if (tt != null)
                          tt.setText(Html.fromHtml(mnota.titulo));
                    if(bt != null)
                          bt.setText(Html.fromHtml(mnota.balazo));
                    new AsyncImage(activity, mnota.idFotoPortada, img).execute();
            }
            return v;
    }
}