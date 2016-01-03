package br.cin.ufpe.healthwatcher.aspects.persistence;

import lib.exceptions.TransactionException;
import lib.persistence.IPersistenceMechanism;
import br.cin.ufpe.healthwatcher.business.HealthWatcherFacade;

public aspect HWTransactionManagement {
    pointcut transactionalMethods(): execution(* HealthWatcherFacade.insert*(..)) || 
    								 execution(* HealthWatcherFacade.update*(..)) ||
    								 execution(* HealthWatcherFacade.search*(..));
    
    declare soft: TransactionException : 
        call(void IPersistenceMechanism.beginTransaction())    || 
        call(void IPersistenceMechanism.rollbackTransaction()) || 
        call(void IPersistenceMechanism.commitTransaction());
    
    before(): transactionalMethods() {
        getPm().beginTransaction();
    }
    
    after() returning: transactionalMethods()  {
        getPm().commitTransaction();
    }
    
    after() throwing: transactionalMethods()  {
        getPm().rollbackTransaction();
    }
    
    public IPersistenceMechanism getPm() {
		return HWPersistence.aspectOf().getPm();
	}
}
