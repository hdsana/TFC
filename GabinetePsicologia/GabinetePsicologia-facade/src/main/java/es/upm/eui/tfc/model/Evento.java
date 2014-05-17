package es.upm.eui.tfc.model;

import java.util.Date;

public interface Evento extends EntradaAgenda {

	public abstract String getDescripcion();

	public abstract void setDescripcion(String descripcion);

	public abstract Date getFechaFin();

	public abstract void setFechaFin(Date fechaFin);

}