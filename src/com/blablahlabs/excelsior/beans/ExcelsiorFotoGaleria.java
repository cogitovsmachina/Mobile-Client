package com.blablahlabs.excelsior.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;


public class ExcelsiorFotoGaleria implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 9205632975286641518L;
	public List<ExcelsiorSingleFotoGaleria> excelsiorSingleFotoGaleria = new ArrayList<ExcelsiorSingleFotoGaleria>();
	 
	 public void agregar(Bitmap imagen, String descripcion){
		 this.excelsiorSingleFotoGaleria.add(new ExcelsiorSingleFotoGaleria(imagen, descripcion));
		 return;
	 }
}
