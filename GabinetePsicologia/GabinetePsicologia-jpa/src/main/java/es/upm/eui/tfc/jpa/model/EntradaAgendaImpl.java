package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import es.upm.eui.tfc.model.EntradaAgenda;

/**
 * Entity implementation class for Entity: EntradaAgendaImpl
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class EntradaAgendaImpl implements Serializable, EntradaAgenda {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_psicologo")
	private int idPsicologo;
	
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	public EntradaAgendaImpl() {
		super();
	}
   
}
