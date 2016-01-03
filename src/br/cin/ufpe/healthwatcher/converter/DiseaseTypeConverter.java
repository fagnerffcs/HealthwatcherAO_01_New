package br.cin.ufpe.healthwatcher.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.model.complaint.DiseaseType;

public class DiseaseTypeConverter implements Converter {

	private static final long serialVersionUID = -8035402115502940263L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {
		if(value!=null){
			try{
				HealthWatcherFacade facade = HealthWatcherFacade.getInstance();
				DiseaseType diseaseType = facade.searchDiseaseType(Integer.parseInt(value));
				return diseaseType;
			} catch(Exception e) {
				
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,	Object value) {
		String code = String.valueOf(((DiseaseType) value).getCode());
		return code;
	}

}
