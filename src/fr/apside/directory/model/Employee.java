package fr.apside.directory.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee extends GenericEntity {

	
	@Transient
	private static final long serialVersionUID = 4939879422398106054L;

	// User
	private String name;
	private String password;
	
	// Employee
	private String email;
	private String firstname;
	private String lastname;
	private String title;
	private String client;
	private String officePhone;
	private String cellPhone;
	private Date birthDate;
	private String picture;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Employee [birthDate=" + birthDate + ", cellPhone=" + cellPhone
				+ ", client=" + client + ", email=" + email + ", firstname="
				+ firstname + ", lastname=" + lastname + ", name=" + name
				+ ", officePhone=" + officePhone + ", password=" + password
				+ ", picture=" + picture + ", title=" + title + "]";
	}
	
	
	
}
