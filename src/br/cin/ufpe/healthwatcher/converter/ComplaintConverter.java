package br.cin.ufpe.healthwatcher.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import lib.exceptions.ObjectNotFoundException;
import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.model.complaint.Complaint;

public class ComplaintConverter implements Converter {
	
	private static final long serialVersionUID = 392323461823054312L;

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
