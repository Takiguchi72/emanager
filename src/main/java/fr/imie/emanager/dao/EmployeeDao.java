package fr.imie.emanager.dao;

import fr.imie.emanager.entity.Employee;

public class EmployeeDao extends AbstractDao<Employee> {
	
	public EmployeeDao() {
		
	}
	
	
	@Override
	public Employee read(long pId) {
		return em.find(Employee.class, pId);
	}
	
	
	@Override
	public void create(Employee pEmployee) {
		em.getTransaction().begin();
		em.persist(pEmployee);
		em.flush(); // optionnel
		em.getTransaction().commit();
	}
	
	
	@Override
	public void update(Employee pEmployee) {
//		Contact update = read(pContact.getId());
//		em.getTransaction().begin();
//		update.setAddress(pContact.getAddress());
//		update.setPhone(pContact.getPhone());
//		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(pEmployee);
		em.getTransaction().commit();
	}
	
	
	@Override
	public void delete(Employee pEmployee) {
		em.getTransaction().begin();
		em.remove(pEmployee);
		em.getTransaction().commit();
	}
}
