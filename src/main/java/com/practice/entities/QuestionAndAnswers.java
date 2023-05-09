package com.practice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name="question_ans")
@Entity
public class QuestionAndAnswers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question")
	private String question;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_type")
	private String fileType;
	
	 @Lob
	 @Column(name="answer")
	    private byte[] answer;

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

		public byte[] getAnswer() {
			return answer;
		}

		public void setAnswer(byte[] answer) {
			this.answer = answer;
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

		public QuestionAndAnswers() {
		}

		public QuestionAndAnswers(String question, String fileName, String fileType, byte[] answer) {
			this.question = question;
			this.fileName = fileName;
			this.fileType = fileType;
			this.answer = answer;
		}


	    
	
}
