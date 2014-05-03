package es.upm.eui.tfc.model;

import java.io.Serializable;
import java.sql.Timestamp;

public interface Ficha {

	public abstract int getIdFicha();

	public abstract void setIdFicha(int idFicha);

	public abstract Serializable getAnalisisFuncional();

	public abstract void setAnalisisFuncional(Serializable analisisFuncional);

	public abstract boolean isCerrada();

	public abstract void setCerrada(boolean cerrada);

	public abstract Object getDemanda();

	public abstract void setDemanda(Serializable demanda);

	public abstract Serializable getDiagnostico();

	public abstract void setDiagnostico(Serializable diagnostico);

	public abstract Serializable getEvaluacion();

	public abstract void setEvaluacion(Serializable evaluacion);

	public abstract Serializable getEvaluacionFinal();

	public abstract void setEvaluacionFinal(Serializable evaluacionFinal);

	public abstract Timestamp getFechaActAnalisisFuncional();

	public abstract void setFechaActAnalisisFuncional(
			Timestamp fechaActAnalisisFuncional);

	public abstract Timestamp getFechaActDemanda();

	public abstract void setFechaActDemanda(Timestamp fechaActDemanda);

	public abstract Timestamp getFechaActDiagnostico();

	public abstract void setFechaActDiagnostico(Timestamp fechaActDiagnostico);

	public abstract Timestamp getFechaActEvaluacion();

	public abstract void setFechaActEvaluacion(Timestamp fechaActEvaluacion);

	public abstract Timestamp getFechaActEvaluacionFinal();

	public abstract void setFechaActEvaluacionFinal(
			Timestamp fechaActEvaluacionFinal);

	public abstract Timestamp getFechaActObservaciones();

	public abstract void setFechaActObservaciones(
			Timestamp fechaActObservaciones);

	public abstract Timestamp getFechaActTratamiento();

	public abstract void setFechaActTratamiento(Timestamp fechaActTratamiento);

	public abstract Timestamp getFechaAlta();

	public abstract void setFechaAlta(Timestamp fechaAlta);

	public abstract Serializable getObservaciones();

	public abstract void setObservaciones(Serializable observaciones);

	public abstract Serializable getTratamiento();

	public abstract void setTratamiento(Serializable tratamiento);

	public abstract String getNifCliente();

	public abstract void setNifCliente(String nifCliente);

	public abstract int getIdPsicologo();

	public abstract void setIdPsicologo(int idPsicologo);

}