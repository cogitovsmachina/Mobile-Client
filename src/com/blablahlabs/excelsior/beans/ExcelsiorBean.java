package com.blablahlabs.excelsior.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.blablahlabs.excelsior.beans.notas.FotoGaleria;
import com.blablahlabs.excelsior.beans.notas.Nota;
import com.blablahlabs.excelsior.beans.notas.NotaImpresa;
import com.blablahlabs.excelsior.beans.notas.NotaModulo;
import com.blablahlabs.excelsior.beans.notas.NotaOpinion;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.beans.notas.NotaStage;
import com.blablahlabs.excelsior.beans.notas.NotaUltimaHora;
import com.blablahlabs.excelsior.beans.notas.VideosPagina;

public class ExcelsiorBean  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExcelsiorGson excelsiorGson;

	private List<Nota> principalPortada = new ArrayList<Nota>();

	private List<NotaModulo> moduloA = new ArrayList<NotaModulo>();

	private List<NotaModulo> moduloB = new ArrayList<NotaModulo>();

	private List<NotaModulo> moduloC = new ArrayList<NotaModulo>();

	private ArrayList<NotaUltimaHora> ultimaHora = new ArrayList<NotaUltimaHora>();	

	private List<NotaStage> stage = new ArrayList<NotaStage>();

	private List<NotaSeccion> seccionNacional  = new ArrayList<NotaSeccion>();

	private List<NotaSeccion> seccionGlobal  = new ArrayList<NotaSeccion>();

	private List<NotaSeccion> seccionDinero  = new ArrayList<NotaSeccion>();

	private List<NotaSeccion> seccionComunidad  = new ArrayList<NotaSeccion>();

	private List<NotaSeccion> seccionAdrenalina  = new ArrayList<NotaSeccion>();

	private List<NotaSeccion> seccionFuncion  = new ArrayList<NotaSeccion>();

	private List<NotaOpinion> opinion  = new ArrayList<NotaOpinion>();


	private List<FotoGaleria> fotoGaleria  = new ArrayList<FotoGaleria>();//.fotoGaleria;
	private List<VideosPagina> videosPagina = new ArrayList<VideosPagina>();


	

	private List<NotaImpresa> impreso   = new ArrayList<NotaImpresa>();


	
	
	public ExcelsiorBean(ExcelsiorGson excelsiorGson){
		this.excelsiorGson = excelsiorGson;
		
		init();
		
	}
	
	private void init(){
		

		principalPortada.add(excelsiorGson.principalPortada.n1);
		
		moduloA.add(excelsiorGson.moduloA.n1);
		moduloA.add(excelsiorGson.moduloA.n2);
		moduloA.add(excelsiorGson.moduloA.n3);
		moduloA.add(excelsiorGson.moduloA.n4);
		moduloA.add(excelsiorGson.moduloA.n5);
		moduloA.add(excelsiorGson.moduloA.n6);
		moduloA.add(excelsiorGson.moduloA.n7);
		
		moduloB.add(excelsiorGson.moduloA.n1);
		moduloB.add(excelsiorGson.moduloA.n2);
		moduloB.add(excelsiorGson.moduloA.n3);
		moduloB.add(excelsiorGson.moduloA.n4);
		moduloB.add(excelsiorGson.moduloA.n5);
		moduloB.add(excelsiorGson.moduloA.n6);
		moduloB.add(excelsiorGson.moduloA.n7);
		
		moduloC.add(excelsiorGson.moduloA.n1);
		moduloC.add(excelsiorGson.moduloA.n2);
		moduloC.add(excelsiorGson.moduloA.n3);
		moduloC.add(excelsiorGson.moduloA.n4);
		moduloC.add(excelsiorGson.moduloA.n5);
		moduloC.add(excelsiorGson.moduloA.n6);
		
		ultimaHora.add(excelsiorGson.ultimaHora.n1);
		ultimaHora.add(excelsiorGson.ultimaHora.n2);
		ultimaHora.add(excelsiorGson.ultimaHora.n3);
		ultimaHora.add(excelsiorGson.ultimaHora.n4);
		ultimaHora.add(excelsiorGson.ultimaHora.n5);
		ultimaHora.add(excelsiorGson.ultimaHora.n6);
		ultimaHora.add(excelsiorGson.ultimaHora.n7);
		ultimaHora.add(excelsiorGson.ultimaHora.n8);
		ultimaHora.add(excelsiorGson.ultimaHora.n9);
		ultimaHora.add(excelsiorGson.ultimaHora.n10);
		ultimaHora.add(excelsiorGson.ultimaHora.n11);
		ultimaHora.add(excelsiorGson.ultimaHora.n12);
		ultimaHora.add(excelsiorGson.ultimaHora.n13);
		ultimaHora.add(excelsiorGson.ultimaHora.n14);
		ultimaHora.add(excelsiorGson.ultimaHora.n15);
		
		stage.add(excelsiorGson.stage.n1);
		stage.add(excelsiorGson.stage.n2);
		stage.add(excelsiorGson.stage.n3);
		stage.add(excelsiorGson.stage.n3);
		
//		seccionNacional.add(excelsiorGson.seccionNacional.nP);
		seccionNacional.add(excelsiorGson.seccionNacional.n1);
		seccionNacional.add(excelsiorGson.seccionNacional.n2);
		seccionNacional.add(excelsiorGson.seccionNacional.n3);
		seccionNacional.add(excelsiorGson.seccionNacional.n4);
		seccionNacional.add(excelsiorGson.seccionNacional.n5);
		seccionNacional.add(excelsiorGson.seccionNacional.n6);
		seccionNacional.add(excelsiorGson.seccionNacional.n7);
		seccionNacional.add(excelsiorGson.seccionNacional.n8);
		seccionNacional.add(excelsiorGson.seccionNacional.n9);
		seccionNacional.add(excelsiorGson.seccionNacional.n10);
		seccionNacional.add(excelsiorGson.seccionNacional.n11);
		seccionNacional.add(excelsiorGson.seccionNacional.n12);
		seccionNacional.add(excelsiorGson.seccionNacional.n13);
		seccionNacional.add(excelsiorGson.seccionNacional.n14);
		seccionNacional.add(excelsiorGson.seccionNacional.n15);

//		seccionGlobal.add(excelsiorGson.seccionGlobal.nP);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n1);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n2);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n3);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n4);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n5);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n6);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n7);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n8);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n9);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n10);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n11);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n12);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n13);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n14);
		seccionGlobal.add(excelsiorGson.seccionGlobal.n15);
		
//		seccionDinero.add(excelsiorGson.seccionDinero.nP);
		seccionDinero.add(excelsiorGson.seccionDinero.n1);
		seccionDinero.add(excelsiorGson.seccionDinero.n2);
		seccionDinero.add(excelsiorGson.seccionDinero.n3);
		seccionDinero.add(excelsiorGson.seccionDinero.n4);
		seccionDinero.add(excelsiorGson.seccionDinero.n5);
		seccionDinero.add(excelsiorGson.seccionDinero.n6);
		seccionDinero.add(excelsiorGson.seccionDinero.n7);
		seccionDinero.add(excelsiorGson.seccionDinero.n8);
		seccionDinero.add(excelsiorGson.seccionDinero.n9);
		seccionDinero.add(excelsiorGson.seccionDinero.n10);
		seccionDinero.add(excelsiorGson.seccionDinero.n11);
		seccionDinero.add(excelsiorGson.seccionDinero.n12);
		seccionDinero.add(excelsiorGson.seccionDinero.n13);
		seccionDinero.add(excelsiorGson.seccionDinero.n14);
		seccionDinero.add(excelsiorGson.seccionDinero.n15);
		
//		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.nP);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n1);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n2);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n3);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n4);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n5);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n6);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n7);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n8);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n9);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n10);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n11);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n12);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n13);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n14);
		seccionAdrenalina.add(excelsiorGson.seccionAdrenalina.n15);
		
//		seccionComunidad.add(excelsiorGson.seccionComunidad.nP);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n1);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n2);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n3);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n4);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n5);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n6);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n7);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n8);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n9);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n10);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n11);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n12);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n13);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n14);
		seccionComunidad.add(excelsiorGson.seccionComunidad.n15);
		
//		seccionFuncion.add(excelsiorGson.seccionFuncion.nP);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n1);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n2);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n3);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n4);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n5);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n6);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n7);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n8);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n9);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n10);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n11);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n12);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n13);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n14);
		seccionFuncion.add(excelsiorGson.seccionFuncion.n15);
		
		//Opiniones
		opinion.add(excelsiorGson.opinion.nacional.n1);
		opinion.add(excelsiorGson.opinion.nacional.n2);
		opinion.add(excelsiorGson.opinion.nacional.n3);
		
		opinion.add(excelsiorGson.opinion.global.n1);
		opinion.add(excelsiorGson.opinion.global.n2);
		opinion.add(excelsiorGson.opinion.global.n3);
		
		opinion.add(excelsiorGson.opinion.dinero.n1);
		opinion.add(excelsiorGson.opinion.dinero.n2);
		opinion.add(excelsiorGson.opinion.dinero.n3);
		
		opinion.add(excelsiorGson.opinion.adrenalina.n1);
		opinion.add(excelsiorGson.opinion.adrenalina.n2);
		opinion.add(excelsiorGson.opinion.adrenalina.n3);
		
		opinion.add(excelsiorGson.opinion.comunidad.n1);
		opinion.add(excelsiorGson.opinion.comunidad.n2);
		opinion.add(excelsiorGson.opinion.comunidad.n3);
		
		opinion.add(excelsiorGson.opinion.funcion.n1);
		opinion.add(excelsiorGson.opinion.funcion.n2);
		opinion.add(excelsiorGson.opinion.funcion.n3);
		

		//Fotogalerias y Videos
		fotoGaleria  = new ArrayList<FotoGaleria>(excelsiorGson.fotoGaleria);
		
		videosPagina.addAll(excelsiorGson.videosPagina1);
		videosPagina.addAll(excelsiorGson.videosPagina2);
		videosPagina.addAll(excelsiorGson.videosPagina3);
		
		/*
		videosPagina.add((VideosPagina) excelsiorGson.videosPagina2);
		videosPagina3 = new ArrayList<VideosPagina>(excelsiorGson.videosPagina3);
		*/
		
		Collections.copy(fotoGaleria, excelsiorGson.fotoGaleria);
		/*Collections.copy(videosPagina1, excelsiorGson.videosPagina1);
		Collections.copy(videosPagina2, excelsiorGson.videosPagina2);
		Collections.copy(videosPagina3, excelsiorGson.videosPagina3);
		
		*/
		
		
		
		
		
		
		//Versiones Impresas
		impreso.add(excelsiorGson.Impreso.nacional);
		impreso.add(excelsiorGson.Impreso.global);
		impreso.add(excelsiorGson.Impreso.dinero);
		impreso.add(excelsiorGson.Impreso.adrenalina);
		impreso.add(excelsiorGson.Impreso.funcion);
			
	}
	
	
	public List<Nota> getPrincipalPortada() {
		return principalPortada;
	}

	public void setPrincipalPortada(List<Nota> principalPortada) {
		this.principalPortada = principalPortada;
	}

	public List<NotaModulo> getModuloA() {
		return moduloA;
	}

	public void setModuloA(List<NotaModulo> moduloA) {
		this.moduloA = moduloA;
	}

	public List<NotaModulo> getModuloB() {
		return moduloB;
	}

	public void setModuloB(List<NotaModulo> moduloB) {
		this.moduloB = moduloB;
	}

	public List<NotaModulo> getModuloC() {
		return moduloC;
	}

	public void setModuloC(List<NotaModulo> moduloC) {
		this.moduloC = moduloC;
	}

	public ArrayList<NotaUltimaHora> getUltimaHora() {
		return ultimaHora;
	}

	public void setUltimaHora(ArrayList<NotaUltimaHora> ultimaHora) {
		this.ultimaHora = ultimaHora;
	}

	public List<NotaStage> getStage() {
		return stage;
	}

	public void setStage(List<NotaStage> stage) {
		this.stage = stage;
	}

	public List<NotaSeccion> getSeccionNacional() {
		return seccionNacional;
	}

	public void setSeccionNacional(List<NotaSeccion> seccionNacional) {
		this.seccionNacional = seccionNacional;
	}

	public List<NotaSeccion> getSeccionGlobal() {
		return seccionGlobal;
	}

	public void setSeccionGlobal(List<NotaSeccion> seccionGlobal) {
		this.seccionGlobal = seccionGlobal;
	}

	public List<NotaSeccion> getSeccionDinero() {
		return seccionDinero;
	}

	public void setSeccionDinero(List<NotaSeccion> seccionDinero) {
		this.seccionDinero = seccionDinero;
	}

	public List<NotaSeccion> getSeccionComunidad() {
		return seccionComunidad;
	}

	public void setSeccionComunidad(List<NotaSeccion> seccionComunidad) {
		this.seccionComunidad = seccionComunidad;
	}

	public List<NotaSeccion> getSeccionAdrenalina() {
		return seccionAdrenalina;
	}

	public void setSeccionAdrenalina(List<NotaSeccion> seccionAdrenalina) {
		this.seccionAdrenalina = seccionAdrenalina;
	}

	public List<NotaSeccion> getSeccionFuncion() {
		return seccionFuncion;
	}

	public void setSeccionFuncion(List<NotaSeccion> seccionFuncion) {
		this.seccionFuncion = seccionFuncion;
	}

	public List<NotaOpinion> getOpinion() {
		return opinion;
	}

	public void setOpinion(List<NotaOpinion> opinion) {
		this.opinion = opinion;
	}

	

	public List<NotaImpresa> getImpreso() {
		return impreso;
	}

	public void setImpreso(List<NotaImpresa> impreso) {
		this.impreso = impreso;
	}
	
	public List<VideosPagina> getVideosPagina() {
		return videosPagina;
	}

	public void setVideosPagina(List<VideosPagina> videosPagina) {
		this.videosPagina = videosPagina;
	}
	
		
}
