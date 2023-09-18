package in.ineuron.test;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		Integer id = null ;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();

			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				
				PersonInfo personInfo = new PersonInfo();
				
				personInfo.setPname("Sandeep");
				personInfo.setDob(LocalDate.of(2002, 06, 02));
				personInfo.setDom(LocalDateTime.of(2023, 05, 26, 5, 45));
				personInfo.setDoj(LocalTime.of(2, 35));
				 id = (Integer) session.save(personInfo);
				
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
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
