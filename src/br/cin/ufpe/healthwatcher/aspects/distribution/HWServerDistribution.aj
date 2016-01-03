package br.cin.ufpe.healthwatcher.aspects.distribution;

public aspect HWServerDistribution {

	/**
	 * Declare the model classes serializable
	 */
	declare parents : br.cin.ufpe.healthwatcher.model..* || 
					  br.cin.ufpe.healthwatcher.business..*.* ||
					  br.cin.ufpe.healthwatcher.converter.* ||
					  br.cin.ufpe.healthwatcher.data.**.* implements java.io.Serializable;
	
}
