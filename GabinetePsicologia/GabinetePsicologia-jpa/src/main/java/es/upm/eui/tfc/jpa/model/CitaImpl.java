package es.upm.eui.tfc.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import es.upm.eui.tfc.model.Cita;


/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@Table(name="citas")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM CitaImpl c")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@Getter
@Setter
public class CitaImpl extends EntradaAgendaImpl implements Cita {

	private static final long serialVersionUID = -8555206378512437287L;
	
	
	//bi-directional many-to-one association to ClienteImpl
	@Column(name="id_cliente")
	private String idCliente;


}