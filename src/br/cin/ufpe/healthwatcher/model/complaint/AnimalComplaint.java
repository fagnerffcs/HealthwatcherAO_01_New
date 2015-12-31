package br.cin.ufpe.healthwatcher.model.complaint;

import java.util.Date;

import javax.persistence.Column;

import br.cin.ufpe.healthwatcher.model.address.Address;

public class AnimalComplaint extends Complaint {
	private static final long serialVersionUID = 1L;
	
	private Short animalQuantity;
	
	private Date inconvenienceDate;
	
	@Column(length = 100)
	private String animal;
	
	private Address occurenceLocalAddress;
	
	public AnimalComplaint() {
		super();
	}   
	public Short getAnimalQuantity() {
		return this.animalQuantity;
	}

	public void setAnimalQuantity(Short animalQuantity) {
		this.animalQuantity = animalQuantity;
	}   
	public Date getInconvenienceDate() {
		return this.inconvenienceDate;
	}

	public void setInconvenienceDate(Date inconvenienceDate) {
		this.inconvenienceDate = inconvenienceDate;
	}   
	public String getAnimal() {
		return this.animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}   
	public Address getOccurenceLocalAddress() {
		return this.occurenceLocalAddress;
	}

	public void setOccurenceLocalAddress(Address occurenceLocalAddress) {
		this.occurenceLocalAddress = occurenceLocalAddress;
	}
   
}
