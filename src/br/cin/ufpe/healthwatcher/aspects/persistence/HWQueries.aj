package br.cin.ufpe.healthwatcher.aspects.persistence;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


public aspect HWQueries {

	declare @type : br.cin.ufpe.healthwatcher.model.complaint.SpecialComplaint :
		@NamedQueries({
		@NamedQuery(name="specialComplaintByCode", query="SELECT s FROM SpecialComplaint s WHERE s.code = :code"),
		@NamedQuery(name="allSpecialComplaints", query="SELECT s FROM SpecialComplaint s"),
		@NamedQuery(name="specialComplaintsBySituation", query="SELECT s FROM SpecialComplaint s WHERE s.situacao = :situacao")
	});
	
	declare @type : br.cin.ufpe.healthwatcher.model.healthguide.HealthUnit :
	@NamedQueries({
		@NamedQuery(name="healthUnitByName", query="SELECT h FROM HealthUnit h WHERE h.code = :code"),
		@NamedQuery(name="allHealthUnits", query="SELECT h FROM HealthUnit h"),
		@NamedQuery(name="healthUnitsBySpecialty", query="SELECT h FROM HealthUnit h inner join h.specialties specialties WHERE specialties.code IN :code")
	});
}
