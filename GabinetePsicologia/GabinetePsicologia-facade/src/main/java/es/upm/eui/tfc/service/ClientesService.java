package es.upm.eui.tfc.service;

import java.io.Serializable;
import java.util.List;

import es.upm.eui.tfc.model.Cliente;
import es.upm.eui.tfc.service.error.ClientesServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaClientes;

public interface ClientesService extends Serializable {

	public static final String SERVICE_NAME = "ClientesService";
	
	/**
	 * Operacion para registrar un nuevo cliente.
	 * 
	 * @param cliente
	 * @throws ClientesServiceException
	 */
	public Cliente registrarCliente(Cliente cliente) throws ClientesServiceException;
	
	public void borrarCliente(String nif) throws ClientesServiceException;
	
	public Cliente recuperarCliente(String nif) throws ClientesServiceException;
	
	public void actualizarCliente(Cliente cliente) throws ClientesServiceException;
	
	public void asignarPsicologo(Cliente cliente, int codigoPsicologo) throws ClientesServiceException;
	
	public List<Cliente> buscarClientes(FiltroBusquedaClientes filtro) throws ClientesServiceException;
	
}