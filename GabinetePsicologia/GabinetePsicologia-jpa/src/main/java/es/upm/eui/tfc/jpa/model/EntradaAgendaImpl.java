package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import es.upm.eui.tfc.model.EntradaAgenda;

/**
 * Entity implementation class for Entity: EntradaAgendaImpl
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class EntradaAgendaImpl implements Serializable, EntradaAgenda {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="id_psicologo")
	private int idPsicologo;
	
	@Column(name="fecha_inicio")
	private Timestamp fechaInicio;
	
	public EntradaAgendaImpl() {
		super();
	}
   

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.EntradaAgenda#getIdPsicologo()
	 */
	@Override
	public int getIdPsicologo() {
		return this.idPsicologo;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.EntradaAgenda#setIdPsicologo(int)
	 */
	@Override
	public void setIdPsicologo(int idPsicologo) {
		this.idPsicologo = idPsicologo;
	}
	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.EntradaAgenda#setIdEvento(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.EntradaAgenda#getIdEvento()
	 */
	@Override
	public int getId() {
		return this.id;
	}
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.EntradaAgenda#getFechaInicio()
	 */
	@Override
	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.EntradaAgenda#setFechaInicio(java.sql.Timestamp)
	 */
	@Override
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}
