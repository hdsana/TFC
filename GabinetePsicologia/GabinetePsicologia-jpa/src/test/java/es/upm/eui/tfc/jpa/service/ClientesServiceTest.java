package es.upm.eui.tfc.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import es.upm.eui.tfc.jpa.model.ClienteImpl;
import es.upm.eui.tfc.jpa.model.PsicologoImpl;
import es.upm.eui.tfc.model.Cliente;
import es.upm.eui.tfc.model.Psicologo;
import es.upm.eui.tfc.service.ClientesService;
import es.upm.eui.tfc.service.PsicologosService;
import es.upm.eui.tfc.service.error.ClientesServiceException;
import es.upm.eui.tfc.service.error.PsicologosServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaClientes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class ClientesServiceTest {

	@Resource(name=ClientesService.SERVICE_NAME)
    public ClientesService clientesService;
	
	@Resource(name=PsicologosService.SERVICE_NAME)
    public PsicologosService psicologosService;
	
	private static final String DNI_EJEMPLO = "1111111A";
	
	
    public ClientesService getClientesService() {
		return clientesService;
	}
    
	public void setClientesService(ClientesService clientesService) {
		this.clientesService = clientesService;
	}
	
	private Cliente insertarClienteParaTest() throws ClientesServiceException {
		// Si ya existe el cliente, lo borramos
		Cliente cliente = this.clientesService.recuperarCliente(DNI_EJEMPLO);
		if (cliente != null) {
			this.clientesService.borrarCliente(cliente);
		}
		
		String nif=DNI_EJEMPLO;
		String nombre="Juan";
		String apellidos="Gonzalez Ponce";
		String telefono="914741081";
		cliente = new ClienteImpl();
		cliente.setNif (nif);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setTelefono(telefono);
		cliente = this.clientesService.registrarCliente(cliente);
		return cliente;
	}
	
	private Psicologo insertarPsicologoParaTest() throws PsicologosServiceException {
		String nif="33445566";
		String nombre="Héctor";
		String apellidos="Gutierrez García";
		Psicologo psicologo = new PsicologoImpl();
		psicologo.setNif (nif);
		psicologo.setNombre(nombre);
		psicologo.setApellidos(apellidos);
		psicologo = this.psicologosService.registrarPsicologo(psicologo);
		return psicologo;
	}
	
	@Test
	public void testRegistrarClienteNulo() throws ClientesServiceException {
		boolean haHabidoExcepcion = false;
		try {
			this.clientesService.registrarCliente(null);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(haHabidoExcepcion);
		}
	}
	
	@Test
	public void testRegistrarClienteNifNulo() throws ClientesServiceException {
		boolean haHabidoExcepcion = false;
		try {
			Cliente cliente = new ClienteImpl();
			cliente.setNif(null);
			this.clientesService.registrarCliente(cliente);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(haHabidoExcepcion);
		}
		
	}
	
	@Test
	public void testRegistrarClienteOK() throws ClientesServiceException {
		Cliente cliente = this.insertarClienteParaTest();
		Cliente cliente2 = this.clientesService.recuperarCliente(cliente.getNif());
		Assert.notNull(cliente2);
		Assert.isTrue(cliente2.equals(cliente));
		
		// Borramos el cliente para no dejar basura en BBDD
		this.clientesService.borrarCliente(cliente2);
	}

	@Test
	public void testRegistrarClienteDuplicado() throws ClientesServiceException {
		Cliente cliente = this.insertarClienteParaTest();
		
		boolean haHabidoExcepcion = false;
		try {
			this.clientesService.registrarCliente(cliente);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(haHabidoExcepcion);
		}

		// Borramos el cliente para no dejar basura en BBDD
		this.clientesService.borrarCliente(cliente);
	}

	
	@Test
	public void testActualizarClienteOK() throws ClientesServiceException {
		Cliente cliente = this.insertarClienteParaTest();
		String telefonoNew="99999999";
		cliente.setTelefono(telefonoNew);
		this.clientesService.actualizarCliente(cliente);
		Cliente cliente2 = this.clientesService.recuperarCliente(DNI_EJEMPLO);
		Assert.notNull(cliente2);
		Assert.isTrue(cliente2.getTelefono().equals(telefonoNew));
		
		// Borramos el cliente para no dejar basura en BBDD
		this.clientesService.borrarCliente(cliente2);
	}
	
	
	@Test
	public void testRecuperarClienteOK() throws ClientesServiceException {
		Cliente cliente = this.insertarClienteParaTest();
		Cliente cliente2 = this.clientesService.recuperarCliente(cliente.getNif());
		Assert.notNull(cliente2);
		Assert.isTrue(cliente2.equals(cliente));
		
		// Borramos el cliente para no dejar basura en BBDD
		this.clientesService.borrarCliente(cliente2);
	}
	
	@Test
	public void testRecuperarClienteNoExiste() throws PsicologosServiceException {
		boolean haHabidoExcepcion = false;
		try {
			Cliente cliente = this.clientesService.recuperarCliente("No existe");
			Assert.isNull(cliente);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(!haHabidoExcepcion);
		}
	}

	
	@Test
	public void testBorrarClienteOK() throws ClientesServiceException {
		boolean haHabidoExcepcion = false;
		Cliente cliente = this.insertarClienteParaTest();
		try {
			this.clientesService.borrarCliente(cliente);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(!haHabidoExcepcion);
		}
		
		try {
			cliente = this.clientesService.recuperarCliente(cliente.getNif());
			Assert.isNull(cliente);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
				//no devuelve excepcion recuperarCliente aunque el cliente no exista
			Assert.isTrue(!haHabidoExcepcion);			
		}
		
	}
	
	@Test
	public void testAsignarPsicologoOK() throws ClientesServiceException, PsicologosServiceException {
		boolean haHabidoExcepcion = false;
		Cliente cliente = this.insertarClienteParaTest();
		Psicologo psicologo = this.insertarPsicologoParaTest();
		
		try {
			Assert.notNull(cliente);
			Assert.notNull(psicologo);
			this.clientesService.asignarPsicologo(cliente,psicologo.getIdPsicologo());
			cliente = this.clientesService.recuperarCliente(cliente.getNif());
			Assert.isTrue(cliente.getCodigoPsicologo().equals(psicologo.getIdPsicologo()));
		} catch (Exception e) {
			haHabidoExcepcion = true;
		}finally {
			//no devuelve excepcion recuperarCliente aunque el cliente no exista
			Assert.isTrue(!haHabidoExcepcion);
		}
		
		// Borramos el cliente para no dejar basura en BBDD
		this.psicologosService.borrarPsicologo(psicologo);
		this.clientesService.borrarCliente(cliente);
	}
	
	@Test
	public void testBuscarClientesOK() throws ClientesServiceException {
		Cliente cliente = this.insertarClienteParaTest();
		
		FiltroBusquedaClientes filtro = new FiltroBusquedaClientes();
		filtro.setNombre(cliente.getNombre().substring(0, 2));
		List<Cliente> listaClientes = this.clientesService.buscarClientes(filtro);
		Assert.notNull(listaClientes);
		Assert.notEmpty(listaClientes);
		
		// Borramos el cliente para no dejar basura en BBDD
		this.clientesService.borrarCliente(cliente);
	}
}
