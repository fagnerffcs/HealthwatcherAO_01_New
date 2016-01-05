package br.cin.ufpe.healthwatcher.data.rdb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.data.IComplaintRepository;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;
import br.cin.ufpe.healthwatcher.model.complaint.FoodComplaint;
import br.cin.ufpe.healthwatcher.model.employee.Employee;

public class FoodComplaintRepositoryRDB implements IComplaintRepository {

	private static final long serialVersionUID = 353591488184945392L;

	private static Logger log = LoggerFactory.getLogger(FoodComplaintRepositoryRDB.class);
	private IPersistenceMechanism mp;
	
	public FoodComplaintRepositoryRDB(PersistenceMechanism mp){
		this.mp = mp;
	}

	@Override
	public int insert(Complaint complaint) throws ObjectNotValidException,
			ObjectAlreadyInsertedException, ObjectNotValidException,
			RepositoryException {
		FoodComplaint foodComplaint = (FoodComplaint) complaint;
		log.info("Registrando foodComplaint sobre " + foodComplaint.getDescricao());
		HealthWatcherFacade fachada = null;
		fachada = HealthWatcherFacade.getInstance();
		
		Employee e;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			String login = (String) ec.getSessionMap().get("login");
			if(login!=null){
				e = fachada.searchEmployee(login);
				foodComplaint.setAtendente(e);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EntityManager em;
		try {
			em = (EntityManager) this.mp.getCommunicationChannel();
			em.persist(foodComplaint);
		} catch (PersistenceMechanismException pme) {
			pme.printStackTrace();
		}

		return foodComplaint.getCode();
	}

	@Override
	public void update(Complaint complaint) throws ObjectNotValidException,
			ObjectNotFoundException, ObjectNotValidException,
			RepositoryException {
		EntityManager em;
		try {
			em = (EntityManager) this.mp.getCommunicationChannel();
			em.merge(complaint);
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean exists(int code) throws RepositoryException {
		Complaint c = null;
		try {
			c = search(code);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return c != null;
	}

	@Override
	public void remove(int code) throws ObjectNotFoundException,
			RepositoryException {
		EntityManager em;
		try {
			em = (EntityManager) this.mp.getCommunicationChannel();
			FoodComplaint f = (FoodComplaint) search(code);
			em.remove(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Complaint search(int complaint) throws ObjectNotFoundException,
			RepositoryException {
		EntityManager em;
		try {
			em = (EntityManager) this.mp.getCommunicationChannel();
			return em.find(FoodComplaint.class, complaint);
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IteratorDsk getComplaintList() throws ObjectNotFoundException,
			RepositoryException {
		EntityManager em;
		List<FoodComplaint> lista = new ArrayList<FoodComplaint>();
		try{
			em = (EntityManager) this.mp.getCommunicationChannel();
			lista = em.createNamedQuery("allFoodComplaints").getResultList();
		} catch(Exception e){
			
		}
		
		return new ConcreteIterator(lista);
	}	
	
}
