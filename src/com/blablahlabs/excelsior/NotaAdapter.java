package com.blablahlabs.excelsior;

import java.util.ArrayList;

import com.blablahlabs.excelsior.beans.notas.Nota;
import com.blablahlabs.excelsior.beans.notas.NotaUltimaHora;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class NotaAdapter extends ArrayAdapter<NotaUltimaHora> {
//class NotaAdapter extends ArrayAdapter<Nota> {

    private ArrayList<NotaUltimaHora> items;
	private Context context;

    public NotaAdapter(Context context, int textViewResourceId, ArrayList<NotaUltimaHora> items) {
            super(context, textViewResourceId, items);
            this.items = items;
            this.context = context;
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);
            }
            Nota mnota = items.get(position);
            if (mnota != null) {
                    TextView tt = (TextView) v.findViewById(R.id.title);
                    TextView bt = (TextView) v.findViewById(R.id.shot);
                    if (tt != null)
                          tt.setText(Html.fromHtml(mnota.titulo));
                    if(bt != null)
                    	 bt.setText(Html.fromHtml(mnota.balazo));
            }
            return v;
    }
}