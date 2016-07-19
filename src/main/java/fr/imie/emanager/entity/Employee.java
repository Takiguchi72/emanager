package fr.imie.emanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Employee.
 */
@Entity
@Table(name = "em_employee")
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2584490562050598917L;

	/** The id. */
	@Id
	@Column(name = "em_employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** The first name. */
	@Column(name = "em_employee_firstname")
	private String firstName;
	
	/** The last name. */
	@Column(name = "em_employee_lastname")
	private String lastName;
	
	/** The salary. */
	@Column(name = "em_employee_salary")
	private float salary;
	
	/** The contact. */
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="em_employee_contact_id")
	private Contact contact;

	/** The missions. */
	@OneToMany(mappedBy = "employee")
	private List<Mission> missions;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="em_employee_training",
			joinColumns = @JoinColumn(name="em_employee_training_employee_id", 
									referencedColumnName="em_employee_id"),
			inverseJoinColumns = @JoinColumn(name="em_employee_training_training_id", 
									referencedColumnName = "em_training_id")
	)
	private List<Training> trainings;
	
	
	
	public Employee() {
		super();
		missions = new ArrayList<Mission>();
		trainings = new ArrayList<Training>();
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder();
		
		strBld.append("Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", salary=" + salary
				+ ", contact=" + contact.toString() + "]\nMissions :\n");
		for (Mission mission : missions) {
			strBld.append("\t" + mission.toString());
		}
		
		strBld.append("\nTrainings (" + trainings.size() + ") :\n");
		for (Training training : trainings) {
			strBld.append("\t" + training.toString());
		}
		
		return strBld.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	
	public void addMission(final Mission pMission) {
		missions.add(pMission);
	}
	
	public void addTraining(final Training pTraining) {
		trainings.add(pTraining);
	}
}
