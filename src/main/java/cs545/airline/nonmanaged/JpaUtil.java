package cs545.airline.nonmanaged;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
public class JpaUtil {
	private EntityManagerFactory entityManagerFactory = null;
	//private static final JpaUtil jpaUtil = new JpaUtil();

	public JpaUtil() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
		} catch (Throwable ex) {
			if ((entityManagerFactory!=null) && (entityManagerFactory.isOpen())) {
				entityManagerFactory.close();
			}
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		if ((entityManagerFactory!=null) && (entityManagerFactory.isOpen())) {
			entityManagerFactory.close();
		}
		super.finalize();
	}

	 public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	 public void destroyJpaUtil() {
		if ((entityManagerFactory!=null) && (entityManagerFactory.isOpen())) {
			entityManagerFactory.close();
		}
	}
}
