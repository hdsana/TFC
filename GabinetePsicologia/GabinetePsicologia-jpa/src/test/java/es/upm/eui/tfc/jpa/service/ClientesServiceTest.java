package es.upm.eui.tfc.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import es.upm.eui.tfc.jpa.model.ClienteImpl;
import es.upm.eui.tfc.model.Cliente;
import es.upm.eui.tfc.service.ClientesService;
import es.upm.eui.tfc.service.error.ClientesServiceException;
import es.upm.eui.tfc.service.filter.FiltroBusquedaClientes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class ClientesServiceTest {

	@Resource(name=ClientesService.SERVICE_NAME)
    public ClientesService clientesService;
	
	
    public ClientesService getClientesService() {
		return clientesService;
	}

    private Cliente crearClienteParaTest() {
		Cliente cliente = new ClienteImpl();
		//...
		return cliente;
    }
    
	public void setClientesService(ClientesService clientesService) {
		this.clientesService = clientesService;
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
			Cliente cliente = this.crearClienteParaTest();
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
		String nif="43543454G";
		String nombre="Hectorcete";
		String telefono="914741081";
		Cliente cliente = new ClienteImpl();
		cliente.setNif (nif);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		this.clientesService.registrarCliente(cliente);
		cliente = this.clientesService.recuperarCliente(nif);
		Assert.notNull(cliente);
		Assert.isTrue(cliente.getNif()==nif);
		Assert.isTrue(cliente.getNombre()==nombre);
		Assert.isTrue(cliente.getTelefono()==telefono);
	}

	
	@Test
	public void testActualizarClienteOK() throws ClientesServiceException {
		Cliente cliente=this.clientesService.recuperarCliente("50104101G");		
		String telefono;
		String telefonoNew="99999999";
		
		telefono=cliente.getTelefono();
		Assert.isTrue(!telefono.equals(telefonoNew));
		cliente.setTelefono(telefonoNew);
		this.clientesService.actualizarCliente(cliente);
		Cliente clienteRec = this.clientesService.recuperarCliente("50104101G");
		Assert.notNull(clienteRec);
		Assert.isTrue(clienteRec.getTelefono()==telefonoNew);
	}
	
	
	@Test
	public void testRecuperarClienteOK() throws ClientesServiceException {
		String nif = "50104101G";
				
		Cliente cliente = this.clientesService.recuperarCliente(nif);
		Assert.notNull(cliente);
		Assert.hasText(cliente.getNif());
		Assert.hasText(cliente.getTelefono());

	}
	
	@Test
	public void testBorrarClienteOK() throws ClientesServiceException {
		boolean haHabidoExcepcion = false;
		String nif = "50104101G";
		try {
			this.clientesService.borrarCliente(nif);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(!haHabidoExcepcion);
		}
		
		try {
			Cliente cliente = this.clientesService.recuperarCliente(nif);
			Assert.isNull(cliente);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			
			//no devuelve excepcion recuperarCliente aunque el cliente no exista
			Assert.isTrue(!haHabidoExcepcion);			
		}
	}
	
	@Test
	public void testAsignarPsicologoOK() throws ClientesServiceException {
	
		boolean haHabidoExcepcion = false;
		String nif = "43543454G";
		int codigoPsicologo = 50104101;
		try {
			Cliente cliente = this.clientesService.recuperarCliente(nif);
			Assert.notNull(cliente);
			this.clientesService.asignarPsicologo(cliente,codigoPsicologo);
			cliente = this.clientesService.recuperarCliente(nif);
			Assert.isTrue(cliente.getCodigoPsicologo().equals(codigoPsicologo));
		} catch (Exception e) {
			haHabidoExcepcion = true;
		}finally {
			
			//no devuelve excepcion recuperarCliente aunque el cliente no exista
			Assert.isTrue(!haHabidoExcepcion);			
		}
	}
	
	@Test
	public void testBuscarClientesOK() throws ClientesServiceException {
		FiltroBusquedaClientes filtro = new FiltroBusquedaClientes();
		filtro.setNombre("Ra");
		List<Cliente> listaClientes = this.clientesService.buscarClientes(filtro);
		Assert.notNull(listaClientes);
		Assert.notEmpty(listaClientes);
	}
}
