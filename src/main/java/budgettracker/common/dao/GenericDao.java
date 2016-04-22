package budgettracker.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * The generic DAO interface
 * @author Markhed
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDao<T, ID extends Serializable> {
	T save(T entity);
	T update(T entity);
	void refresh(T entity);
	void delete(T entity);
	T findById(ID id);
	List<T> findAll();
	void flush();
}
