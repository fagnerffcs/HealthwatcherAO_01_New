package br.cin.ufpe.healthwatcher.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import lib.exceptions.ObjectNotFoundException;
import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.model.healthguide.HealthUnit;

public class HealthUnitConverter {

	private static final long serialVersionUID = -2806869619432072259L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {
		if(value!=null){
			HealthWatcherFacade facade;
			try {
				facade = HealthWatcherFacade.getInstance();
				HealthUnit hu = facade.searchHealthUnit(Integer.parseInt(value));
				return hu;				
			} catch (NumberFormatException | ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,	Object value) {
		if(value instanceof HealthUnit){
			return String.valueOf(((HealthUnit) value).getCode());
		} else {
			return null;
		}
	}

}
