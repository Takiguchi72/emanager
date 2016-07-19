package fr.imie.emanager.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao<T> implements Dao<T> {
	/** The emf. */
	protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("emanager");
	
	/** The em. */
	protected final EntityManager em = emf.createEntityManager();
}
