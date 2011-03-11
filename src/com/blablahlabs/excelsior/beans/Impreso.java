package com.blablahlabs.excelsior.beans;


import com.blablahlabs.excelsior.beans.notas.NotaImpresa;
import com.google.gson.annotations.SerializedName;

public class Impreso {
	
	@SerializedName("Nacional")
	public NotaImpresa nacional;
	
	@SerializedName("Adrenalina")
	public NotaImpresa adrenalina;
	
	@SerializedName("Global")
	public NotaImpresa global;
	
	@SerializedName("Dinero")
	public NotaImpresa dinero;
	

	
	@SerializedName("Funcion")
	public NotaImpresa funcion;
	
	

}
