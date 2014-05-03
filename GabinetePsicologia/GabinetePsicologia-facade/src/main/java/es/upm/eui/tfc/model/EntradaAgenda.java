package es.upm.eui.tfc.model;

import java.sql.Timestamp;

public interface EntradaAgenda {

	public abstract void setId(int id);

	public abstract int getId();
	
	public abstract int getIdPsicologo();

	public abstract void setIdPsicologo(int idPsicologo);

	public abstract Timestamp getFechaInicio();

	public abstract void setFechaInicio(Timestamp fechaInicio);

}