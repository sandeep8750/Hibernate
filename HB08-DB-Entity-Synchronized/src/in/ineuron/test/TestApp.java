package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	private static int id =1;

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, id);
			System.out.println("Before updation in the table:: " + student);

		if(student != null)
		{
			System.in.read();
			
			session.refresh(student);
			
			System.out.println("After updation in the table :: " + student);
			
		}else {
			System.out.println("Record not avilable for given id :: " + id);
		}
			
			
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
