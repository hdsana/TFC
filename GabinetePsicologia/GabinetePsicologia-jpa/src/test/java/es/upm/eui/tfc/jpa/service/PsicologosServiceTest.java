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
import es.upm.eui.tfc.service.PsicologosService;
import es.upm.eui.tfc.service.error.PsicologosServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext-JPA.xml"})
public class PsicologosServiceTest {
	
	@Resource(name=PsicologosService.SERVICE_NAME)
    public PsicologosService psicologosService;
	
	
    public PsicologosService getPsicologosService() {
		return psicologosService;
	}

	public void setPsicologosService(PsicologosService psicologosService) {
		this.psicologosService = psicologosService;
	}
	
    private Psicologo crearPsicologoParaTest() {
		Psicologo psicologo = new PsicologoImpl();
		psicologo.setDni (50104101);
		psicologo.setNombre("Raulete Psico");
		psicologo.setApellidos("Psico Psico");
		return psicologo;
    }

	
	@Test
	public void testRegistrarPsicologoOK() throws PsicologosServiceException {
		Integer dni = 50104101;
		String nombre="Raulete Psico";
		String apellidos="Psico Psico";
		Psicologo psicologo = new PsicologoImpl();
		psicologo.setDni (dni);
		psicologo.setNombre(nombre);
		psicologo.setApellidos(apellidos);
		this.psicologosService.registrarPsicologo(psicologo);
		Psicologo psicologo2 = this.psicologosService.recuperarPsicologo(dni);
		Assert.notNull(psicologo);
		Assert.isTrue(psicologo.equals(psicologo2));
	}
	
	@Test
	public void testRecuperarPsicologoOK() throws PsicologosServiceException {
		Integer dni = 50104101;
				
		Psicologo psicologo = this.psicologosService.recuperarPsicologo(dni);
		Assert.notNull(psicologo);
		Assert.notNull(psicologo.getDni());
	}

	@Test
	public void testRecuperarTodosLosPsicologos() throws PsicologosServiceException {
		List<Psicologo> listaPsicologos = this.psicologosService.recuperarTodosLosPsicologos();
		Assert.notNull(listaPsicologos);
		Assert.notEmpty(listaPsicologos);
	}
	
}
