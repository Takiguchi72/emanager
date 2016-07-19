package fr.imie.emanager.dao;

/**
 * The Interface Dao.
 *
 * @param <T> the generic type
 */
public interface Dao<T> {
	
	/**
	 * Creates the.
	 *
	 * @param pObject the object
	 */
	void create(final T pObject);
	
	/**
	 * Read.
	 *
	 * @param pId the id
	 * @return the t
	 */
	T read(final long pId);
	
	/**
	 * Update.
	 *
	 * @param pObject the object
	 */
	void update(final T pObject);
	
	/**
	 * Delete.
	 *
	 * @param pObject the object
	 */
	void delete(final T pObject);
}
