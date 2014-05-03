package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import es.upm.eui.tfc.model.Sesion;

import java.sql.Timestamp;


/**
 * The persistent class for the sesiones database table.
 * 
 */
@Entity
@Table(name="sesiones")
@NamedQuery(name="Sesiones.findAll", query="SELECT s FROM SesionImpl s")
public class SesionImpl implements Serializable, Sesion {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_sesion")
	private int idSesion;

	@Column(name="areas_evaluar")
	private Serializable areasEvaluar;

	@Column(name="fecha_act_sesion")
	private Timestamp fechaActSesion;

	@Column(name="fecha_sesion")
	private Timestamp fechaSesion;

	private Serializable resumen;

	@Column(name="siguiente_sesion")
	private Serializable siguienteSesion;

	@Column(name="tecnicas_resultados")
	private Serializable tecnicasResultados;

	@Column(name="id_ficha")
	private int idFicha;

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getIdFicha()
	 */
	@Override
	public int getIdFicha() {
		return idFicha;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setIdFicha(int)
	 */
	@Override
	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getIdSesion()
	 */
	@Override
	public int getIdSesion() {
		return this.idSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setIdSesion(int)
	 */
	@Override
	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getAreasEvaluar()
	 */
	@Override
	public Serializable getAreasEvaluar() {
		return this.areasEvaluar;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setAreasEvaluar(java.io.Serializable)
	 */
	@Override
	public void setAreasEvaluar(Serializable areasEvaluar) {
		this.areasEvaluar = areasEvaluar;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getFechaActSesion()
	 */
	@Override
	public Timestamp getFechaActSesion() {
		return this.fechaActSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setFechaActSesion(java.sql.Timestamp)
	 */
	@Override
	public void setFechaActSesion(Timestamp fechaActSesion) {
		this.fechaActSesion = fechaActSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getFechaSesion()
	 */
	@Override
	public Timestamp getFechaSesion() {
		return this.fechaSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setFechaSesion(java.sql.Timestamp)
	 */
	@Override
	public void setFechaSesion(Timestamp fechaSesion) {
		this.fechaSesion = fechaSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getResumen()
	 */
	@Override
	public Serializable getResumen() {
		return this.resumen;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setResumen(java.io.Serializable)
	 */
	@Override
	public void setResumen(Serializable resumen) {
		this.resumen = resumen;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getSiguienteSesion()
	 */
	@Override
	public Serializable getSiguienteSesion() {
		return this.siguienteSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setSiguienteSesion(java.io.Serializable)
	 */
	@Override
	public void setSiguienteSesion(Serializable siguienteSesion) {
		this.siguienteSesion = siguienteSesion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#getTecnicasResultados()
	 */
	@Override
	public Object getTecnicasResultados() {
		return this.tecnicasResultados;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Sesion#setTecnicasResultados(java.io.Serializable)
	 */
	@Override
	public void setTecnicasResultados(Serializable tecnicasResultados) {
		this.tecnicasResultados = tecnicasResultados;
	}

}