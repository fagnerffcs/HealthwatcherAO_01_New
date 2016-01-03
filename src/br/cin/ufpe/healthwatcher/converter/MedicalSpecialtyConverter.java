package br.cin.ufpe.healthwatcher.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.cin.ufpe.healthwatcher.data.rdb.SpecialtyRepositoryRDB;
import br.cin.ufpe.healthwatcher.model.healthguide.MedicalSpecialty;

public class MedicalSpecialtyConverter implements Converter {

	private static final long serialVersionUID = 6652584125887916341L;

	private SpecialtyRepositoryRDB specialtyRepositoryRDB = new SpecialtyRepositoryRDB();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {
		if(value!=null){
			MedicalSpecialty ms = specialtyRepositoryRDB.find(Integer.parseInt(value));
			return ms;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,	Object value) {
		String code = String.valueOf(((MedicalSpecialty) value).getCode());
		return code;
	}

}
