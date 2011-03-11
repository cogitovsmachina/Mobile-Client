package com.blablahlabs.excelsior.beans.notas;

import com.google.gson.annotations.SerializedName;

public class NotaUltimaHora extends Nota{
	


	@SerializedName("Fecha_Publicacion")
	public String fechaPublicacion;

	@Override
	public String toString() {
		return "NotaUltimaHora [idNota=" + idNota + ", titulo=" + titulo + ", balazo="
				+ balazo + "fechaPublicacion=" + fechaPublicacion +  "]";
	}



	
	

}
