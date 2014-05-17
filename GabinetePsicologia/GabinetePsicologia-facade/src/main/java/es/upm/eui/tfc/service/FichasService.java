package es.upm.eui.tfc.service;

import java.io.Serializable;

import es.upm.eui.tfc.model.Ficha;
import es.upm.eui.tfc.model.Sesion;
import es.upm.eui.tfc.service.error.FichasServiceException;
import es.upm.eui.tfc.service.error.SesionesServiceException;

public interface FichasService extends Serializable {

	public static final String SERVICE_NAME = "FichasService";
	
	/**
	 * Operacion para registrar una nueva ficha.
	 * 
	 * @param ficha
	 * @throws FichasServiceException
	 */
	public Ficha registrarFicha(Ficha ficha) throws FichasServiceException;
	
	public void borrarFicha(int idFicha) throws FichasServiceException;
	
	public Ficha recuperarFicha(int idFicha) throws FichasServiceException;	
	
	public void actualizarFicha(Ficha ficha) throws FichasServiceException;
	
}