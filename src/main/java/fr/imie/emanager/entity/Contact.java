package fr.imie.emanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The entity Contact.
 */
@Entity
@Table(name="em_contact")
public class Contact implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7053367081497885012L;
	
	/** The id. */
	@Id
	@Column(name = "em_contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** The address. */
	@Column(name ="em_contact_address", length = 255)
	private String address;
	
	/** The phone. */
	@Column(name="em_contact_phone")
	private String phone;

	@Override
	public String toString() {
		return "Contact [id=" + id + ", address=" + address + ", phone="
				+ phone + "]";
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
