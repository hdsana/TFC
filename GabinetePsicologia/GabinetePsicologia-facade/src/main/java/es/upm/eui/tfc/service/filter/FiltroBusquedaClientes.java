package es.upm.eui.tfc.service.filter;

public class FiltroBusquedaClientes {

	private String nombre;
	private String apellidos;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public boolean filtrarPorNombre() {
		return this.nombre != null && !"".equals(this.nombre.trim());
	}

	public boolean filtrarPorApellidos() {
		return this.apellidos != null && !"".equals(this.apellidos.trim());
	}
	
	public boolean isValido() {
		return this.filtrarPorNombre() || this.filtrarPorApellidos();
	}
	
}
