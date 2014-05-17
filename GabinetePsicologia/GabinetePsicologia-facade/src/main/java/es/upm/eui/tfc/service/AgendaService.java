package es.upm.eui.tfc.service;

import java.util.List;
import java.io.Serializable;

import es.upm.eui.tfc.model.Cita;
import es.upm.eui.tfc.model.Evento;
import es.upm.eui.tfc.model.EntradaAgenda;
import es.upm.eui.tfc.model.factory.AgendaFactory.TipoEntradaAgenda;
import es.upm.eui.tfc.service.error.AgendaServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaCitas;
import es.upm.eui.tfc.service.filter.FiltroBusquedaEventos;

public interface AgendaService extends Serializable {

	public static final String SERVICE_NAME = "AgendaService";
	
	/**
	 * Operacion para registrar una nueva entrada a la Agenda.
	 * 
	 * @param entradaAgenda
	 * @throws AgendaServiceException
	 */
	public <T extends EntradaAgenda> T registrarEntradaAgenda(T entradaAgenda) throws AgendaServiceException;
	
	public void borrarEntradaAgenda(int id, TipoEntradaAgenda tipo) throws AgendaServiceException;
	
	public void borrarEntradaAgenda(EntradaAgenda entradaAgenda) throws AgendaServiceException;
	
	public List<Cita> buscarCitas(FiltroBusquedaCitas filtro) throws AgendaServiceException;
	
	public List<Evento> buscarEventos(FiltroBusquedaEventos filtro) throws AgendaServiceException;
	
	public <T extends EntradaAgenda> T recuperarEntradaAgenda(int idEntradaAgenda, Class<T> clase) throws AgendaServiceException;	
	
}