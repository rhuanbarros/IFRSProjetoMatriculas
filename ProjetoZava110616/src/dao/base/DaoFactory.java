package dao.base;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public final class DaoFactory {

	private DaoFactory() {
	}

	private static EntityManagerFactory entityManagerFactoryInstance;

	public static EntityManagerFactory entityManagerFactorInstance() {
		if (entityManagerFactoryInstance == null)
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory("matricula-oracle");
		return entityManagerFactoryInstance;
	}	
	
}
