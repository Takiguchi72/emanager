package fr.imie.emanager.dao;

import fr.imie.emanager.entity.Mission;

public class MissionDao extends AbstractDao<Mission> {
	/**
	 * Instantiates a new contact dao.
	 */
	public MissionDao() {
		
	}
	
	/**
	 * Find a contact.
	 *
	 * @param pId the contact id
	 * @return the contact found
	 */
	@Override
	public Mission read(long pId) {
		return em.find(Mission.class, pId);
	}
	
	/**
	 * Creates a new contact.
	 *
	 * @param pContact the new contact
	 */
	@Override
	public void create(Mission pMission) {
		em.getTransaction().begin();
		em.persist(pMission);
		em.flush(); // optionnel
		em.getTransaction().commit();
	}
	
	/**
	 * Update.
	 *
	 * @param pContact the contact
	 */
	@Override
	public void update(Mission pMission) {
//		Contact update = read(pContact.getId());
//		em.getTransaction().begin();
//		update.setAddress(pContact.getAddress());
//		update.setPhone(pContact.getPhone());
//		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(pMission);
		em.getTransaction().commit();
	}
	
	/**
	 * Delete.
	 *
	 * @param pContact the contact
	 */
	@Override
	public void delete(Mission pMission) {
		em.getTransaction().begin();
		em.remove(pMission);
		em.getTransaction().commit();
	}
}
