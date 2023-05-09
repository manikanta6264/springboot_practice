package com.practice.models;

import java.io.Serializable;

public class LanguageTenseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3155315784060127218L;

	private int tenseId;

	private String tenseName;

	private String equation;

	private String description;

	private String createdDate;

	private String modifiedDate;
	
	private String languageName;

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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	

}
