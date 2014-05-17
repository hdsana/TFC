package es.upm.eui.tfc.jpa.model.factory;

import org.springframework.stereotype.Service;

import es.upm.eui.tfc.jpa.model.CitaImpl;
import es.upm.eui.tfc.jpa.model.EventoImpl;
import es.upm.eui.tfc.model.EntradaAgenda;
import es.upm.eui.tfc.model.factory.AgendaFactory;

@Service(AgendaFactory.FACTORY_NAME)
public class AgendaFactoryJpa implements AgendaFactory {

	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.factory.AgendaFactory#createCita()
	 */
	@Override
	public EntradaAgenda createEntradaAgenda(TipoEntradaAgenda tipo) {
		EntradaAgenda entradaAgenda = null;
		switch (tipo) {
			case EVENTO: entradaAgenda = new EventoImpl();
						 break;
			case CITA: 	 entradaAgenda = new CitaImpl();
			 			 break;
		}
		return entradaAgenda;
	}
	

}
