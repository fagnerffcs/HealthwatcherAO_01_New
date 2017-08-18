package br.cin.ufpe.healthwatcher.aspects.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

public aspect HWScope {

	//@ManagedBean mapping
	declare @type : br.cin.ufpe.healthwatcher.business.complaint.* 	 ||
					br.cin.ufpe.healthwatcher.business.healthguide.* ||
					br.cin.ufpe.healthwatcher.business.employee.* 	 ||
					br.cin.ufpe.healthwatcher.converter.*: @ManagedBean;
	
	declare @type : br.cin.ufpe.healthwatcher.business.HealthWatcherFacade : @ManagedBean(name="facade");
	
	//@RequestScoped mapping
	declare @type : br.cin.ufpe.healthwatcher.business.complaint.* ||
					br.cin.ufpe.healthwatcher.converter.* : @RequestScoped;
	
	//@ViewScoped mapping
	declare @type : br.cin.ufpe.healthwatcher.business.healthguide.* ||
					(br.cin.ufpe.healthwatcher.business.employee.* && 
					 !br.cin.ufpe.healthwatcher.business.employee.EmployeeLogin)
					: @ViewScoped;
					
	//@SessionScoped mapping
	declare @type : br.cin.ufpe.healthwatcher.business.employee.EmployeeLogin : @SessionScoped;

	//@ApplicationScoped mapping
	declare @type : br.cin.ufpe.healthwatcher.business.HealthWatcherFacade : @ApplicationScoped;
}
