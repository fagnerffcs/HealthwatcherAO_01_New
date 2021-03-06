package br.cin.ufpe.healthwatcher.model.employee;

import javax.persistence.Column;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Employee {

	@Column(length = 100)
	private String name;   

	@Column(length = 100)
	private String login;

	@Column(length = 60)
	private String password;
	
	@Column(columnDefinition="boolean default true", nullable=false)
	private boolean enable;

	// Getters and Setters
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public boolean validatePassword(String password){
		BCryptPasswordEncoder crypto = new BCryptPasswordEncoder();
		return crypto.matches(password, this.password);
	}

}
