package es.upm.eui.tfc.model;

public interface Cliente {

	public abstract String getNif();

	public abstract void setNif(String nif);

	public abstract String getApellidos();

	public abstract void setApellidos(String apellidos);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract String getTelefono();

	public abstract void setTelefono(String telefono);

	public abstract Integer getCodigoPsicologo();

	public abstract void setCodigoPsicologo(Integer codigoPsicologo);

}