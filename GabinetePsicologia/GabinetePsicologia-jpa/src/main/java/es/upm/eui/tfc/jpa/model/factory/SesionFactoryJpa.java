package es.upm.eui.tfc.jpa.model.factory;

import org.springframework.stereotype.Service;


import es.upm.eui.tfc.model.Sesion;
import es.upm.eui.tfc.jpa.model.SesionImpl;
import es.upm.eui.tfc.model.factory.SesionFactory;

@Service(SesionFactory.FACTORY_NAME)
public class SesionFactoryJpa implements SesionFactory {

	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.factory.AgendaFactory#createPsicologo()
	 */
	@Override
	public Sesion createSesion() {
		Sesion sesion = null;
		
		sesion = new SesionImpl();
						 
		
		return sesion;
	}
	

}
