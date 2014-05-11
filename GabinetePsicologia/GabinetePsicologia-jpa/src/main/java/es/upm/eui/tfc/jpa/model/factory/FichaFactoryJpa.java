package es.upm.eui.tfc.jpa.model.factory;

import org.springframework.stereotype.Service;


import es.upm.eui.tfc.model.Ficha;
import es.upm.eui.tfc.jpa.model.FichaImpl;
import es.upm.eui.tfc.model.factory.FichaFactory;

@Service(FichaFactory.FACTORY_NAME)
public class FichaFactoryJpa implements FichaFactory {

	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.factory.AgendaFactory#createPsicologo()
	 */
	@Override
	public Ficha createFicha() {
		Ficha ficha = null;
		
		ficha = new FichaImpl();
						 
		
		return ficha;
	}
	

}
