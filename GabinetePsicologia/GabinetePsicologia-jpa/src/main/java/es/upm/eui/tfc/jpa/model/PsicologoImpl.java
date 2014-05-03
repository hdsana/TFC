package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.upm.eui.tfc.model.Psicologo;


/**
 * The persistent class for the psicologos database table.
 * 
 */
@Entity
@Table(name="psicologos")
@NamedQuery(name="PsicologoImpl.findAll", query="SELECT p FROM PsicologoImpl p")
public class PsicologoImpl implements Serializable, Psicologo {
	private static final long serialVersionUID = 1L;

	@Id
	private int dni;

	private String apellidos;

	private String nombre;



	public PsicologoImpl() {
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Psicologo#getDni()
	 */
	@Override
	public int getDni() {
		return this.dni;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Psicologo#setDni(int)
	 */
	@Override
	public void setDni(int dni) {
		this.dni = dni;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Psicologo#getApellidos()
	 */
	@Override
	public String getApellidos() {
		return this.apellidos;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Psicologo#setApellidos(java.lang.String)
	 */
	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Psicologo#getNombre()
	 */
	@Override
	public String getNombre() {
		return this.nombre;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Psicologo#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}