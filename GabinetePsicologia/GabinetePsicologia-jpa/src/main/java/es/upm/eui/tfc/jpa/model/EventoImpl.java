package es.upm.eui.tfc.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
@ToString(callSuper=true)
@Getter
@Setter
public class EventoImpl extends EntradaAgendaImpl implements Evento {

	private static final long serialVersionUID = -6243911870049962750L;

	private String descripcion;

	@Column(name="fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;


}