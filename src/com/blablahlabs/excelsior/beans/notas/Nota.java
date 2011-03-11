package com.blablahlabs.excelsior.beans.notas;

import com.google.gson.annotations.SerializedName;

public class Nota {
		
	@SerializedName("ID_Nota")
	public int idNota;
	
	@SerializedName("Titulo")
	public String titulo;
	
	@SerializedName("Balazo")
	public String balazo;

	@Override
	public String toString() {
		return "Nota [idNota=" + idNota + ", titulo=" + titulo + ", balazo="
				+ balazo + "]";
	}
	
	

	
}
