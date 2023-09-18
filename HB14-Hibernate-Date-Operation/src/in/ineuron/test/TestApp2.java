package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;


public class TestApp2 {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		PersonInfo personInfo = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			
			if (session != null) {
				
				personInfo = session.get(PersonInfo.class, 1);
				if(personInfo != null)
				{
					System.out.println("Object obtained to database....");
					System.out.println(personInfo);
				}
				else {
					
					System.out.println("Object not obtained to database..." + personInfo);					
				}
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
