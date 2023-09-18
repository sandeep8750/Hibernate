package in.ineuron.test;

import java.io.IOException;

import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class SelectTestApp2 {

	public static void main(String[] args) throws IOException {

		MobileCustomer customer = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				 customer = session.get(MobileCustomer.class, 1);
					System.out.println("Loading Object before updation :: " + customer); 
					
				transaction = session.beginTransaction();
				if(transaction != null) {
					
					customer.setCallerTune("ALLAA RE ALAA THALA ALAA....");
					customer.setMobileNo(8750369611L);
					session.update(customer);
					
					flag = true; 
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Object is Updated in DB :: " + customer);
			}
			else {
				transaction.rollback();
				System.out.println("Object is not saved to DB :: " );
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
