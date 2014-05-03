package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.upm.eui.tfc.model.Cliente;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="ClienteImpl.findAll", query="SELECT c FROM ClienteImpl c")
public class ClienteImpl implements Serializable, Cliente {
	private static final long serialVersionUID = 1L;

	@Id
	private String nif;

	private String apellidos;

	private String email;

	private String nombre;

	private String telefono;

	@Column(name="codigo_psicologo")
	private Integer codigoPsicologo;



	public ClienteImpl() {
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#getNif()
	 */
	@Override
	public String getNif() {
		return this.nif;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#setNif(java.lang.String)
	 */
	@Override
	public void setNif(String nif) {
		this.nif = nif;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#getApellidos()
	 */
	@Override
	public String getApellidos() {
		return this.apellidos;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#setApellidos(java.lang.String)
	 */
	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#getEmail()
	 */
	@Override
	public String getEmail() {
		return this.email;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#getNombre()
	 */
	@Override
	public String getNombre() {
		return this.nombre;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#getTelefono()
	 */
	@Override
	public String getTelefono() {
		return this.telefono;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#setTelefono(java.lang.String)
	 */
	@Override
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#getCodigoPsicologo()
	 */
	@Override
	public Integer getCodigoPsicologo() {
		return codigoPsicologo;
	}

	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.Cliente#setCodigoPsicologo(int)
	 */
	@Override
	public void setCodigoPsicologo(Integer codigoPsicologo) {
		this.codigoPsicologo = codigoPsicologo;
	}


}