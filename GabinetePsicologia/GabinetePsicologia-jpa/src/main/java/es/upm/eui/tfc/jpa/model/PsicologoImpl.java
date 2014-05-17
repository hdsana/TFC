package es.upm.eui.tfc.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import es.upm.eui.tfc.model.Psicologo;


/**
 * The persistent class for the psicologos database table.
 * 
 */
@Entity
@Table(name="psicologos")
@NamedQuery(name="PsicologoImpl.findAll", query="SELECT p FROM PsicologoImpl p")
@Data
public class PsicologoImpl implements Serializable, Psicologo {

	
	private static final long serialVersionUID = 8247776458870401762L;

	@Id
	@Column(name="id_psicologo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPsicologo;

	private String nif;
	
	private String apellidos;

	private String nombre;


}