package es.upm.eui.tfc.model.factory;

import es.upm.eui.tfc.model.Ficha;

public interface FichaFactory {

	public static final String FACTORY_NAME = "FichaFactory";
	
	
	public Ficha createFicha();

}