package com.practice.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="user_det")
@Entity
public class UserDet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6843681979251937382L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name", length = 50)
	private String firstName;
	
	@Column(name="last_name", length = 50)
	private String lastName;
	
	@Column(name="password", length = 50)
	private String password;
	
	@Column(name="user_email", length = 50)
	private String userEmail;
	
	@Column(name="mobile_number", length = 50)
	private String mobileNumber;
	
	@OneToMany(mappedBy="userDet", cascade={CascadeType.ALL}, fetch= FetchType.EAGER)
    private Set<Roles> roles;
	
	@OneToMany(mappedBy="userDet", cascade={CascadeType.ALL}, fetch= FetchType.EAGER)
    private Set<LanguageTense> tenses;
	
	@OneToMany(mappedBy="userDet", cascade={CascadeType.ALL}, fetch= FetchType.EAGER)
    private Set<Vocabulary> vocabulary;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	
}
