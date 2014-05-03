package es.upm.eui.tfc.model;

import java.io.Serializable;
import java.sql.Timestamp;

public interface Sesion {

	public abstract int getIdFicha();

	public abstract void setIdFicha(int idFicha);

	public abstract int getIdSesion();

	public abstract void setIdSesion(int idSesion);

	public abstract Serializable getAreasEvaluar();

	public abstract void setAreasEvaluar(Serializable areasEvaluar);

	public abstract Timestamp getFechaActSesion();

	public abstract void setFechaActSesion(Timestamp fechaActSesion);

	public abstract Timestamp getFechaSesion();

	public abstract void setFechaSesion(Timestamp fechaSesion);

	public abstract Serializable getResumen();

	public abstract void setResumen(Serializable resumen);

	public abstract Serializable getSiguienteSesion();

	public abstract void setSiguienteSesion(Serializable siguienteSesion);

	public abstract Object getTecnicasResultados();

	public abstract void setTecnicasResultados(Serializable tecnicasResultados);

}