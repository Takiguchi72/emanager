package fr.imie.emanager.dao;

import fr.imie.emanager.entity.Training;

public class TrainingDao extends AbstractDao<Training> {
	
	public TrainingDao() {
		
	}
	
	
	@Override
	public Training read(long pId) {
		return em.find(Training.class, pId);
	}
	
	
	@Override
	public void create(Training pTraining) {
		em.getTransaction().begin();
		em.persist(pTraining);
		em.flush(); // optionnel
		em.getTransaction().commit();
	}
	
	
	@Override
	public void update(Training pTraining) {
//		Contact update = read(pContact.getId());
//		em.getTransaction().begin();
//		update.setAddress(pContact.getAddress());
//		update.setPhone(pContact.getPhone());
//		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(pTraining);
		em.getTransaction().commit();
	}
	
	
	@Override
	public void delete(Training pTraining) {
		em.getTransaction().begin();
		em.remove(pTraining);
		em.getTransaction().commit();
	}
}
