package com.practice.models;

import java.io.Serializable;

public class QuestonsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private int questionId;
	private String question;
	private String fileName;
	private String fileType;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	 
	
}
