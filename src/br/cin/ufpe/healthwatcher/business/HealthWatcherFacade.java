package br.cin.ufpe.healthwatcher.business;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.util.IteratorDsk;
import br.cin.ufpe.healthwatcher.business.complaint.ComplaintRecord;
import br.cin.ufpe.healthwatcher.business.complaint.DiseaseRecord;
import br.cin.ufpe.healthwatcher.business.employee.EmployeeRecord;
import br.cin.ufpe.healthwatcher.business.healthguide.HealthUnitRecord;
import br.cin.ufpe.healthwatcher.business.healthguide.MedicalSpecialtyRecord;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;
import br.cin.ufpe.healthwatcher.model.complaint.DiseaseType;
import br.cin.ufpe.healthwatcher.model.employee.Employee;
import br.cin.ufpe.healthwatcher.model.healthguide.HealthUnit;

@ManagedBean(name="facade")
@ApplicationScoped
public class HealthWatcherFacade implements IFacade {
	
	private static HealthWatcherFacade singleton; //padrao singleton
	
	private ComplaintRecord complaintRecord;

	private HealthUnitRecord healthUnitRecord;

	private MedicalSpecialtyRecord specialityRecord;

	private DiseaseRecord diseaseRecord;

	private EmployeeRecord employeeRecord;	
	
	private HealthWatcherFacade(){
		this.complaintRecord = new ComplaintRecord(null);
		this.healthUnitRecord = new HealthUnitRecord(null);
		this.specialityRecord = new MedicalSpecialtyRecord(null);
		this.diseaseRecord = new DiseaseRecord(null);
		this.employeeRecord = new EmployeeRecord(null);		
	}
	
	public synchronized static HealthWatcherFacade getInstance() {
		if (singleton == null) {
			singleton = new HealthWatcherFacade();
		}
		return singleton;
	}
			
	public void updateHealthUnit(HealthUnit unit) throws ObjectNotFoundException, ObjectNotValidException {
		healthUnitRecord.update(unit);
	}

	public void updateComplaint(Complaint complaint) throws ObjectNotFoundException, ObjectNotValidException {
		complaintRecord.update(complaint);
	}

	public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException {
		return healthUnitRecord.searchSpecialitiesByHealthUnit(code);
	}

	public Complaint searchComplaint(int code) throws ObjectNotFoundException {
		return complaintRecord.searchComplaint(code);
	}

	public DiseaseType searchDiseaseType(int code) throws ObjectNotFoundException {
		return diseaseRecord.searchDiseaseType(code);
	}

	public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException {
		return healthUnitRecord.searchHealthUnitsBySpeciality(code);
	}

	public IteratorDsk getSpecialityList() throws ObjectNotFoundException {
		return specialityRecord.getListaEspecialidade();
	}

	public IteratorDsk getDiseaseTypeList() throws ObjectNotFoundException {
		return diseaseRecord.getDiseaseTypeList();
	}

	public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException {
		return healthUnitRecord.search(healthUnitCode);
	}

	public IteratorDsk getHealthUnitList() throws ObjectNotFoundException {
		return healthUnitRecord.getHealthUnitList();
	}

	public IteratorDsk getPartialHealthUnitList() throws ObjectNotFoundException {
		return healthUnitRecord.getPartialHealthUnitList();
	}

	public void insert(Employee employee) throws ObjectAlreadyInsertedException,
			ObjectNotValidException {
		employeeRecord.insert(employee);
	}

	public int insertComplaint(Complaint complaint) throws ObjectAlreadyInsertedException, ObjectNotValidException {
		return complaintRecord.insert(complaint);
	}

	public Employee searchEmployee(String login) throws ObjectNotFoundException {
		return employeeRecord.search(login);
	}

	public IteratorDsk getComplaintList() throws ObjectNotFoundException {
		return complaintRecord.getComplaintList();
	}

	public void updateEmployee(Employee employee) throws ObjectNotFoundException,
			ObjectNotValidException {
		employeeRecord.update(employee);
	}
	
}
