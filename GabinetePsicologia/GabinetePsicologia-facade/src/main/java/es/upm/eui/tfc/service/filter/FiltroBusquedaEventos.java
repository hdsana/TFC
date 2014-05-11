package es.upm.eui.tfc.service.filter;

import java.util.Date;

public class FiltroBusquedaEventos {

	private Integer idPsicologo;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	public Integer getIdPsicologo() {
		return idPsicologo;
	}
	public void setIdPsicologo(Integer idPsicologo) {
		this.idPsicologo = idPsicologo;
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
	
	public boolean filtrarPorPsicologo() {
		return this.idPsicologo != null;
	}	
	
	public boolean filtrarPorFecha() {
		return (this.fechaInicio != null || this.fechaFin != null);
	}
		
	
}
