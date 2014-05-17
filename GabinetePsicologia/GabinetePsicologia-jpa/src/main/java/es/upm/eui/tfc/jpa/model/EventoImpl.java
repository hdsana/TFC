package es.upm.eui.tfc.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import es.upm.eui.tfc.model.Evento;


/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name="eventos")
@NamedQuery(name="EventoImpl.findAll", query="SELECT e FROM EventoImpl e")
@EqualsAndHashCode(callSuper=true)
@ToString
public class EventoImpl extends EntradaAgendaImpl implements Evento {

	private static final long serialVersionUID = -6243911870049962750L;

	private String descripcion;

	@Column(name="fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	public EventoImpl() {
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Evento#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return this.descripcion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Evento#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Evento#getFechaFin()
	 */
	@Override
	public Date getFechaFin() {
		return this.fechaFin;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Evento#setFechaFin(java.sql.Timestamp)
	 */
	@Override
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



}