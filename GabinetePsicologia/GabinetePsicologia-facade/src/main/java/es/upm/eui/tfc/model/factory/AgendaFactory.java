package es.upm.eui.tfc.model.factory;

import es.upm.eui.tfc.model.EntradaAgenda;

public interface AgendaFactory {

	public static final String FACTORY_NAME = "AgendaFactory";
	
	public enum TipoEntradaAgenda {CITA, EVENTO};
	
	
	public EntradaAgenda createEntradaAgenda(TipoEntradaAgenda tipo);

}