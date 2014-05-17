package es.upm.eui.tfc.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.eui.tfc.jpa.model.CitaImpl;
import es.upm.eui.tfc.jpa.model.EventoImpl;
import es.upm.eui.tfc.model.Cita;
import es.upm.eui.tfc.model.EntradaAgenda;
import es.upm.eui.tfc.model.Evento;
import es.upm.eui.tfc.model.factory.AgendaFactory;
import es.upm.eui.tfc.model.factory.AgendaFactory.TipoEntradaAgenda;
import es.upm.eui.tfc.service.AgendaService;
import es.upm.eui.tfc.service.error.AgendaServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaCitas;
import es.upm.eui.tfc.service.filter.FiltroBusquedaEventos;

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
	public <T extends EntradaAgenda> T registrarEntradaAgenda(T entradaAgenda) throws AgendaServiceException {
		try {
			if (entradaAgenda != null) {
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

	@Transactional
	public void borrarEntradaAgenda(EntradaAgenda entradaAgenda) throws AgendaServiceException {		
		try {
			if (entradaAgenda != null) {
				entradaAgenda = em.merge(entradaAgenda);
				em.remove(entradaAgenda);
			} else {
				throw new AgendaServiceException("La Entrada Agenda no puede ser nullO");
			}
		} catch (Exception e) {
			throw new AgendaServiceException(e);
		}
		
	}
	
	public List<Cita> buscarCitas(FiltroBusquedaCitas filtro) throws AgendaServiceException {
		List<Cita> listaCitas = new ArrayList<Cita>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM CITAS c");		
		sql.append("WHERE ");
		boolean and=false;
		if (filtro.filtrarPorCliente())
		{
			sql.append("c.id_cliente = :idCliente");
			and=true;
		}
		
		if (filtro.filtrarPorPsicologo())
		{
			if (and)
			{
				sql.append(" AND ");
			}
			sql.append("c.id_psicologo = :idPsicologo");
			and=true;
			
		}
		
		if (filtro.filtrarPorFecha())
		{
			Date fechaInicio=filtro.getFechaInicio();
			Date fechaFin=filtro.getFechaFin();
			if (fechaInicio!=null)
			{
				if (and)
				{
					sql.append(" AND ");
				}
				sql.append("c.fecha_inicio >= :fechaInicio");
				and=true;
			}
			
			if (fechaFin!=null)
			{
				if (and)
				{
					sql.append(" AND ");
				}
				sql.append("c.fecha_inicio <= :fechaFin");
			}							
			
		}
		
		TypedQuery<CitaImpl> query = em.createQuery(sql.toString(), CitaImpl.class);
		
		if (filtro.filtrarPorCliente()) {
			query.setParameter("idCliente", filtro.getNifCliente());
		}
		if (filtro.filtrarPorPsicologo()) {
			query.setParameter("idPsicologo", filtro.getIdPsicologo());
		}
		if (filtro.filtrarPorFecha())
		{
			query.setParameter("fechaInicio", filtro.getFechaInicio());
			query.setParameter("fechaFin", filtro.getFechaFin());
		}

		List<CitaImpl> citas = query.getResultList();
		for (Iterator i=citas.iterator(); i.hasNext();) {
			Cita cita = (Cita) i.next();
			listaCitas.add(cita);
		}

		return listaCitas;
	}
	
	public List<Evento> buscarEventos(FiltroBusquedaEventos filtro) throws AgendaServiceException {

		List<Evento> listaEventos = new ArrayList<Evento>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM EVENTOS c");		
		sql.append("WHERE ");
		boolean and=false;
		if (filtro.filtrarPorPsicologo())
		{
			sql.append("c.id_psicologo = :idPsicologo");
			and=true;
		}
		
		if (filtro.filtrarPorFecha())
		{
			Date fechaInicio=filtro.getFechaInicio();
			Date fechaFin=filtro.getFechaFin();
			if (fechaInicio!=null)
			{
				if (and)
				{
					sql.append(" AND ");
				}
				sql.append("c.fecha_inicio >= :fechaInicio");
				and=true;
			}
			
			if (fechaFin!=null)
			{
				if (and)
				{
					sql.append(" AND ");
				}
				sql.append("c.fecha_fin <= :fechaFin");
			}							
			
		}
		
		TypedQuery<EventoImpl> query = em.createQuery(sql.toString(), EventoImpl.class);
		
		if (filtro.filtrarPorPsicologo()) {
			query.setParameter("idPsicologo", filtro.getIdPsicologo());
		}
		if (filtro.filtrarPorFecha())
		{
			query.setParameter("fechaInicio", filtro.getFechaInicio());
			query.setParameter("fechaFin", filtro.getFechaFin());
		}

		List<EventoImpl> eventos = query.getResultList();
		for (Iterator i=eventos.iterator(); i.hasNext();) {
			Evento evento = (Evento) i.next();
			listaEventos.add(evento);
		}

		return listaEventos;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends EntradaAgenda> T recuperarEntradaAgenda(int idEntradaAgenda, Class<T> clase) throws AgendaServiceException {
		T entradaAgenda = null;
		try {	
			if (idEntradaAgenda >= 0) {
				if (clase.isInstance(new EventoImpl())) {
					entradaAgenda = (T) em.find(EventoImpl.class, idEntradaAgenda);
				} else {
					entradaAgenda = (T) em.find(CitaImpl.class, idEntradaAgenda);
				}
			} else {
				throw new AgendaServiceException("El id de evento no puede ser null ni vacio");
			}
		} catch (Exception e) {
			throw new AgendaServiceException(e);
		}
		return entradaAgenda;
		
	}

	
	
}
