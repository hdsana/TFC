package es.upm.eui.tfc.model;

public interface Psicologo {

	public abstract String getNif();

	public abstract void setNif(String nif);

	public abstract String getApellidos();

	public abstract void setApellidos(String apellidos);

	public abstract String getNombre();

	public abstract void setNombre(String nombre);
	
	public abstract int getIdPsicologo();
	
	public abstract void setIdPsicologo(int idPsicologo);

}