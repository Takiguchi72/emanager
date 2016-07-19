package fr.imie.emanger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.imie.emanager.dao.ContactDao;
import fr.imie.emanager.dao.EmployeeDao;
import fr.imie.emanager.dao.MissionDao;
import fr.imie.emanager.dao.TrainingDao;
import fr.imie.emanager.entity.Contact;
import fr.imie.emanager.entity.Employee;
import fr.imie.emanager.entity.Mission;
import fr.imie.emanager.entity.Training;

public class EManagerTest {
	private ContactDao contactDao;
	private MissionDao missionDao;
	private EmployeeDao employeeDao;
	private TrainingDao trainingDao;

	@Before
	public void init() {
		contactDao = new ContactDao();
		missionDao = new MissionDao();
		employeeDao = new EmployeeDao();
		trainingDao = new TrainingDao();
	}

	@Test
	public void testEmployeDao() {
		Employee e1 = new Employee();
		e1.setFirstName("Titi");
		e1.setLastName("TOTO");
		e1.setSalary(1234.56F);

		Contact c1 = new Contact();
		c1.setAddress("5 rue Augustin Fresnel");
		c1.setPhone("0123456789");
		e1.setContact(c1);

		Mission m1 = new Mission();
		m1.setStart(0L);
		m1.setEnd(10000L);
		m1.setEmployee(e1);
		e1.addMission(m1);

		Training t1 = new Training();
		t1.setTheme("Theme");
		t1.setDuration(12346);
		t1.addEmployee(e1);
		e1.addTraining(t1);

		printHeader("Création de l'employé");
		employeeDao.create(e1);
		System.out.println(e1.toString());

		printHeader("Sélection de l'employé");
		Employee e2 = employeeDao.read(e1.getId());
		System.out.println(e2.toString());
		
		assertEmployeeEquals(e1, e2);
		
		printHeader("Modification de l'employé");
		e1.setFirstName("AnOtherFirstName");
		e1.setLastName("AnOtherLastName");
		employeeDao.update(e1);
		
		assertEmployeeEquals(e1, employeeDao.read(e1.getId()));
		
		printHeader("Suppression de l'employé");
		final long id = e1.getId();
		employeeDao.delete(e1);
		
		assertNull(employeeDao.read(id));
	}
	
	@Test
	public void testContactDao() {
		Contact c1 = new Contact();
		c1.setAddress("5 rue Augustin fresnal");
		c1.setPhone("0123456789");

		printHeader("Création du contact c1 :");
		contactDao.create(c1);
		System.out.println(c1.toString());

		printHeader("Récupération du contact c1 :");
		Contact c2 = contactDao.read(c1.getId());
		assertContactEquals(c1, c2);

		printHeader("Modification du contact c1");
		c2.setAddress("5 rue Augustin Fresnel");
		contactDao.update(c2);
		Contact c3 = contactDao.read(c2.getId());
		assertContactEquals(c2, c3);

		printHeader("Suppression du contact c1");
		final long id = c3.getId();
		contactDao.delete(c3);

		assertNull(contactDao.read(id));
	}
	
	private void assertEmployeeEquals(final Employee pE1, final Employee pE2) {
		assertEquals(pE1.getFirstName(), pE2.getFirstName());
		assertEquals(pE1.getLastName(), pE2.getLastName());
		assertTrue(pE1.getSalary() == pE2.getSalary());
		assertEquals(pE1.getContact().toString(), pE2.getContact().toString());
		assertTrue(pE1.getMissions().size() == pE2.getMissions().size());
		assertTrue(pE1.getTrainings().size() == pE2.getTrainings().size());
	}
	
	private void assertContactEquals(final Contact pC1, final Contact pC2) {
		assertEquals(pC1.getAddress(), pC2.getAddress());
		assertEquals(pC1.getPhone(), pC2.getPhone());
	}

	private void printHeader(final String pText) {
		System.out.println("\n**************************************************");
		System.out.println("***** " + pText + " *****");
		System.out.println("**************************************************");
	}
}
