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
	@Override
	@Transactional
	public Psicologo registrarPsicologo(Psicologo psicologo)
			throws PsicologosServiceException {
		try {
			if (psicologo != null) {
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
	@Transactional
	public void borrarPsicologo(Psicologo psicologo) throws PsicologosServiceException {
		try {
			psicologo = em.merge(psicologo);
			em.remove(psicologo);
		} catch (Exception e) {
			throw new PsicologosServiceException(e);
		}
	}

	
	@Override
	@Transactional
	public void borrarPsicologo(Integer idPsicologo) throws PsicologosServiceException {
		PsicologoImpl psicologo = null;
		try {
			if (idPsicologo != null) {
				psicologo = new PsicologoImpl();
				psicologo.setIdPsicologo(idPsicologo);
				this.borrarPsicologo(psicologo);
			} else {
				throw new PsicologosServiceException("El NIF no puede ser null ni vacio");
			}
		} catch (Exception e) {
			throw new PsicologosServiceException(e);
		}
		

	}

	@Override
	public Psicologo recuperarPsicologo(Integer idPsicologo)
			throws PsicologosServiceException {
		Psicologo psicologo = null;
		if (idPsicologo != null) {
			psicologo = em.find(PsicologoImpl.class, idPsicologo);
		} else {
			throw new PsicologosServiceException("El DNI no puede ser null ni vacio");
		}
		return psicologo;		
	}

	@Override
	@Transactional
	public void actualizarPsicologo(Psicologo psicologo) 
			throws PsicologosServiceException {
		try {
			if (psicologo != null) {
				psicologo = em.merge(psicologo);
			} else {
				throw new PsicologosServiceException("El psicologo no puede ser null");
			}
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
