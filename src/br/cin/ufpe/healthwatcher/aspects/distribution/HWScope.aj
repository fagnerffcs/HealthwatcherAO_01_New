package br.cin.ufpe.healthwatcher.aspects.distribution;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

public aspect HWScope {

	//@ManagedBean mapping
	declare @type : br.cin.ufpe.healthwatcher.business.complaint.* : @ManagedBean;
		
	
	//@ViewScoped mapping
	declare @type : br.cin.ufpe.healthwatcher.business.complaint.* : @ViewScoped;	
	
}
