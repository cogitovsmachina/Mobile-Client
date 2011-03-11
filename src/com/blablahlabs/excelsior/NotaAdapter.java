package com.blablahlabs.excelsior;

import java.util.ArrayList;

import com.blablahlabs.excelsior.beans.notas.Nota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class NotaAdapter extends ArrayAdapter<Nota> {

    private ArrayList<Nota> items;
	private Context context;

    public NotaAdapter(Context context, int textViewResourceId, ArrayList<Nota> items) {
            super(context, textViewResourceId, items);
            this.items = items;
            this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);
            }
            Nota o = items.get(position);
            if (o != null) {
                    TextView tt = (TextView) v.findViewById(R.id.toptext);
                    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                    if (tt != null) {
                          tt.setText("Name: "+o.titulo);                            }
                    if(bt != null){
                          bt.setText("Status: "+ o.balazo);
                    }
            }
            return v;
    }
}