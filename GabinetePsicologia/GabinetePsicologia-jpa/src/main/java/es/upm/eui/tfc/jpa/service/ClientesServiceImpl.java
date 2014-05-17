package es.upm.eui.tfc.jpa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.eui.tfc.jpa.model.ClienteImpl;
import es.upm.eui.tfc.model.Cliente;
import es.upm.eui.tfc.service.ClientesService;
import es.upm.eui.tfc.service.error.ClientesServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaClientes;

@Service(ClientesService.SERVICE_NAME)
public class ClientesServiceImpl implements ClientesService {

	private static final long serialVersionUID = -2117003286503596237L;

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Implementacion JPA para registrar un nuevo cliente.
	 * 
	 * @param cliente
	 * @throws ClientesServiceException si hay algun error en el acceso a base de datos o el parametro de entrada no es valido.
	 */
	@Transactional
	public Cliente registrarCliente(Cliente cliente) throws ClientesServiceException {
		try {
			if (cliente != null && !em.contains(cliente)) {
				em.persist(cliente);
			} else {
				throw new ClientesServiceException("El cliente no puede ser null");
			}
		} catch (Exception e) {
			throw new ClientesServiceException(e);
		}
		return cliente;
	}

	public void borrarCliente(String nif) throws ClientesServiceException {
		ClienteImpl cliente = null;
		try {
			if (nif != null && !"".equals(nif.trim())) {
				cliente = new ClienteImpl();
				cliente.setNif(nif);
				this.borrarCliente(cliente);
			} else {
				throw new ClientesServiceException("El NIF no puede ser null ni vacio");
			}
		} catch (Exception e) {
			throw new ClientesServiceException(e);
		}
		
	}

	@Transactional
	public void borrarCliente(Cliente cliente) throws ClientesServiceException {
		try {
			cliente = em.merge(cliente);
			em.remove(cliente);
		} catch (Exception e) {
			throw new ClientesServiceException(e);
		}
		
	}

	public Cliente recuperarCliente(String nif) throws ClientesServiceException {
		Cliente cliente = null;
		try {	
			if (nif != null && !"".equals(nif.trim())) {
				cliente = em.find(ClienteImpl.class, nif);
			} else {
				throw new ClientesServiceException("El NIF no puede ser null ni vacio");
			}
		} catch (Exception e) {
			throw new ClientesServiceException(e);
		}
		return cliente;
	}
	
	@Transactional
	public void actualizarCliente(Cliente cliente) throws ClientesServiceException {
		try {
			if (cliente != null) {
				cliente = em.merge(cliente);
			} else {
				throw new ClientesServiceException("El cliente no puede ser null");
			}
			
		} catch (Exception e) {
			throw new ClientesServiceException(e);
		}
		
	}
	
	@Transactional
	public void asignarPsicologo(Cliente cliente, int codigoPsicologo) throws ClientesServiceException {
		try {
			cliente.setCodigoPsicologo(codigoPsicologo);
			cliente = em.merge(cliente);
		} catch (Exception e) {
			throw new ClientesServiceException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Cliente> buscarClientes(FiltroBusquedaClientes filtro) throws ClientesServiceException {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		if (filtro == null) {
			throw new ClientesServiceException("El filtro no puede ser nulo");
		} else if (!filtro.isValido()) {
			throw new ClientesServiceException("Filtro no valido");
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c FROM ClienteImpl c");
		sql.append(" WHERE ");
		boolean and = false;
		if (filtro.filtrarPorNombre()) {
			sql.append("c.nombre LIKE :nombre");
			and = true;
		}
		if (filtro.filtrarPorApellidos()) {
			if (and) {
				sql.append(" AND ");
			}
			sql.append("c.apellidos LIKE :apellidos");
		}
		
		TypedQuery<ClienteImpl> query = em.createQuery(sql.toString(), ClienteImpl.class);

		if (filtro.filtrarPorNombre()) {
			query.setParameter("nombre", filtro.getNombre() + "%");
		}
		if (filtro.filtrarPorApellidos()) {
			query.setParameter("apellidos", filtro.getApellidos() + "%");
		}

		List<ClienteImpl> clientes = query.getResultList();
		for (Iterator i=clientes.iterator(); i.hasNext();) {
			Cliente cliente = (Cliente) i.next();
			listaClientes.add(cliente);
		}

		return listaClientes;
	}

}
