package budgettracker.common.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import budgettracker.common.dao.GenericDao;
import budgettracker.common.domain.BaseEntity;


/**
 * Generic common implementation of GenericDao interface.
 * @author Markhed
 *
 * @param <T>
 * @param <ID>
 */
@Transactional
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	static Logger logger = Logger.getLogger(GenericDaoImpl.class);
	
	private Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	public GenericDaoImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	protected EntityManager getEntityManager() { //set from protected for testing
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@Transactional(readOnly=true)
	public T findById(ID id) {
		T entity = (T) getEntityManager().find(getPersistentClass(), id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> findAll() {
		return getEntityManager()
			.createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
			.getResultList();
	}
	
	public T save(T entity) {
		getEntityManager().persist(entity);
		logger.info("persisted entity");
		return entity;
	}
	
	public T update(T entity) {
		T mergedEntity = getEntityManager().merge(entity);
		logger.info("merged entity");
		return mergedEntity;
	}
	
	/* create or save
	public T save(T entity) {
		logger.info("save() invoked");
		if (getEntityManager().contains(entity)) {
			
			return getEntityManager().merge(entity);
		}
		else {
			
			getEntityManager().persist(entity);
			return entity;
		}
	}
	*/
	
	public void delete(T entity) {
		if (BaseEntity.class.isAssignableFrom(persistentClass)) {
			getEntityManager().remove(
					getEntityManager().getReference(entity.getClass(), 
							((BaseEntity)entity).getId()));
		} else {
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}
	}
	
	public void flush() {
		getEntityManager().flush();
	}

	@Override
	public void refresh(T entity) {
		getEntityManager().refresh(entity);
		logger.info("merged entity");
	}
	
	
	
}
