package fr.imie.emanager;

import fr.imie.emanager.dao.ContactDao;
import fr.imie.emanager.dao.EmployeeDao;
import fr.imie.emanager.dao.MissionDao;
import fr.imie.emanager.dao.TrainingDao;
import fr.imie.emanager.entity.Contact;
import fr.imie.emanager.entity.Employee;
import fr.imie.emanager.entity.Mission;
import fr.imie.emanager.entity.Training;

public class EManager {
	private static final ContactDao contactDao;
	private static final MissionDao missionDao;
	private static final EmployeeDao employeeDao;
	private static final TrainingDao trainingDao;

	static {
		contactDao = new ContactDao();
		missionDao = new MissionDao();
		employeeDao=new EmployeeDao();
		trainingDao=new TrainingDao();
	}

	public static void main(String... args) {
//		System.out.println("*************** ContactDao ***************");
//		testContactDao();

		System.out.println("*************** MissionDao ***************");
		testMissionDao();
	}

	private static void testMissionDao() {
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
		
		System.out.println(e1.toString());
		
		System.out.println("***** Création de l'employé *****");
		employeeDao.create(e1);
		System.out.println(e1.toString());

		System.out.println("***** Sélection de l'employé *****");
		Employee e2 = employeeDao.read(e1.getId());
		System.out.println(e2.toString());
	}

	private static void testContactDao() {
		Contact c1 = new Contact();
		c1.setAddress("5 rue Augustin fresnal");
		c1.setPhone("0123456789");

		System.out.println("Création du contact c1 :");
		contactDao.create(c1);
		System.out.println(c1.toString());

		System.out.println("Récupération du contact c1 :");
		Contact c2 = contactDao.read(c1.getId());
		System.out.println(c2.toString());

		System.out.println("Modification du contact c1");
		c2.setAddress("5 rue Augustin Fresnel");
		contactDao.update(c2);
		Contact c3 = contactDao.read(c2.getId());
		System.out.println(c3.toString());

		System.out.println("Suppression du contact c1");
		contactDao.delete(c3);

		try {
			contactDao.read(c3.getId());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
