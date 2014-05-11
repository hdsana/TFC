package es.upm.eui.tfc.model.factory;

import es.upm.eui.tfc.model.Psicologo;

public interface PsicologoFactory {

	public static final String FACTORY_NAME = "PsicologoFactory";
	
	
	public Psicologo createPsicologo();

}