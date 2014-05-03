package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.upm.eui.tfc.model.Ficha;


/**
 * The persistent class for the fichas database table.
 * 
 */
@Entity
@Table(name="fichas")
@NamedQuery(name="FichaImpl.findAll", query="SELECT f FROM FichaImpl f")
public class FichaImpl implements Serializable, Ficha {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ficha")
	private int idFicha;

	@Column(name="analisis_funcional")
	private Serializable analisisFuncional;

	private boolean cerrada;

	private Serializable demanda;

	private Serializable diagnostico;

	private Serializable evaluacion;

	@Column(name="evaluacion_final")
	private Serializable evaluacionFinal;

	@Column(name="fecha_act_analisis_funcional")
	private Timestamp fechaActAnalisisFuncional;

	@Column(name="fecha_act_demanda")
	private Timestamp fechaActDemanda;

	@Column(name="fecha_act_diagnostico")
	private Timestamp fechaActDiagnostico;

	@Column(name="fecha_act_evaluacion")
	private Timestamp fechaActEvaluacion;

	@Column(name="fecha_act_evaluacion_final")
	private Timestamp fechaActEvaluacionFinal;

	@Column(name="fecha_act_observaciones")
	private Timestamp fechaActObservaciones;

	@Column(name="fecha_act_tratamiento")
	private Timestamp fechaActTratamiento;

	@Column(name="fecha_alta")
	private Timestamp fechaAlta;

	private Serializable observaciones;

	private Serializable tratamiento;

	@Column(name="id_cliente")
	private String nifCliente;

	@Column(name="id_psicologo")
	private int idPsicologo;

	public FichaImpl() {
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getIdFicha()
	 */
	@Override
	public int getIdFicha() {
		return this.idFicha;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setIdFicha(int)
	 */
	@Override
	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getAnalisisFuncional()
	 */
	@Override
	public Serializable getAnalisisFuncional() {
		return this.analisisFuncional;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setAnalisisFuncional(java.io.Serializable)
	 */
	@Override
	public void setAnalisisFuncional(Serializable analisisFuncional) {
		this.analisisFuncional = analisisFuncional;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#isCerrada()
	 */
	@Override
	public boolean isCerrada() {
		return this.cerrada;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setCerrada(boolean)
	 */
	@Override
	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getDemanda()
	 */
	@Override
	public Object getDemanda() {
		return this.demanda;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setDemanda(java.io.Serializable)
	 */
	@Override
	public void setDemanda(Serializable demanda) {
		this.demanda = demanda;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getDiagnostico()
	 */
	@Override
	public Serializable getDiagnostico() {
		return this.diagnostico;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setDiagnostico(java.io.Serializable)
	 */
	@Override
	public void setDiagnostico(Serializable diagnostico) {
		this.diagnostico = diagnostico;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getEvaluacion()
	 */
	@Override
	public Serializable getEvaluacion() {
		return this.evaluacion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setEvaluacion(java.io.Serializable)
	 */
	@Override
	public void setEvaluacion(Serializable evaluacion) {
		this.evaluacion = evaluacion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getEvaluacionFinal()
	 */
	@Override
	public Serializable getEvaluacionFinal() {
		return this.evaluacionFinal;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setEvaluacionFinal(java.io.Serializable)
	 */
	@Override
	public void setEvaluacionFinal(Serializable evaluacionFinal) {
		this.evaluacionFinal = evaluacionFinal;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActAnalisisFuncional()
	 */
	@Override
	public Timestamp getFechaActAnalisisFuncional() {
		return this.fechaActAnalisisFuncional;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActAnalisisFuncional(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActAnalisisFuncional(Timestamp fechaActAnalisisFuncional) {
		this.fechaActAnalisisFuncional = fechaActAnalisisFuncional;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActDemanda()
	 */
	@Override
	public Timestamp getFechaActDemanda() {
		return this.fechaActDemanda;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActDemanda(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActDemanda(Timestamp fechaActDemanda) {
		this.fechaActDemanda = fechaActDemanda;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActDiagnostico()
	 */
	@Override
	public Timestamp getFechaActDiagnostico() {
		return this.fechaActDiagnostico;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActDiagnostico(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActDiagnostico(Timestamp fechaActDiagnostico) {
		this.fechaActDiagnostico = fechaActDiagnostico;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActEvaluacion()
	 */
	@Override
	public Timestamp getFechaActEvaluacion() {
		return this.fechaActEvaluacion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActEvaluacion(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActEvaluacion(Timestamp fechaActEvaluacion) {
		this.fechaActEvaluacion = fechaActEvaluacion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActEvaluacionFinal()
	 */
	@Override
	public Timestamp getFechaActEvaluacionFinal() {
		return this.fechaActEvaluacionFinal;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActEvaluacionFinal(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActEvaluacionFinal(Timestamp fechaActEvaluacionFinal) {
		this.fechaActEvaluacionFinal = fechaActEvaluacionFinal;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActObservaciones()
	 */
	@Override
	public Timestamp getFechaActObservaciones() {
		return this.fechaActObservaciones;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActObservaciones(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActObservaciones(Timestamp fechaActObservaciones) {
		this.fechaActObservaciones = fechaActObservaciones;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaActTratamiento()
	 */
	@Override
	public Timestamp getFechaActTratamiento() {
		return this.fechaActTratamiento;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaActTratamiento(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActTratamiento(Timestamp fechaActTratamiento) {
		this.fechaActTratamiento = fechaActTratamiento;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getFechaAlta()
	 */
	@Override
	public Timestamp getFechaAlta() {
		return this.fechaAlta;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setFechaAlta(java.sql.Timestamp)
	 */
	@Override
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getObservaciones()
	 */
	@Override
	public Serializable getObservaciones() {
		return this.observaciones;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setObservaciones(java.io.Serializable)
	 */
	@Override
	public void setObservaciones(Serializable observaciones) {
		this.observaciones = observaciones;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getTratamiento()
	 */
	@Override
	public Serializable getTratamiento() {
		return this.tratamiento;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setTratamiento(java.io.Serializable)
	 */
	@Override
	public void setTratamiento(Serializable tratamiento) {
		this.tratamiento = tratamiento;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getNifCliente()
	 */
	@Override
	public String getNifCliente() {
		return this.nifCliente;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setNifCliente(java.lang.String)
	 */
	@Override
	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#getIdPsicologo()
	 */
	@Override
	public int getIdPsicologo() {
		return this.idPsicologo;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Ficha#setIdPsicologo(int)
	 */
	@Override
	public void setIdPsicologo(int idPsicologo) {
		this.idPsicologo = idPsicologo;
	}

}