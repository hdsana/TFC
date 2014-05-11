package es.upm.eui.tfc.jpa.model.factory;

import org.springframework.stereotype.Service;


import es.upm.eui.tfc.model.Psicologo;
import es.upm.eui.tfc.jpa.model.PsicologoImpl;
import es.upm.eui.tfc.model.factory.PsicologoFactory;

@Service(PsicologoFactory.FACTORY_NAME)
public class PsicologoFactoryJpa implements PsicologoFactory {

	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.factory.AgendaFactory#createPsicologo()
	 */
	@Override
	public Psicologo createPsicologo() {
		Psicologo psicologo = null;
		
		psicologo = new PsicologoImpl();
						 
		
		return psicologo;
	}
	

}
