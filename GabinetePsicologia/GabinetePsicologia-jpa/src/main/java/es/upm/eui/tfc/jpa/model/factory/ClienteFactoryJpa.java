package es.upm.eui.tfc.jpa.model.factory;

import org.springframework.stereotype.Service;


import es.upm.eui.tfc.model.Cliente;
import es.upm.eui.tfc.jpa.model.ClienteImpl;
import es.upm.eui.tfc.model.factory.ClienteFactory;

@Service(ClienteFactory.FACTORY_NAME)
public class ClienteFactoryJpa implements ClienteFactory {

	
	/* (non-Javadoc)
	 * @see es.upm.eui.tfc.jpa.model.factory.AgendaFactory#createCita()
	 */
	@Override
	public Cliente createCliente() {
		Cliente cliente = null;
		
		cliente = new ClienteImpl();
						 
		
		return cliente;
	}
	

}
