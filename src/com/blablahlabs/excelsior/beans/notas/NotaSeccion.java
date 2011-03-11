package com.blablahlabs.excelsior.beans.notas;

import com.google.gson.annotations.SerializedName;

public class NotaSeccion extends Nota{
		
	@SerializedName("ID_Foto_Portada")
	public int idFotoPortada;
	
	@SerializedName("Fecha_Publicacion")
	public String fechaPublicacion;

	@Override
	public String toString() {
		return "NotaModulo [idFotoPortada=" + idFotoPortada
				+ ", fechaPublicacion=" + fechaPublicacion + ", idNota="
				+ idNota + ", titulo=" + titulo + ", balazo=" + balazo + "]";
	}
	


	

	
}
