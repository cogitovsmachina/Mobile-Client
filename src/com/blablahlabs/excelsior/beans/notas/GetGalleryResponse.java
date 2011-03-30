package com.blablahlabs.excelsior.beans.notas;

import com.google.gson.annotations.SerializedName;

public class GetGalleryResponse {

	@SerializedName("ID_Galeria")
	public int idGaleria;
	
	@SerializedName("ID_Archivo_Previo")
	public int idArchivoPrevio;

	@SerializedName("ID_Archivo")
	public int idArchivo;
	
	@SerializedName("ID_Seccion")
	public String idSeccion;
	
	@SerializedName("ID_Usuario")
	public int idUsuario;
	
	@SerializedName("Tipo")
	public int tipo;
	
	@SerializedName("Titulo")
	public String titulo;
	
	@SerializedName("Descripcion")
	public String descripcion;

	@SerializedName("Fecha")
	public String fecha;
	
	@SerializedName("Fecha_Creacion")
	public String fechaCreacion;
	
	@SerializedName("Fecha_Modificacion")
	public String fechaModificacion;
	
	@SerializedName("Tags")
	public String tags;
	
	@SerializedName("Estatus")
	public String estatus;
	
	@SerializedName("Author")
	public String author;

	@SerializedName("Agencia")
	public String agencia;
	
	@SerializedName("ID_Formato")
	public String idFormato;
	
	@SerializedName("Nombre_Original")
	public String nombreOriginal;
	
	@SerializedName("Extension")
	public String extension;
	
	@SerializedName("Nombre_Video")
	public String nombreVideo;
	
	
	

	
}
