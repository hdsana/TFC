package es.upm.eui.tfc.service.error;

public class ClientesServiceException extends Exception {

	public ClientesServiceException(String message) {
		super(message);
	}

	public ClientesServiceException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 6970352974032788308L;

}
