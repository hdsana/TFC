package es.upm.eui.tfc.service.filter;

import java.util.Date;

public class FiltroBusquedaCitas {

	private Integer idPsicologo;
	private String nifCliente;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	public Integer getIdPsicologo() {
		return idPsicologo;
	}
	public void setIdPsicologo(Integer idPsicologo) {
		this.idPsicologo = idPsicologo;
	}
	public String getNifCliente() {
		return nifCliente;
	}
	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
