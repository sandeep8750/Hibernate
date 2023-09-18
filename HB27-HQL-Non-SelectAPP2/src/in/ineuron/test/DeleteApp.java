package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Integer id  = null;
		boolean flage = false ;
		Query query = null;
		
		try {
			 session = HibernateUtil.getSession();
			 
			 if (session != null) {
				
				  transaction = session.beginTransaction();
				
				  //Prepare object to hold HQL 
				  query = session.createQuery("DELETE FROM in.ineuron.model.Products WHERE pname like :startWith");
				  
				  query.setParameter("startWith", "r%");
				  
				  
				    id = query.executeUpdate();
				    flage = true ;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(flage) {
				transaction.commit();
				System.out.println(" object is delete from  in DB " + id );
			}else {
				transaction.rollback();
				System.out.println(" object is not  delete from  in DB " + id );
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
