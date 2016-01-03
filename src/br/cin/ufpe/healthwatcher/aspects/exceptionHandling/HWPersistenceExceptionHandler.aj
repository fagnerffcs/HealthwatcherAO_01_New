package br.cin.ufpe.healthwatcher.aspects.exceptionHandling;

import java.io.IOException;

/**
 * This aspect handles repository exceptions in the servlets
 */
public aspect HWPersistenceExceptionHandler {

	// Makes soft all IO exceptions raised in this aspect
	declare soft : IOException : within(HWPersistenceExceptionHandler+);
	
	/*
	void around(HttpServletResponse response) : 
		execution(* HWServlet+.doGet(HttpServletRequest, HttpServletResponse)) &&
		args(.., response) {
		
		try {
			
			proceed(response);
			
        } catch (RepositoryException e) {
        	PrintWriter out = response.getWriter();
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
		}
	}
	*/
}