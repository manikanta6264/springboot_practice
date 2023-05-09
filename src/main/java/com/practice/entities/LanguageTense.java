package com.practice.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="language_tenses")
@Entity
public class LanguageTense implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -256345774718434328L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tense_id")
	private int tenseId;
	
	@Column(name="tense_name")
	private String tenseName;
	
	@Column(name="language_name")
	private String languageName;
	
	@Column(name="equation")
	private String equation;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserDet userDet;

	public int getTenseId() {
		return tenseId;
	}

	public void setTenseId(int tenseId) {
		this.tenseId = tenseId;
	}

	public String getTenseName() {
		return tenseName;
	}

	public void setTenseName(String tenseName) {
		this.tenseName = tenseName;
	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public UserDet getUserDet() {
		return userDet;
	}

	public void setUserDet(UserDet userDet) {
		this.userDet = userDet;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	
}
