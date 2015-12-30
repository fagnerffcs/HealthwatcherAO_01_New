package br.cin.ufpe.healthwatcher.business;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.UpdateEntryException;
import lib.util.IteratorDsk;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;
import br.cin.ufpe.healthwatcher.model.complaint.DiseaseType;
import br.cin.ufpe.healthwatcher.model.employee.Employee;
import br.cin.ufpe.healthwatcher.model.healthguide.HealthUnit;

public interface IFacade {
	public void updateComplaint(Complaint q) throws ObjectNotFoundException,
			ObjectNotValidException;

	public IteratorDsk searchSpecialitiesByHealthUnit(int code)
			throws ObjectNotFoundException;

	public Complaint searchComplaint(int code) throws ObjectNotFoundException;

	public DiseaseType searchDiseaseType(int code)
			throws ObjectNotFoundException;

	public IteratorDsk searchHealthUnitsBySpeciality(int code)
			throws ObjectNotFoundException;

	public IteratorDsk getSpecialityList() throws ObjectNotFoundException;

	public IteratorDsk getDiseaseTypeList() throws ObjectNotFoundException;

	public IteratorDsk getHealthUnitList() throws ObjectNotFoundException;

	public IteratorDsk getPartialHealthUnitList()
			throws ObjectNotFoundException;

	public int insertComplaint(Complaint complaint)
			throws ObjectAlreadyInsertedException, ObjectNotValidException;

	public void updateHealthUnit(HealthUnit unit)
			throws ObjectNotFoundException, ObjectNotValidException;

	public IteratorDsk getComplaintList() throws ObjectNotFoundException;

	public void insert(Employee e) throws ObjectAlreadyInsertedException,
			ObjectNotValidException;

	public void updateEmployee(Employee e) throws ObjectNotFoundException,
			ObjectNotValidException, UpdateEntryException;

	public Employee searchEmployee(String login)
			throws ObjectNotFoundException, ObjectNotValidException,
			UpdateEntryException;

	public HealthUnit searchHealthUnit(int healthUnitCode)
			throws ObjectNotFoundException;

}
