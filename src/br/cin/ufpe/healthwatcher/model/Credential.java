package br.cin.ufpe.healthwatcher.model;

import br.cin.ufpe.healthwatcher.model.employee.Employee;

public class Credential {
	
	private static final long serialVersionUID = -7292496503968462234L;

	private Integer code;
	
	private String role;
	
	private Employee employee;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
