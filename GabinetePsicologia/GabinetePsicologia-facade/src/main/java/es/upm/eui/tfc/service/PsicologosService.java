package es.upm.eui.tfc.service;

import java.io.Serializable;
import java.util.List;

import es.upm.eui.tfc.model.Psicologo;
import es.upm.eui.tfc.service.error.PsicologosServiceException;

public interface PsicologosService extends Serializable {

	public static final String SERVICE_NAME = "PsicologosService";
	
	
	public Psicologo registrarPsicologo(Psicologo psicologo) throws PsicologosServiceException;
	
	public void borrarPsicologo(Integer dni) throws PsicologosServiceException;
	
	public Psicologo recuperarPsicologo(Integer dni) throws PsicologosServiceException;
	
	public void actualizarPsicologo(Psicologo psicologo) throws PsicologosServiceException;
	
	public List<Psicologo> recuperarTodosLosPsicologos() throws PsicologosServiceException;
}