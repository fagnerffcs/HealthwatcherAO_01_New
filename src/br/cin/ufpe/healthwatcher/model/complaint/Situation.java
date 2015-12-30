package br.cin.ufpe.healthwatcher.model.complaint;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

public class Situation implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	private Integer code;

	@Column(length = 100)
	private String description;

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
