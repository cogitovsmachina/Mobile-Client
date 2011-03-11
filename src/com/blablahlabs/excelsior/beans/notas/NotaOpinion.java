package com.blablahlabs.excelsior.beans.notas;

import com.google.gson.annotations.SerializedName;

public class NotaOpinion {
		
	@SerializedName("ID_Nota")
	public int idNota;
	
	@SerializedName("Titulo")
	public String titulo;
	
	@SerializedName("Sumario")
	public String sumario;
	
	@SerializedName("ID_Foto_Portada")
	public int idFotoPortada;

	@SerializedName("Fecha_Publicacion")
	public String fechaPublicacion;
	
	@SerializedName("Autor")
	public String autor;
	
	@SerializedName("id_seccion")
	public int idSeccion;
	
	@SerializedName("image_vertical")
	public String imageVertical;
	
}
