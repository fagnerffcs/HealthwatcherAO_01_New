package br.cin.ufpe.healthwatcher.aspects.persistence;

import java.io.Serializable;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public aspect SerializableMaker {
	
	@DeclareParents("br.cin.ufpe.healthwatcer.model..*")
	Serializable interfaces;

}
