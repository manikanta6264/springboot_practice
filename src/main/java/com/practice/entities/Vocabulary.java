package com.practice.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="vocabulary")
@Entity
public class Vocabulary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vocabulary_id")
	private int tenseId;
	
	@Column(name="vocabulary_name")
	private String vocabularyName;
	
	@Column(name="v1")
	private String v1;
	
	@Column(name="v2")
	private String v2;
	
	@Column(name="v3")
	private String v3;
	
	@Column(name="v4")
	private String v4;
	
	@Column(name="v5")
	private String v5;
	
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

	public String getVocabularyName() {
		return vocabularyName;
	}

	public void setVocabularyName(String vocabularyName) {
		this.vocabularyName = vocabularyName;
	}

	public String getV1() {
		return v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}

	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}

	public String getV3() {
		return v3;
	}

	public void setV3(String v3) {
		this.v3 = v3;
	}

	public String getV4() {
		return v4;
	}

	public void setV4(String v4) {
		this.v4 = v4;
	}

	public String getV5() {
		return v5;
	}

	public void setV5(String v5) {
		this.v5 = v5;
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
	
	
}
