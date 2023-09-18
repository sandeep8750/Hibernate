package in.ineuron.test;

import java.io.IOException;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;
		try {
			session = HibernateUtil.getSession();

			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Employee employee = new Employee();
				employee.setEmployeeName("Sandeep");
				employee.setEmployeeAge(21);
				employee.setEmployeeAdress("NIT3");
				
				id  = (String) session.save(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				
				transaction.commit();
				System.out.println("Object saved to database....");
				System.out.println("object inserted in DB id is :: " + id);
			} else {
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
