package es.upm.eui.tfc.model;

import java.sql.Timestamp;

public interface Evento extends EntradaAgenda {

	public abstract String getDescripcion();

	public abstract void setDescripcion(String descripcion);

	public abstract Timestamp getFechaFin();

	public abstract void setFechaFin(Timestamp fechaFin);

}