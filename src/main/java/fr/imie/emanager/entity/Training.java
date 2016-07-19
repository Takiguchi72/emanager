package fr.imie.emanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table(name="em_training")
public class Training  implements Serializable {

	private static final long serialVersionUID = -687218812406456508L;
	
	/** The id. */
	@Id
	@Column(name = "em_training_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "em_training_theme")
	private String theme;
	
	@Column(name = "em_training_duration")
	private int duration;
	
	@ManyToMany(mappedBy = "trainings")
	private List<Employee> employees;

	
	
	public Training() {
		super();
		employees = new ArrayList<Employee>();
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", theme=" + theme + ", duration="
				+ duration + ", employees=" + employees.hashCode() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(final Employee pEmployee) {
		employees.add(pEmployee);
	}
}
