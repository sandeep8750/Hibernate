package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.util.HibernateUtil;
import in.ineuron.model.MobileCustomer;
public class InsertTestApp {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		Integer id = null ;
		MobileCustomer customer = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();

			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				
				 customer = new MobileCustomer();
				
				customer.setCname("DHONI");
				customer.setCno(7);
				customer.setMobileNo(875069610L);
				customer.setCallerTune("Thala re alla " );
				
				id = (Integer)session.save(customer);
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				
				transaction.commit();
				System.out.println("object inserted in DB id is :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
