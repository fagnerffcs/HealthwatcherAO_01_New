package br.cin.ufpe.healthwatcher.business.employee;


import javax.annotation.PostConstruct;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.cin.ufpe.healthwatcher.data.IEmployeeRepository;
import br.cin.ufpe.healthwatcher.model.employee.Employee;

public class EmployeeRecord {

	private static final long serialVersionUID = -3894035124921216300L;

	private Employee employee = new Employee();
	private IEmployeeRepository employeeRepository;
	
	public EmployeeRecord(IEmployeeRepository rep) {
		this.employeeRepository = rep;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@PostConstruct
	private void init(){
		this.employee = new Employee();
	}
	
	public Employee search(String login) throws ObjectNotFoundException {
		return employeeRepository.search(login);
	}

	public String insert(Employee employee) throws ObjectNotValidException, ObjectAlreadyInsertedException, ObjectNotValidException {
		if (employeeRepository.exists(employee.getLogin())) {
			//TODO:alterar para usar a mensagem de excecao do bundle
			//throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
		} else {
			BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
			this.employee.setPassword(crypt.encode(this.employee.getPassword()));
			this.employeeRepository.insert(employee);
		}
		return "menuEmployee.xhtml?faces-redirect=true";
	}

	public void update(Employee employee) throws ObjectNotValidException, ObjectNotFoundException, ObjectNotValidException {
		employeeRepository.update(employee);
	}
	
}
