package es.upm.eui.tfc.service.error;

public class PsicologosServiceException extends Exception {

	private static final long serialVersionUID = -8221171256661582766L;

	public PsicologosServiceException(String message) {
		super(message);
	}

	public PsicologosServiceException(Exception e) {
		super(e);
	}
	
}
