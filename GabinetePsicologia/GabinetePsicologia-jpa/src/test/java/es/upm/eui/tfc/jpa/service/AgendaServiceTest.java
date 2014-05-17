package es.upm.eui.tfc.jpa.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import es.upm.eui.tfc.model.Cita;
import es.upm.eui.tfc.model.Evento;
import es.upm.eui.tfc.model.factory.AgendaFactory;
import es.upm.eui.tfc.model.factory.AgendaFactory.TipoEntradaAgenda;
import es.upm.eui.tfc.service.AgendaService;
import es.upm.eui.tfc.service.error.AgendaServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class AgendaServiceTest {
	
	@Resource(name=AgendaService.SERVICE_NAME)
    public AgendaService agendaService;
	
	@Resource(name=AgendaFactory.FACTORY_NAME)
	public AgendaFactory agendaFactory;
	
	@Test
	public void testRegistrarEventoOK() throws AgendaServiceException {
		String descripcion="Quedar con Raulete Evento";
		int idPsicologo=50104101;
		int idEvento=1;
		TipoEntradaAgenda tipo=TipoEntradaAgenda.EVENTO;
		Evento evento = (Evento)this.agendaFactory.createEntradaAgenda(tipo);
		evento.setDescripcion(descripcion);
		evento.setId(idEvento);
		evento.setIdPsicologo(idPsicologo);
		this.agendaService.registrarEntradaAgenda(evento);
		evento = (Evento)this.agendaService.recuperarEntradaAgenda(idEvento);
		Assert.notNull(evento);
		Assert.isTrue(evento.getId()==idEvento);
		Assert.isTrue(evento.getDescripcion()==descripcion);
		Assert.isTrue(evento.getIdPsicologo()==idPsicologo);
	}
	
	@Test
	public void testRegistrarCitaOK() throws AgendaServiceException {		
		int idPsicologo=50104101;
		int idCita=1;
		Date date = es.upm.eui.tfc.jpa.service.Tiempos.stringToDate("2014-05-15 10:00:00");
		Timestamp fechaInicio = es.upm.eui.tfc.jpa.service.Tiempos.dateToTimeStamp(date);
		String idCliente="43543454G";
		TipoEntradaAgenda tipo=TipoEntradaAgenda.CITA;
		Cita cita = (Cita)this.agendaFactory.createEntradaAgenda(tipo);
		cita.setIdPsicologo(idPsicologo);
		cita.setId(idCita);
		cita.setIdCliente(idCliente);
		cita.setFechaInicio(fechaInicio);;
		this.agendaService.registrarEntradaAgenda(cita);
		cita = (Cita)this.agendaService.recuperarEntradaAgenda(idCita);
		Assert.notNull(cita);
		Assert.isTrue(cita.getId()==idCita);
		Assert.isTrue(cita.getIdPsicologo()==idPsicologo);
		Assert.isTrue(cita.getIdCliente()==idCliente);
	}
	/*
	
	
	
	
	@Test
	public void testRecuperarEventoOK() throws AgendaServiceException {
		int idEvento = 1;
				
		Evento evento = this.agendaService.recuperarEvento(idEvento);
		Assert.notNull(evento);
		Assert.notNull(evento.getIdEvento());
		Assert.notNull(evento.getIdPsicologo());
	}
	
	
	
	@Test
	public void testBorrarEventoOK() throws AgendaServiceException {
		boolean haHabidoExcepcion = false;
		boolean haHabidoOtraExcepcion = false;
		int idEvento = 1;
		try {
			this.eventosService.borrarEvento(idEvento);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(!haHabidoExcepcion);
		}
		
		try {
			Evento evento = this.eventosService.recuperarEvento(idEvento);
			Assert.isNull(evento);
		} catch (Exception e) {
			haHabidoOtraExcepcion = true;
		} finally {
			
			//no devuelve excepcion recuperarCliente aunque el cliente no exista
			Assert.isTrue(!haHabidoOtraExcepcion);			
		}
	}

	 */
}
