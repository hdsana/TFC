package es.upm.eui.tfc.jpa.service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.eui.tfc.jpa.model.FichaImpl;
import es.upm.eui.tfc.model.Ficha;
import es.upm.eui.tfc.service.FichasService;
import es.upm.eui.tfc.service.error.FichasServiceException;

@Service(FichasService.SERVICE_NAME)
public class FichasServiceImpl implements FichasService {

	private static final long serialVersionUID = -15L;

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Implementacion JPA para registrar una nueva ficha.
	 * 
	 * @param ficha
	 * @throws FichasServiceException si hay algun error en el acceso a base de datos o el parametro de entrada no es valido.
	 */
	@Transactional
	public Ficha registrarFicha(Ficha ficha) throws FichasServiceException {
		try {
			if (ficha != null) {
				em.persist(ficha);
			} else {
				throw new FichasServiceException("La ficha no puede ser null o ficha ya existe");
			}
		} catch (Exception e) {
			throw new FichasServiceException(e);
		}
		return ficha;
	}

	@Transactional
	public void borrarFicha(int idFicha) throws FichasServiceException {
		try {
			if (idFicha >= 0) {
				FichaImpl ficha = new FichaImpl();
				ficha.setIdFicha(idFicha);
				ficha = em.merge(ficha);
				em.remove(ficha);
			} else {
				throw new FichasServiceException("El id ficha no puede menor que cero");
			}
		} catch (Exception e) {
			throw new FichasServiceException(e);
		}
		
	}
	
	@Transactional
	public Ficha recuperarFicha(int fichaId) throws FichasServiceException {
		Ficha ficha = null;
		try {	
			if (fichaId >= 0) {
				ficha = em.find(FichaImpl.class, fichaId);
			} else {
				throw new FichasServiceException("El id de evento no puede menor que cero");
			}
		} catch (Exception e) {
			throw new FichasServiceException(e);
		}
		return ficha;
		
	}
	
	@Transactional
	public void actualizarFicha(Ficha ficha) throws FichasServiceException {
		try {
			if (ficha != null) {
				ficha = em.merge(ficha);
			} else {
				throw new FichasServiceException("La ficha no puede ser null");
			}
		} catch (Exception e) {
			throw new FichasServiceException(e);
		}
	}
}
