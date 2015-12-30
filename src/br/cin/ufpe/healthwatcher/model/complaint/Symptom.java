package br.cin.ufpe.healthwatcher.model.complaint;

import java.io.Serializable;

import javax.persistence.Column;

public class Symptom implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	private Integer code;
	
	@Column(length = 100)
	private String description;


	// Getters and Setters
	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
