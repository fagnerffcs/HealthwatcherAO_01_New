package br.cin.ufpe.healthwatcher.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import lib.exceptions.ObjectNotFoundException;
import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;
import br.cin.ufpe.healthwatcher.model.employee.Employee;

public class EmployeeConverter {

	private static final long serialVersionUID = 391558762793887877L;
	
	private HealthWatcherFacade facade;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {
		if(value!=null){
			Employee emp;
			try {
				facade = HealthWatcherFacade.getInstance();
				emp = facade.searchEmployee(value);
				return emp;
			} catch (ObjectNotFoundException | PersistenceException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,	Object value) {
		String login = null;
		if(value instanceof Employee){
			login = String.valueOf(((Employee) value).getLogin());
		}
		return login;
	}

}
