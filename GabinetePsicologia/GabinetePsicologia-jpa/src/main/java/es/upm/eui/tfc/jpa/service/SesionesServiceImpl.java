package es.upm.eui.tfc.jpa.service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upm.eui.tfc.jpa.model.SesionImpl;
import es.upm.eui.tfc.model.Sesion;
import es.upm.eui.tfc.service.SesionesService;
import es.upm.eui.tfc.service.error.SesionesServiceException;

@Service(SesionesService.SERVICE_NAME)
public class SesionesServiceImpl implements SesionesService {

	private static final long serialVersionUID = -16L;

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Implementacion JPA para registrar una nueva sesion.
	 * 
	 * @param sesion
	 * @throws SesionesServiceException si hay algun error en el acceso a base de datos o el parametro de entrada no es valido.
	 */
	@Transactional
	public Sesion registrarSesion(Sesion sesion) throws SesionesServiceException {
		try {
			if (sesion != null && !em.contains(sesion)) {
				em.persist(sesion);
			} else {
				throw new SesionesServiceException("La sesion no puede ser null o sesion ya existe");
			}
		} catch (Exception e) {
			throw new SesionesServiceException(e);
		}
		return sesion;
	}

	@Transactional
	public void borrarSesion(int idSesion) throws SesionesServiceException {
		SesionImpl sesion = null;
		try {
			if (idSesion >= 0) {
				sesion = new SesionImpl();
				sesion.setIdSesion(idSesion);
				sesion = em.merge(sesion);
				em.remove(sesion);
			} else {
				throw new SesionesServiceException("El id SesionImpl no puede ser menor que cero");
			}
		} catch (Exception e) {
			throw new SesionesServiceException(e);
		}
		
	}
	
	@Transactional
	public Sesion recuperarSesion(int idSesion) throws SesionesServiceException {
		Sesion sesion = null;
		try {	
			if (idSesion >= 0) {
				sesion = em.find(SesionImpl.class, idSesion);
			} else {
				throw new SesionesServiceException("El id de sesion no puede ser menor que cero");
			}
		} catch (Exception e) {
			throw new SesionesServiceException(e);
		}
		return sesion;
		
	}
	
	@Transactional
	public void actualizarSesion(Sesion sesion) throws SesionesServiceException {
		try {
			if (sesion != null) {
				sesion = em.merge(sesion);
			} else {
				throw new SesionesServiceException("La sesion no puede ser null");
			}
		} catch (Exception e) {
			throw new SesionesServiceException(e);
		}
	}
	
	
}
