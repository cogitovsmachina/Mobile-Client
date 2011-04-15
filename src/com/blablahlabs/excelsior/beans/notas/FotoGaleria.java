package com.blablahlabs.excelsior.beans.notas;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class FotoGaleria implements Serializable {

	@SerializedName("ID_Galeria")
	public int idGaleria;
	
	@SerializedName("ID_Archivo")
	public int idArchivo;
	
	@SerializedName("Titulo")
	public String titulo;
	
	@SerializedName("Descripcion")
	public String descripcion;
	
	
}
