package es.upm.eui.tfc.model.factory;

import es.upm.eui.tfc.model.Sesion;

public interface SesionFactory {

	public static final String FACTORY_NAME = "SesionFactory";
	
	
	public Sesion createSesion();

}