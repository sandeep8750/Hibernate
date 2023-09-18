package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Insurancepolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	
	public static void main(String[] args) {
		Session session = null;
		try {
			 session = HibernateUtil.getSession();
			 if(session != null)
			 {
				 Query<Insurancepolicy> query = session.createQuery("from in.ineuron.model.Insurancepolicy");
				 List<Insurancepolicy> list = query.getResultList();
				 
				 list.forEach(System.out::println);
				 
			 }
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
