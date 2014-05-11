package es.upm.eui.tfc.model.factory;

import es.upm.eui.tfc.model.Cliente;

public interface ClienteFactory {

	public static final String FACTORY_NAME = "ClienteFactory";
	
	
	public Cliente createCliente();

}