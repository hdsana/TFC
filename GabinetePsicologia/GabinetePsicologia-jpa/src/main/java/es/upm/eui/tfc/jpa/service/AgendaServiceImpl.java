package es.upm.eui.tfc.jpa.service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.eui.tfc.jpa.model.EntradaAgendaImpl;
import es.upm.eui.tfc.model.Cita;
import es.upm.eui.tfc.model.EntradaAgenda;
import es.upm.eui.tfc.model.Evento;
import es.upm.eui.tfc.model.factory.AgendaFactory;
import es.upm.eui.tfc.model.factory.AgendaFactory.TipoEntradaAgenda;
import es.upm.eui.tfc.service.AgendaService;
import es.upm.eui.tfc.service.error.AgendaServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaCitas;

@Service(AgendaService.SERVICE_NAME)
public class AgendaServiceImpl implements AgendaService {

	private static final long serialVersionUID = -9L;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private AgendaFactory agendaFactory;
	
	/**
	 * Implementacion JPA para registrar una nueva entrada de agenda.
	 * 
	 * @param entradaAgenda
	 * @throws AgendaServiceException si hay algun error en el acceso a base de datos o el parametro de entrada no es valido.
	 */
	@Transactional
	public EntradaAgenda registrarEntradaAgenda(EntradaAgenda entradaAgenda) throws AgendaServiceException {
		try {
			if (entradaAgenda != null && !em.contains(entradaAgenda)) {
				em.persist(entradaAgenda);
			} else {
				throw new AgendaServiceException("La entrada Agenda no puede ser null o ya existe");
			}
		} catch (Exception e) {
			throw new AgendaServiceException(e);
		}
		return entradaAgenda;
	}

	@Transactional
	public void borrarEntradaAgenda(int id, TipoEntradaAgenda tipo) throws AgendaServiceException {		
		try {
			EntradaAgenda entradaAgenda = this.agendaFactory.createEntradaAgenda(tipo);
			entradaAgenda.setId(id);
			entradaAgenda = em.merge(entradaAgenda);
			em.remove(entradaAgenda);
		} catch (Exception e) {
			throw new AgendaServiceException(e);
		}
		
	}

	public List<Cita> buscarCitas(FiltroBusquedaCitas filtro) throws AgendaServiceException {
		List<Cita> citas = new ArrayList<Cita>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM CITAS c");
		sql.append("WHERE ");
		
		return null;
	}
	
	/*
	public List<Evento> buscarEvento(FiltroBusquedaEventos filtro) throws AgendaServiceException {
		List<Cita> citas = new ArrayList<Cita>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM CITAS c");
		sql.append("WHERE ");
		
		return null;
	}
	*/
	
	@Transactional
	public EntradaAgenda recuperarEntradaAgenda(int idEvento) throws AgendaServiceException {
		EntradaAgenda entradaAgenda = null;
		try {	
			if (idEvento >= 0) {
				entradaAgenda = em.find(EntradaAgendaImpl.class, idEvento);
			} else {
				throw new AgendaServiceException("El id de evento no puede ser null ni vacio");
			}
		} catch (Exception e) {
			throw new AgendaServiceException(e);
		}
		return entradaAgenda;
		
	}
	
}
