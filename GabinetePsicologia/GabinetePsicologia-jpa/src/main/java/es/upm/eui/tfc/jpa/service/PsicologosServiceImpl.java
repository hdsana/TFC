package es.upm.eui.tfc.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.eui.tfc.jpa.model.PsicologoImpl;
import es.upm.eui.tfc.model.Psicologo;
import es.upm.eui.tfc.service.PsicologosService;
import es.upm.eui.tfc.service.error.PsicologosServiceException;

@Service(PsicologosService.SERVICE_NAME)
public class PsicologosServiceImpl implements PsicologosService {
	
	private static final long serialVersionUID = -106788683863805341L;
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Implementacion JPA para registrar un nuevo psicologo.
	 * 
	 * @param psicologo
	 * @throws PsicologosServiceException si hay algun error en el acceso a base de datos o el parametro de entrada no es valido.
	 */
	@Transactional
	public Psicologo registrarPsicologo(Psicologo psicologo)
			throws PsicologosServiceException {
		try {
			if (psicologo != null && !em.contains(psicologo)) {
				em.persist(psicologo);
			} else {
				throw new PsicologosServiceException("El psicologo no puede ser null");
			}
		} catch (Exception e) {
			throw new PsicologosServiceException(e);
		}
		return psicologo;

	}

	@Override
	public void borrarPsicologo(Integer dni) throws PsicologosServiceException {
		PsicologoImpl psicologo = null;
		try {
			if (dni != null) {
				psicologo = new PsicologoImpl();
				psicologo.setDni(dni);
				psicologo = em.merge(psicologo);
				em.remove(psicologo);
			} else {
				throw new PsicologosServiceException("El NIF no puede ser null ni vacio");
			}
		} catch (Exception e) {
			throw new PsicologosServiceException(e);
		}
		

	}

	@Override
	public Psicologo recuperarPsicologo(Integer dni)
			throws PsicologosServiceException {
		Psicologo psicologo = null;
		if (dni != null) {
			psicologo = em.find(PsicologoImpl.class, dni);
		} else {
			throw new PsicologosServiceException("El DNI no puede ser null ni vacio");
		}
		return psicologo;		
	}

	@Override
	public void actualizarPsicologo(Psicologo psicologo) 
			throws PsicologosServiceException {
		Integer dni=psicologo.getDni();
		try {
			this.borrarPsicologo(dni);
			this.registrarPsicologo(psicologo);
		} catch (Exception e) {
			throw new PsicologosServiceException(e);
		}

	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Psicologo> recuperarTodosLosPsicologos() throws PsicologosServiceException {
		Query query = em.createNamedQuery("PsicologoImpl.findAll");
		List<Psicologo> listaPsicologos = (List<Psicologo>) query.getResultList();
		return listaPsicologos;
	}

}
