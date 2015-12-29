package br.cin.ufpe.healthwatcher.aspects.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public aspect HWJPAMapping {

	//@Entity mapping
	declare @type : br.cin.ufpe.healthwatcher.model..*.* && 
					!br.cin.ufpe.healthwatcher.model.complaint.Complaint &&
					!br.cin.ufpe.healthwatcher.model.enumTypes.*: @Entity;
	
	//@ManyToOne mapping
	declare @field : ((br.cin.ufpe.healthwatcher.model.address.Address 
					   br.cin.ufpe.healthwatcher.model.complaint.Complaint+.endereco*) ||
					  (br.cin.ufpe.healthwatcher.model.address.Address 
					   br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint.occurenceLocalAddress)
					  ):
	@ManyToOne(cascade=CascadeType.ALL);
	
	//@JoinColumn mapping
	declare @field : ((br.cin.ufpe.healthwatcher.model.address.Address 
			   br.cin.ufpe.healthwatcher.model.complaint.Complaint+.endereco*) ||
			  (br.cin.ufpe.healthwatcher.model.address.Address 
			   br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint.occurenceLocalAddress)
			  ) && 
			  !(br.cin.ufpe.healthwatcher.model.address.Address 
				br.cin.ufpe.healthwatcher.model.complaint.Complaint.enderecoSolicitante):
	@JoinColumn(name = "code");
			  
	declare @field : (br.cin.ufpe.healthwatcher.model.address.Address 
					   br.cin.ufpe.healthwatcher.model.complaint.Complaint.enderecoSolicitante):
	@JoinColumn(name = "enderecoSolicitante_code");
	
	//@Temporal mapping
	declare @field : private java.util.Date br.cin.ufpe.healthwatcher.model..*.* : @Temporal(TemporalType.DATE);
	
	//@Id mapping
	declare @field : private Integer br.cin.ufpe.healthwatcher.model..*.code :
	@Id;
	
	//@GeneratedValue mapping
	declare @field : private Integer code :
	@GeneratedValue;
	
	
}
