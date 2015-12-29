package br.cin.ufpe.healthwatcher.aspects.persistence;

import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import br.cin.ufpe.healthwatcher.Constants;
import br.cin.ufpe.healthwatcher.business.complaint.ComplaintRecord;
import br.cin.ufpe.healthwatcher.business.complaint.DiseaseRecord;
import br.cin.ufpe.healthwatcher.business.complaint.SearchComplaintRecord;
import br.cin.ufpe.healthwatcher.business.employee.EmployeeLogin;
import br.cin.ufpe.healthwatcher.business.employee.EmployeeRecord;
import br.cin.ufpe.healthwatcher.business.healthguide.HealthUnitRecord;
import br.cin.ufpe.healthwatcher.business.healthguide.MedicalSpecialtyRecord;
import br.cin.ufpe.healthwatcher.data.IComplaintRepository;
import br.cin.ufpe.healthwatcher.data.IDiseaseRepository;
import br.cin.ufpe.healthwatcher.data.IEmployeeRepository;
import br.cin.ufpe.healthwatcher.data.IHealthUnitRepository;
import br.cin.ufpe.healthwatcher.data.ISpecialityRepository;
import br.cin.ufpe.healthwatcher.data.mem.ComplaintRepositoryArray;
import br.cin.ufpe.healthwatcher.data.mem.DiseaseTypeRepositoryArray;
import br.cin.ufpe.healthwatcher.data.mem.EmployeeRepositoryArray;
import br.cin.ufpe.healthwatcher.data.mem.HealthUnitRepositoryArray;
import br.cin.ufpe.healthwatcher.data.mem.SpecialityRepositoryArray;
import br.cin.ufpe.healthwatcher.data.rdb.ComplaintRepositoryRDB;
import br.cin.ufpe.healthwatcher.data.rdb.DiseaseTypeRepositoryRDB;
import br.cin.ufpe.healthwatcher.data.rdb.EmployeeRepositoryRDB;
import br.cin.ufpe.healthwatcher.data.rdb.HealthUnitRepositoryRDB;
import br.cin.ufpe.healthwatcher.data.rdb.SpecialityRepositoryRDB;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;

public aspect HWDataCollection {
	
	Object around(): call(*Record.new(..)) &&	! within(HWDataCollection+) {
		return getSystemRecord(thisJoinPoint.getSignature().getDeclaringType());
	}	

    declare soft: RepositoryException : execution(* *Record.*(..));
    
    //TODO:rever como todas as classes dentro do pacote model podem imlementar Serializable
    declare parents : br.cin.ufpe.healthwatcher.model..* implements java.io.Serializable;
    
    //TODO: injetar aspecto para implementar equals e hashcode nos objetos anotados pela annotion @Entity
    
	@SuppressWarnings("rawtypes")
	protected Object getSystemRecord(Class type) {
		if (type.equals(ComplaintRecord.class)) {
			return new ComplaintRecord(getComplaintRepository());
		} else  if (type.equals(HealthUnitRecord.class)) {
			return new HealthUnitRecord(getHealthUnitRepository());
		} else  if (type.equals(MedicalSpecialtyRecord.class)) {
			return new MedicalSpecialtyRecord(getSpecialityRepository());
		} else  if (type.equals(EmployeeRecord.class)) {
			return new EmployeeRecord(getEmployeeRepository());
		}else if(type.equals(DiseaseRecord.class)){
			return new DiseaseRecord(getDiseaseRepository());
		} else if(type.equals(EmployeeLogin.class)){
			return new EmployeeLogin();
		} else if(type.equals(SearchComplaintRecord.class)){
			return new SearchComplaintRecord();
		}
		return null;
	}    
    
	// Methods to create repository for each class type. The repository
	// created depend if the system in persistent or not
	protected IComplaintRepository getComplaintRepository() {
		if (Constants.isPersistent()) {
			return new ComplaintRepositoryRDB((PersistenceMechanism) getPm());
		}
    	return new ComplaintRepositoryArray();
    }
    
    protected ISpecialityRepository getSpecialityRepository() {
    	if (Constants.isPersistent()) {
			return new SpecialityRepositoryRDB((PersistenceMechanism) getPm());
		}
    	return new SpecialityRepositoryArray();
    }
    
    protected IHealthUnitRepository getHealthUnitRepository() {
    	if (Constants.isPersistent()) {
			return new HealthUnitRepositoryRDB((PersistenceMechanism) getPm());
		}
    	return new HealthUnitRepositoryArray();
    }
    
	protected IDiseaseRepository getDiseaseRepository()  {
		if (Constants.isPersistent()) {
			return new DiseaseTypeRepositoryRDB((PersistenceMechanism) getPm());
		}
    	return new DiseaseTypeRepositoryArray();
    }
    
 	protected IEmployeeRepository getEmployeeRepository()  {
 		if (Constants.isPersistent()) {
			return new EmployeeRepositoryRDB(getPm());
		}
    	return new EmployeeRepositoryArray();
    }
 	
 	/**
 	 * Returns the persistence mechanism in use
 	 */
 	protected IPersistenceMechanism getPm() {
 		return HWPersistence.aspectOf().getPm();
 	}

 	
	
}


