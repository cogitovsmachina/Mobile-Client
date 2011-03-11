package com.blablahlabs.excelsior.beans;

import com.blablahlabs.excelsior.beans.notas.NotaStage;
import com.google.gson.annotations.SerializedName;

public class Stage {


	public int type;
	
	@SerializedName("stage-1de4")
	public NotaStage n1;
	
	@SerializedName("stage-2de4")
	public NotaStage n2;
	
	@SerializedName("stage-3de4")
	public NotaStage n3;
	
	@SerializedName("stage-4de4")
	public NotaStage n4;
	
}
