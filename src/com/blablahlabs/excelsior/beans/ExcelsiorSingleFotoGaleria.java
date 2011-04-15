package com.blablahlabs.excelsior.beans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.graphics.Bitmap;

public class ExcelsiorSingleFotoGaleria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9130421564461295771L;
	
	private Bitmap imagen;
	private String descripcion;
	
	public ExcelsiorSingleFotoGaleria(Bitmap imagen, String descripcion) {
		this.imagen = imagen;
		this.descripcion = descripcion;
	}
	
	
	public Bitmap getImagen() {
		return imagen;
	}
	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.write(imagen.getRowBytes());
		out.write(imagen.getHeight());
		out.write(imagen.getWidth());	
		
		out.writeObject(imagen);
		out.writeObject(descripcion);
		
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		imagen = (Bitmap) in.readObject();
		descripcion = (String) in.readObject();
		
	}
	
}
