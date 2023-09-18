package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.IDGenerateHibernateUtil;

public class TestApp2 {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;
		try {
			session = IDGenerateHibernateUtil.getSession();

			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Student student = new Student();
				student.setSname("Sandeep");
				student.setSage(21);
				student.setSaddress("IND");

				id  = (String) session.save(student);
				
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

			IDGenerateHibernateUtil.closeSession(session);
			IDGenerateHibernateUtil.closeSessionFactory();
		}

	}

}
