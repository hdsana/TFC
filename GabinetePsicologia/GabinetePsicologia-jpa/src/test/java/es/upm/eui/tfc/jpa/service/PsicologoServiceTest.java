package es.upm.eui.tfc.jpa.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import es.upm.eui.tfc.jpa.model.PsicologoImpl;
import es.upm.eui.tfc.model.Psicologo;
import es.upm.eui.tfc.service.PsicologosService;
import es.upm.eui.tfc.service.error.PsicologosServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class PsicologoServiceTest {

	@Resource(name=PsicologosService.SERVICE_NAME)
    public PsicologosService psicologosService;

	
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
	public void testRegistrarPsicologoNulo() throws PsicologosServiceException {
		boolean haHabidoExcepcion = false;
		try {
			this.psicologosService.registrarPsicologo(null);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(haHabidoExcepcion);
		}
	}
	
	@Test
	public void testRegistrarPsicologoOK() throws PsicologosServiceException {
		Psicologo psicologo = this.insertarPsicologoParaTest();
		Psicologo psicologo2 = this.psicologosService.recuperarPsicologo(psicologo.getIdPsicologo());
		Assert.notNull(psicologo2);
		Assert.isTrue(psicologo2.equals(psicologo));
		
		// Borramos el psicologo para no dejar basura en BBDD
		this.psicologosService.borrarPsicologo(psicologo);
	}
	
	@Test
	public void testActualizarPsicologoOK() throws PsicologosServiceException {
		Psicologo psicologo = this.insertarPsicologoParaTest();
		String nuevosApellidos = "Otros apellidos";
		psicologo.setApellidos(nuevosApellidos);
		this.psicologosService.actualizarPsicologo(psicologo);
		Psicologo psicologo2 = this.psicologosService.recuperarPsicologo(psicologo.getIdPsicologo());
		Assert.notNull(psicologo2);
		Assert.isTrue(psicologo2.getApellidos().equals(nuevosApellidos));
		
		// Borramos el psicologo para no dejar basura en BBDD
		this.psicologosService.borrarPsicologo(psicologo);
	}
	
	
	@Test
	public void testRecuperarPsicologoOK() throws PsicologosServiceException {
		Psicologo psicologo = this.insertarPsicologoParaTest();
		Psicologo psicologo2 = this.psicologosService.recuperarPsicologo(psicologo.getIdPsicologo());
		Assert.notNull(psicologo2);
		Assert.isTrue(psicologo2.equals(psicologo));
		
		// Borramos el psicologo para no dejar basura en BBDD
		this.psicologosService.borrarPsicologo(psicologo2);
	}
	
	@Test
	public void testRecuperarPsicologoNoExiste() throws PsicologosServiceException {
		boolean haHabidoExcepcion = false;
		try {
			Psicologo psicologo = this.psicologosService.recuperarPsicologo(Integer.MAX_VALUE);
			Assert.isNull(psicologo);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(!haHabidoExcepcion);
		}
	}

	
	@Test
	public void testBorrarPsicologoOK() throws PsicologosServiceException {
		boolean haHabidoExcepcion = false;
		Psicologo psicologo = this.insertarPsicologoParaTest();
		try {
			this.psicologosService.borrarPsicologo(psicologo);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			Assert.isTrue(!haHabidoExcepcion);
		}
		
		try {
			psicologo = this.psicologosService.recuperarPsicologo(psicologo.getIdPsicologo());
			Assert.isNull(psicologo);
		} catch (Exception e) {
			haHabidoExcepcion = true;
		} finally {
			// No devuelve excepcion recuperarPsicologo aunque el psicologo no exista
			Assert.isTrue(!haHabidoExcepcion);			
		}
		
	}
	
}
