package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.model.InsurancePolicy2;

public class MySQLHibernateUtil2 {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private MySQLHibernateUtil2() {
	}

	static {
		sessionFactory = new Configuration().configure()
				.addAnnotatedClass(InsurancePolicy2.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

}
