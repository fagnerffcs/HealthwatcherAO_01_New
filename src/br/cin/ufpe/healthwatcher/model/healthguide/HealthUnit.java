package br.cin.ufpe.healthwatcher.model.healthguide;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class HealthUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer code;

	@Column(length = 200)
	private String description;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "healthunit_medicalspecialty", joinColumns = @JoinColumn(name = "healthunit_code"), inverseJoinColumns = @JoinColumn(name = "medicalspecialty_code"))
	private List<MedicalSpecialty> specialties;

	// Getters and Setters
	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public List<MedicalSpecialty> getSpecialities() {
		return this.specialties;
	}

	public void setSpecialties(List<MedicalSpecialty> specialities) {
		this.specialties = specialities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthUnit other = (HealthUnit) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HealthUnit [code=" + code + ", description=" + description + "]";
	}

}
