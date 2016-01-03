package br.cin.ufpe.healthwatcher.aspects.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public aspect HWJPAMapping {

	//@Entity mapping
	declare @type : (br.cin.ufpe.healthwatcher.model..*.* ||
					 br.cin.ufpe.healthwatcher.model.*) && 
					!br.cin.ufpe.healthwatcher.model.complaint.Complaint &&
					!br.cin.ufpe.healthwatcher.model.enumTypes.*: @Entity;
	
	//@ManyToOne mapping
	declare @field : ((br.cin.ufpe.healthwatcher.model.address.Address 
					   br.cin.ufpe.healthwatcher.model.complaint.Complaint+.endereco*) ||
					  (br.cin.ufpe.healthwatcher.model.address.Address 
					   br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint.occurenceLocalAddress)
					  ):
	@ManyToOne(cascade=CascadeType.ALL);
	
	declare @field : (br.cin.ufpe.healthwatcher.model.employee.Employee br.cin.ufpe.healthwatcher.model.complaint.Complaint.atendente) :
	@ManyToOne(optional=true);
	
	declare @field : (br.cin.ufpe.healthwatcher.model.employee.Employee br.cin.ufpe.healthwatcher.model.Credential.employee) :
	@ManyToOne;	
	
	//@JoinColumn mapping
	declare @field : (br.cin.ufpe.healthwatcher.model.address.Address 
					  br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint.occurenceLocalAddress) ||
					 (br.cin.ufpe.healthwatcher.model.address.Address 
					  br.cin.ufpe.healthwatcher.model.complaint.SpecialComplaint.enderecoOcorrencia) ||
					 (br.cin.ufpe.healthwatcher.model.address.Address 
					  br.cin.ufpe.healthwatcher.model.complaint.FoodComplaint.enderecoDoente): 
					  @JoinColumn(name = "addressCode");
			  
	declare @field : (br.cin.ufpe.healthwatcher.model.address.Address 
					   br.cin.ufpe.healthwatcher.model.complaint.Complaint.enderecoSolicitante):
	@JoinColumn(name = "enderecoSolicitante_code");
	
	declare @field : br.cin.ufpe.healthwatcher.model.employee.Employee br.cin.ufpe.healthwatcher.model.complaint.Complaint.atendente :
	@JoinColumn(name = "login", nullable=true);
	
	declare @field : br.cin.ufpe.healthwatcher.model.employee.Employee br.cin.ufpe.healthwatcher.model.Credential.employee :
	@JoinColumn(name="employee_id");
	
	//@Temporal mapping
	declare @field : private java.util.Date br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint.* : @Temporal(TemporalType.DATE);
	
	declare @field : private java.util.Date br.cin.ufpe.healthwatcher.model.complaint.Complaint.*: @Temporal(TemporalType.TIMESTAMP);
	
	//@Id mapping
	declare @field : private Integer br.cin.ufpe.healthwatcher.model..*.code :
	@Id;
	
	declare @field : private String br.cin.ufpe.healthwatcher.model.employee.Employee.login :
	@Id;
	
	declare @field : private String br.cin.ufpe.healthwatcher.model.Authorization.name :
	@Id;	
	
	//@GeneratedValue mapping
	declare @field : private Integer br.cin.ufpe.healthwatcher.model..*.code :
	@GeneratedValue(strategy = GenerationType.AUTO);
	
}
