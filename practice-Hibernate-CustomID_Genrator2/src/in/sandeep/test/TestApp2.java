package in.sandeep.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sandeep.persistanceObject.*;

public class TestApp2 {

	public static void main(String[] args) throws IOException {

		Session session = null;
		SessionFactory buildSessionFactory = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;
		try {
			 buildSessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
					.buildSessionFactory();
			session = buildSessionFactory.openSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Student student = new Student();
				student.setSname("Dhoni");
				student.setSage(21);
				student.setSaddress("IND");

				id = (String) session.save(student);

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

			session.close();
			buildSessionFactory.close();
		}
		

	}

}
