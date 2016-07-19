package fr.imie.emanager.dao;

import fr.imie.emanager.entity.Contact;

/**
 * The Class ContactDao.
 */
public class ContactDao extends AbstractDao<Contact> {
	/**
	 * Instantiates a new contact dao.
	 */
	public ContactDao() {
		
	}
	
	/**
	 * Find a contact.
	 *
	 * @param pId the contact id
	 * @return the contact found
	 */
	@Override
	public Contact read(long pId) {
		return em.find(Contact.class, pId);
	}
	
	/**
	 * Creates a new contact.
	 *
	 * @param pContact the new contact
	 */
	@Override
	public void create(Contact pContact) {
		em.getTransaction().begin();
		em.persist(pContact);
		em.flush(); // optionnel
		em.getTransaction().commit();
	}
	
	/**
	 * Update.
	 *
	 * @param pContact the contact
	 */
	@Override
	public void update(Contact pContact) {
//		Contact update = read(pContact.getId());
//		em.getTransaction().begin();
//		update.setAddress(pContact.getAddress());
//		update.setPhone(pContact.getPhone());
//		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(pContact);
		em.getTransaction().commit();
	}
	
	/**
	 * Delete.
	 *
	 * @param pContact the contact
	 */
	@Override
	public void delete(Contact pContact) {
		em.getTransaction().begin();
		em.remove(pContact);
		em.getTransaction().commit();
	}
}
