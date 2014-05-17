package es.upm.eui.tfc.jpa.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import es.upm.eui.tfc.jpa.model.EventoImpl;
import es.upm.eui.tfc.jpa.model.PsicologoImpl;
import es.upm.eui.tfc.model.Evento;
import es.upm.eui.tfc.model.Psicologo;
import es.upm.eui.tfc.service.AgendaService;
import es.upm.eui.tfc.service.PsicologosService;
import es.upm.eui.tfc.service.error.AgendaServiceException;
import es.upm.eui.tfc.service.error.PsicologosServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class AgendaServiceTest {
	
	@Resource(name=AgendaService.SERVICE_NAME)
    public AgendaService agendaService;
	
	@Resource(name=PsicologosService.SERVICE_NAME)
    public PsicologosService psicologosService;
	
	private Psicologo insertarPsicologoParaTest() throws PsicologosServiceException {
		String nif="33445566";
		String nombre="Héctor";
		String apellidos="Gutierrez García";
		Psicologo psicologo = new PsicologoImpl();
		psicologo.setNif (nif);
		psicologo.setNombre(nombre);
		psicologo.setApellidos(apellidos);
		psicologo = this.psicologosService.registrarPsicologo(psicologo);
		return psicologo;
	}

	private Evento insertarEventoParaTest(Psicologo psicologo) throws AgendaServiceException {
		Evento evento = new EventoImpl();
		evento.setDescripcion("Quedar con Raulete Evento");
		evento.setIdPsicologo(psicologo.getIdPsicologo());
		
		Calendar calendar = GregorianCalendar.getInstance();
		Date inicio = calendar.getTime();
		calendar.roll(Calendar.DAY_OF_MONTH, 1);
		Date fin = calendar.getTime();
		evento.setFechaInicio(inicio);
		evento.setFechaFin(fin);
		
		evento = this.agendaService.registrarEntradaAgenda(evento);
		return evento;
	}
	
	/*
	private Cita insertarCitaParaTest(Psicologo psicologo) throws AgendaServiceException {
		Cita evento = new CitaImpl();
		evento.setDescripcion("Quedar con Raulete Evento");
		evento.setIdPsicologo(psicologo.getIdPsicologo());
		evento = this.agendaService.registrarEntradaAgenda(evento);
		return evento;
	}
	*/

	
	@Test
	public void testRegistrarEventoOK() throws AgendaServiceException, PsicologosServiceException {
		Psicologo psicologo = this.insertarPsicologoParaTest();
		Evento evento = this.insertarEventoParaTest(psicologo);
		Evento evento2 = this.agendaService.recuperarEntradaAgenda(evento.getId(), Evento.class);
		Assert.notNull(evento);
		Assert.isTrue(evento2.equals(evento));
		
		this.agendaService.borrarEntradaAgenda(evento);
		this.psicologosService.borrarPsicologo(psicologo);
	}
	
	/*
	
	@Test
	public void testRegistrarCitaOK() throws AgendaServiceException {		
		Psicologo psicologo = this.insertarPsicologoParaTest();
		Cita cita = this.insertarEventoParaTest(psicologo);
		Evento evento2 = this.agendaService.recuperarEntradaAgenda(evento.getId(), Evento.class);
		Assert.notNull(evento);
		Assert.isTrue(evento2.equals(evento));
		
		this.agendaService.borrarEntradaAgenda(id, tipo);
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
