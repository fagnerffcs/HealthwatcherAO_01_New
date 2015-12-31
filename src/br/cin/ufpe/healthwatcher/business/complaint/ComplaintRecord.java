package br.cin.ufpe.healthwatcher.business.complaint;

import javax.faces.context.FacesContext;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import br.cin.ufpe.healthwatcher.data.IComplaintRepository;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;

public class ComplaintRecord {

	private static final long serialVersionUID = -6887424307646650506L;
	private IComplaintRepository complaintRep;
	private Complaint complaint;

	public ComplaintRecord(IComplaintRepository rep) {
		this.complaintRep = rep;
	}

	public Complaint searchComplaint(int code) throws ObjectNotFoundException {
		return complaintRep.search(code);
	}

	public int insert(Complaint complaint)
			throws ObjectAlreadyInsertedException, ObjectNotValidException {
		if (complaint.getCode()!=null && complaintRep.exists(complaint.getCode())) {
			throw new ObjectAlreadyInsertedException(
					"Complaint code already registered");
		}
		return complaintRep.insert(complaint);
	}

	public void update(Complaint q) throws ObjectNotFoundException,
			ObjectNotValidException {
		complaintRep.update(q);
	}

	public IteratorDsk getComplaintList() throws ObjectNotFoundException {
		return complaintRep.getComplaintList();

	}

	public Complaint getComplaint() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Integer code = (Integer) facesContext.getExternalContext().getFlash()
				.get("complaintCode");
		try {
			this.complaint = this.complaintRep.search(code);
		} catch (ObjectNotFoundException | RepositoryException e) {
			e.printStackTrace();
		}
		return complaint;
	}

}
