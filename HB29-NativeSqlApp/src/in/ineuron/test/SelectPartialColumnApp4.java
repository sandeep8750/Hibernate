package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ineuron.util.HibernateUtil;

public class SelectPartialColumnApp4 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<String> nativeQuery = session
					.createSQLQuery("SELECT COMPANY FROM HIBERNATE.INSURANCEPOLICY WHERE TENURE>=:max AND TENURE<=:min");

			// Setting the named parameter
			nativeQuery.setParameter("max", 1);
			nativeQuery.setParameter("min", 5);

			// Executing to get the result
			List<String> policies = nativeQuery.getResultList();

			// Processing the result
			policies.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
