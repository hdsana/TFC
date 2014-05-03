package es.upm.eui.tfc.jpa.service;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import es.upm.eui.tfc.jpa.model.EventoImpl;
import es.upm.eui.tfc.model.Evento;
import es.upm.eui.tfc.service.error.AgendaServiceException;
import es.upm.eui.tfc.service.AgendaService;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class AgendaServiceTest {
	
	@Resource(name=AgendaService.SERVICE_NAME)
    public AgendaService agendaService;

	/*
	@Test
	public void testRegistrarEventoOK() throws AgendaServiceException {
		String descripcion="Quedar con Raulete Evento";
		int idPsicologo=50104101;
		Evento evento = new EventoImpl();
		evento.setDescripcion(descripcion);
		evento.setIdPsicologo(idPsicologo);
		this.agendaService.registrarEntradaAgenda(evento);
		evento = this.agendaService.recuperarEvento(idEvento);
		Assert.notNull(evento);
		Assert.isTrue(evento.getIdEvento()==idEvento);
		Assert.isTrue(evento.getDescripcion()==descripcion);
		Assert.isTrue(evento.getIdPsicologo()==idPsicologo);
	}
	
	
	
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
