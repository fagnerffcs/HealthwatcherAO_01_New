package br.cin.ufpe.healthwatcher.business.complaint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import lib.exceptions.ObjectNotFoundException;
import lib.util.IteratorDsk;
import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;
import br.cin.ufpe.healthwatcher.model.complaint.FoodComplaint;
import br.cin.ufpe.healthwatcher.model.complaint.SpecialComplaint;
import br.cin.ufpe.healthwatcher.model.enumTypes.Situacao;

public class SearchComplaintRecord {

	private static final long serialVersionUID = -6887424307646650506L;
	
	private int complaintCode;
	private String complaintKind;
	private Complaint complaint;
	private FoodComplaint foodComplaint;
	private AnimalComplaint animalComplaint;
	private SpecialComplaint specialComplaint;
	
	private List<Complaint> complaints;
	private HealthWatcherFacade facade;
	
	@PostConstruct
	public void init(){
		this.complaint = new FoodComplaint();
	}
	
	
	public int getComplaintCode() {
		return complaintCode;
	}

	public void setComplaintCode(int complaintCode) {
		this.complaintCode = complaintCode;
	}

	public FoodComplaint getFoodComplaint() {
		return foodComplaint;
	}

	public void setFoodComplaint(FoodComplaint foodComplaint) {
		this.foodComplaint = foodComplaint;
	}

	public AnimalComplaint getAnimalComplaint() {
		return animalComplaint;
	}

	public void setAnimalComplaint(AnimalComplaint animalComplaint) {
		this.animalComplaint = animalComplaint;
	}

	public SpecialComplaint getSpecialComplaint() {
		return specialComplaint;
	}

	public void setSpecialComplaint(SpecialComplaint specialComplaint) {
		this.specialComplaint = specialComplaint;
	}

	public List<Complaint> getComplaints() {
		this.complaints = new ArrayList<Complaint>();
		try{
			if(facade==null){
				facade = HealthWatcherFacade.getInstance();
			}
			IteratorDsk it = facade.getComplaintList();
			while(it.hasNext()){
				Complaint c = (Complaint) it.next();
				this.complaints.add(c);
			}
		} catch (Exception e){
			
		}
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	
	public String search(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			if(facade==null){
				facade = HealthWatcherFacade.getInstance();
			}
			this.complaint = facade.searchComplaint(complaintCode);
			if(this.complaint!=null) {
				facesContext.getExternalContext().getFlash().put("complaint", complaint.getCode());
			}
			return "searchComplaintData?faces-redirect=true";			
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

	public Complaint getComplaint() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(complaint==null){
			Integer code = (Integer) facesContext.getExternalContext().getFlash().get("complaint");
			try {
				if(facade==null){
					facade = HealthWatcherFacade.getInstance();
				}
				if(code!=null){
					this.complaint = facade.searchComplaint(code);
				}
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(validFoodComplaint()){
			this.foodComplaint = (FoodComplaint) complaint;
			this.complaintKind = "Food";
		} else if(validAnimalComplaint()){
			this.animalComplaint = (AnimalComplaint) complaint;
			this.complaintKind = "Animal";
		} else if(validSpecialComplaint()) {
			this.specialComplaint = (SpecialComplaint) complaint;
			this.complaintKind = "Special";
		}
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}
	
	public String updateSearchComplaint(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			if(facade==null){
				facade = HealthWatcherFacade.getInstance();
			}
			facesContext.getExternalContext().getFlash().put("complaintCode", complaint.getCode());
			return "updateSearchComplaint?faces-redirect=true";			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";	
	}
	
	public String updateComplaint(){
		try {
			this.complaint.setSituacao(Situacao.CLOSED);
			this.complaint.setDataParecer(new Date());
			facade.updateComplaint(this.complaint);
			return "updateSearchComplaintData?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean validFoodComplaint(){
		return this.complaint instanceof FoodComplaint ? true : false;
	}
	
	public boolean validSpecialComplaint() {
		return this.complaint instanceof SpecialComplaint ? true : false;
	}

	public boolean validAnimalComplaint() {
		return this.complaint instanceof AnimalComplaint ? true : false;
	}

	public String getComplaintKind() {
		return complaintKind;
	}

	public void setComplaintKind(String complaintKind) {
		this.complaintKind = complaintKind;
	}	

}
