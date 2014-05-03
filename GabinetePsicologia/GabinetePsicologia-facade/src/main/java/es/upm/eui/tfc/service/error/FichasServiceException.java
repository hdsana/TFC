package es.upm.eui.tfc.service.error;

public class FichasServiceException extends Exception {

	public FichasServiceException(String message) {
		super(message);
	}

	public FichasServiceException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 10L;

}
