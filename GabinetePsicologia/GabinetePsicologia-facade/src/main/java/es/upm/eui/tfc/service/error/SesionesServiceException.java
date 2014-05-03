package es.upm.eui.tfc.service.error;

public class SesionesServiceException extends Exception {

	public SesionesServiceException(String message) {
		super(message);
	}

	public SesionesServiceException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 11L;

}
