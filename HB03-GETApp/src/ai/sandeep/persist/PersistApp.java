package ai.sandeep.persist;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ai.sandeep.Entity_className.*;
import ai.sandeep.Util.*;

public class PersistApp {
	public static void main(String[] args) {

		Session session = null;
		int id = 3; 
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				
				Student student = session.get(Student.class, id);
				if(student != null)
				{
					System.out.println(student);
				}
				else {
					System.out.println("Record not found");
				}
			}
			
				
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!= null)
			HibernateUtil.closeSession(session);
		}

	}

	
}
