package es.upm.eui.tfc.service.error;

public class AgendaServiceException extends Exception {

	public AgendaServiceException(String message) {
		super(message);
	}

	public AgendaServiceException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 5L;

}
