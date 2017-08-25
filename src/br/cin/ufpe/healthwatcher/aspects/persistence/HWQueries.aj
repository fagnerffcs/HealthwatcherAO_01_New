package br.cin.ufpe.healthwatcher.aspects.persistence;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


public aspect HWQueries {
	
	//employee package
	declare @type : br.cin.ufpe.healthwatcher.model.employee.Employee :
	@NamedQueries({
		@NamedQuery(name="todosEmployees", query="SELECT e FROM Employee e"),
		@NamedQuery(name="employeePorLoginSenha", query="SELECT e FROM Employee e WHERE e.login = :login AND e.password = :password"),
	});
	
	//complaint package
	declare @type : br.cin.ufpe.healthwatcher.model.complaint.AnimalComplaint :
	@NamedQueries({
		@NamedQuery(name="animalComplaintByCode", query="SELECT a FROM AnimalComplaint a WHERE a.code = :code"),
		@NamedQuery(name="allAnimalComplaints", query="SELECT a FROM AnimalComplaint a"),
		@NamedQuery(name="animalComplaintsBySituation", query="SELECT a FROM AnimalComplaint a WHERE a.situacao = :situacao"),
	});

	declare @type : br.cin.ufpe.healthwatcher.model.complaint.FoodComplaint :
	@NamedQueries({
		@NamedQuery(name="foodComplaintByCode", query="SELECT f FROM FoodComplaint f WHERE f.code = :code"),
		@NamedQuery(name="allFoodComplaints", query="SELECT f FROM FoodComplaint f"),
		@NamedQuery(name="allFoodComplaintsBySituation", query="SELECT f FROM FoodComplaint f WHERE f.situacao = :situacao"),
	});	
	
	declare @type : br.cin.ufpe.healthwatcher.model.complaint.SpecialComplaint :
		@NamedQueries({
			@NamedQuery(name="medicalSpecialtyByCode", query="SELECT m FROM MedicalSpecialty m WHERE m.code = :code"),
			@NamedQuery(name="listAllMedicalSpecialties", query="SELECT m FROM MedicalSpecialty m")
		});
	
	declare @type : br.cin.ufpe.healthwatcher.model.complaint.DiseaseType :
		@NamedQueries({
			@NamedQuery(name="allDiseases", query="SELECT d FROM DiseaseType d")
		});	
	
	//healthguide package
	declare @type : br.cin.ufpe.healthwatcher.model.healthguide.HealthUnit :
	@NamedQueries({
		@NamedQuery(name="healthUnitByName", query="SELECT h FROM HealthUnit h WHERE h.code = :code"),
		@NamedQuery(name="allHealthUnits", query="SELECT h FROM HealthUnit h"),
		@NamedQuery(name="healthUnitsBySpecialty", query="SELECT h FROM HealthUnit h inner join h.specialties specialties WHERE specialties.code IN :code")
	});
	
	declare @type : br.cin.ufpe.healthwatcher.model.healthguide.MedicalSpecialty :
		@NamedQueries({
		@NamedQuery(name="specialComplaintByCode", query="SELECT s FROM SpecialComplaint s WHERE s.code = :code"),
		@NamedQuery(name="allSpecialComplaints", query="SELECT s FROM SpecialComplaint s"),
		@NamedQuery(name="specialComplaintsBySituation", query="SELECT s FROM SpecialComplaint s WHERE s.situacao = :situacao")
	});
	
}
