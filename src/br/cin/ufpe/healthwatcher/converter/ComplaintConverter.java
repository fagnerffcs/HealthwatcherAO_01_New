package br.cin.ufpe.healthwatcher.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import lib.exceptions.ObjectNotFoundException;
import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;

@ManagedBean
@RequestScoped
public class ComplaintConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {
		if(value!=null){
			Complaint complaint = null;
			try {
				HealthWatcherFacade facade;
				facade = HealthWatcherFacade.getInstance();
				complaint = facade.searchComplaint(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
			return complaint;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,	Object value) {
		if(value instanceof Complaint){
			Complaint c = (Complaint) value;
			return String.valueOf(c.getCode());
		}
		return null;
	}
}
