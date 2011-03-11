package com.blablahlabs.excelsior.beans;

import java.util.List;

import com.blablahlabs.excelsior.beans.notas.FotoGaleria;
import com.blablahlabs.excelsior.beans.notas.VideosPagina;
import com.google.gson.annotations.SerializedName;

public class ExcelsiorGson {

	@SerializedName("Principal_Portada")
	public PrincipalPortada principalPortada;
	
	@SerializedName("Modulo_A")
	public ModuloA moduloA;
	
	@SerializedName("Modulo_B")
	public ModuloB moduloB;
	
	@SerializedName("Modulo_C")
	public ModuloC moduloC;
	
	@SerializedName("Ultima_Hora")
	public UltimaHora ultimaHora;
	
	@SerializedName("Stage")
	public Stage stage;
	
	@SerializedName("Seccion_Nacional")
	public SeccionNacional seccionNacional;
	
	@SerializedName("Seccion_Global")
	public SeccionGlobal seccionGlobal;
	
	@SerializedName("Seccion_Dinero")
	public SeccionDinero seccionDinero;
	
	@SerializedName("Seccion_Comunidad")
	public SeccionComunidad seccionComunidad;
	
	@SerializedName("Seccion_Adrenalina")
	public SeccionAdrenalina seccionAdrenalina;
	
	@SerializedName("Seccion_Funcion")
	public SeccionFuncion seccionFuncion;
	
	@SerializedName("Opinion")
	public Opinion opinion;
	
	@SerializedName("FotoGalerias")
	public List<FotoGaleria> fotoGaleria;

	 @SerializedName("Videos_Pagina1")
	 public List<VideosPagina> videosPagina1;
	 
	@SerializedName("Videos_Pagina2")
	 public List<VideosPagina> videosPagina2;
	 
	@SerializedName("Videos_Pagina3")
	 public List<VideosPagina> videosPagina3;
	 
	@SerializedName("Impreso")
	public Impreso Impreso;
	
		
}
