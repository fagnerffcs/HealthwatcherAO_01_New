package br.cin.ufpe.healthwatcher.aspects.distribution;


/**
 * This is the server part for distribution. The following tasks are done:
 * 
 * 1) makes the facade implement the remote interface
 * 2) makes model classes serializable (actually this is also needed in the client)
 * 3) creates a main method in the facade, to start the server
 * 4) publishes the facade as an rmi server when starting
 */
public aspect HWServerDistribution {

	/**
	 * Declare the model classes serializable
	 */
	declare parents : br.cin.ufpe.healthwatcher.model..* || br.cin.ufpe.healthwatcher.business..*.* implements java.io.Serializable;
	
}
