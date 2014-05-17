package es.upm.eui.tfc.model;

import java.util.Date;

public interface EntradaAgenda {

	public abstract void setId(int id);

	public abstract int getId();
	
	public abstract int getIdPsicologo();

	public abstract void setIdPsicologo(int idPsicologo);

	public abstract Date getFechaInicio();

	public abstract void setFechaInicio(Date fechaInicio);

}