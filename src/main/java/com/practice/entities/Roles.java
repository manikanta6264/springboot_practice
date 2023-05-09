package com.practice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Table(name="roles")
@Entity
public class Roles implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7507126128863219765L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int role_id;
	
	@Column(name="user_name", length = 50)
	private String userName;
	
	@Column(name="role", length = 15)
	private String role;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserDet userDet;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDet getUserDet() {
		return userDet;
	}

	public void setUserDet(UserDet userDet) {
		this.userDet = userDet;
	}

	@Override
	public String getAuthority() {
		return role;
	}
	
	
}
