package in.sandeep.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.sandeep.model.Student1;
import in.sandeep.util.HibernateUtil;

public class SaveApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}

			if (transaction != null) {
				Student1 student = new Student1();

				student.setSid(10);
				student.setSname("sandeep");
				student.setSage(21);
				student.setSaddress("NIT 3");

				session.save(student);

				flag = true;

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.in.read();
				transaction.commit();
				System.out.println("Object saved to database....");
			} else {
				if (transaction != null) {
					transaction.rollback();
					System.out.println("Object not saved to database...");
				}
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
