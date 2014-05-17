package es.upm.eui.tfc.service;

import java.io.Serializable;
import java.util.List;

import es.upm.eui.tfc.model.Sesion;
import es.upm.eui.tfc.service.error.SesionesServiceException;

public interface SesionesService extends Serializable {

	public static final String SERVICE_NAME = "SesionesService";
	
	/**
	 * Operacion para registrar una nueva sesion.
	 * 
	 * @param sesion
	 * @throws SesionesServiceException
	 */
	public Sesion registrarSesion(Sesion sesion) throws SesionesServiceException;
	
	public void borrarSesion(int idSesion) throws SesionesServiceException;
	
	public Sesion recuperarSesion(int idSesion) throws SesionesServiceException;
	
	public void actualizarSesion(Sesion sesion) throws SesionesServiceException;
	
	public List<Sesion> recuperarSesiones(int idFicha) throws SesionesServiceException;
	
}