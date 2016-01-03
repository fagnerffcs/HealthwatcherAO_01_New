package br.cin.ufpe.healthwatcher.aspects.distribution;

public aspect HWConverter {
	
	//Declare the converter classes
	declare parents : br.cin.ufpe.healthwatcher.converter.* implements javax.faces.convert.Converter;

}
