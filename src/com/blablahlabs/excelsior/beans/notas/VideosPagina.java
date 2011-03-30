package com.blablahlabs.excelsior.beans.notas;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class VideosPagina  implements Serializable{
	
	private static final long serialVersionUID = -747908058046812182L;

	@SerializedName("ID_Archivo")
	public int idArchivo;
	
	@SerializedName("ID_Seccion")
	public String idSeccion;
	
	@SerializedName("ID_Formato")
	public String idFormato;
	
	@SerializedName("Fecha")
	public String fecha;
	
	@SerializedName("Autor")
	public String autor;
	
	@SerializedName("Agencia")
	public String agencia;
	
	@SerializedName("Titulo")
	public String titulo;
	
	@SerializedName("Descripcion")
	public String descripcion;
	
	@SerializedName("Nombre_Original")
	public String nombreOriginal;
	
	@SerializedName("Estatus")
	public int estatus;
	
	@SerializedName("Extension")
	public String extension;

	@SerializedName("Nombre_Video")
	public String nombreVideo;
	
	@SerializedName("Paginas")
	public int paginas;
	
	@SerializedName("Pagina")
	public int pagina;
	
	@SerializedName("Total")
	public int total;
	
}
