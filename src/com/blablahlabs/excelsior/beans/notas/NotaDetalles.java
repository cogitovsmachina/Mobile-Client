package com.blablahlabs.excelsior.beans.notas;

import com.google.gson.annotations.SerializedName;

public class NotaDetalles {
	
	@SerializedName("ID_Nota")
	public int idNota;
	
	@SerializedName("Titulo")
	public String titulo;
	
	@SerializedName("Balazo")
	public String balazo;

	@SerializedName("Introduccion")
	public String introduccion;
	
	@SerializedName("Contenido")
	public String contenido;
	
	@SerializedName("Fecha_Publicacion")
	public String fechaPublicacion;
	
	@SerializedName("Fuente")
	public String fuente;
	
	@SerializedName("Link")
	public String link;
	
	@SerializedName("ID_Galeria_Foto")
	public String idGaleriaFoto;

	@SerializedName("Firma")
	public String firma;

	
}
