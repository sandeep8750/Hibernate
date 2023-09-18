package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Long id = 1L;

		Transaction transaction = null;
		InsurancePolicy policy =null;
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			
				policy = session.get(InsurancePolicy.class, id);
				System.out.println("Before modification :: " + policy);
				System.out.println("Record not available for the given id :: " + id);
			
				System.out.println();
				System.out.println();
				policy = session.get(InsurancePolicy.class, id);
				System.out.println("Before modification :: " + policy);
				System.out.println("Record not available for the given id :: " + id);
				
				session.evict(policy);
				System.out.println();
				System.out.println();
				policy = session.get(InsurancePolicy.class, id);
				System.out.println("Before modification :: " + policy);
				System.out.println("Record not available for the given id :: " + id);
				
				
				System.out.println();
				System.out.println();
				policy = session.get(InsurancePolicy.class, id);
				System.out.println("Before modification :: " + policy);
				System.out.println("Record not available for the given id :: " + id);
				
				
				session.clear();
				System.out.println();
				System.out.println();
				policy = session.get(InsurancePolicy.class, id);
				System.out.println("Before modification :: " + policy);
				System.out.println("Record not available for the given id :: " + id);

				
				System.out.println();
				System.out.println();
				policy = session.get(InsurancePolicy.class, id);
				System.out.println("Before modification :: " + policy);
				System.out.println("Record not available for the given id :: " + id);
				
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
