package fr.imie.emanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="em_mission")
public class Mission implements Serializable {

	private static final long serialVersionUID = 3970046060319821030L;
	
	@Id
	@Column(name = "em_mission_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="em_mission_start_timestamp")
	private long start;
	
	@Column(name="em_mission_end_timestamp")
	private long end;
	
	@ManyToOne()
	@JoinColumn(name="em_mission_employee_id")
	private Employee employee;

	@Override
	public String toString() {
		return "Mission [id=" + id + ", start=" + start + ", end=" + end
				+ ", employee=" + employee.hashCode() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
