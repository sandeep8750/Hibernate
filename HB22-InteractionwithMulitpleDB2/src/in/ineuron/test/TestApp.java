package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy2;
import in.ineuron.util.MySQLHibernateUtil2;

public class TestApp {

	

	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = MySQLHibernateUtil2.getSession();
		Long id = null;
		boolean flag = false ;

		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					InsurancePolicy2 policy2 = new InsurancePolicy2();
					policy2.setCompany("hi");
					policy2.setPolicyName("sandeep");
					policy2.setPolicyType("yearly");
					policy2.setTenure(5);

					id = (Long) session.save(policy2);
					flag = true ;
				}

			}
			
			if(flag)
			{
				transaction.commit();
				System.out.println("Object save to data base " + id);
			}
			else {
				transaction.rollback(); 
				System.out.println("Object is not save to database" + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			 MySQLHibernateUtil2.closeSessionFactory();
		}
	}
}
