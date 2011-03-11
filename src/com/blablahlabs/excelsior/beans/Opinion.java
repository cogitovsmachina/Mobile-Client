package com.blablahlabs.excelsior.beans;

import com.google.gson.annotations.SerializedName;

public class Opinion {
	
	@SerializedName("Nacional")
	public OpNacional nacional;
	
	@SerializedName("Global")
	public OpGlobal global;
	
	@SerializedName("Dinero")
	public OpDinero dinero;
	
	@SerializedName("Comunidad")
	public OpComunidad comunidad;
	
	@SerializedName("Adrenalina")
	public OpAdrenalina adrenalina;
	
	@SerializedName("Funcion")
	public OpFuncion funcion;
	
	

}
