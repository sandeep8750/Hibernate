package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Products;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Integer id  = null;
		boolean flage = false ; 
		
		try {
			 session = HibernateUtil.getSession();
			 
			 if (session != null) {
				
				  transaction = session.beginTransaction();
				  
				  if (transaction != null) {
					Products products = new Products();
					products.setPname("FastRack");
					products.setPrice(77777);
					products.setQty(7);
					
					id = (Integer)session.save(products);
					 flage = true ;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(flage) {
				transaction.commit();
				System.out.println("Persistance object is save in DB " + id );
			}else {
				transaction.rollback();
				System.out.println("Persistance object is not save in DB " + id );
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
