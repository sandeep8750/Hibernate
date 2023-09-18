package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<InsurancePolicy> nativeQuery = session
					.createSQLQuery("SELECT * FROM HIBERNATE.INSURANCEPOLICY WHERE TENURE>=:max AND TENURE<=:min");

			// Setting the parameter
			nativeQuery.setParameter("max", 1);
			nativeQuery.setParameter("min", 5);

			// Mapping result with Entity class or converting for object to insurance.class
			nativeQuery.addEntity(InsurancePolicy.class);

			// Executing to get the result
			List<InsurancePolicy> policies = nativeQuery.getResultList();

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
