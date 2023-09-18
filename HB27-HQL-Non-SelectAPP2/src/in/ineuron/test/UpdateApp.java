package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin.TreatedCollectionAttributeJoin;

import in.ineuron.model.Products;
import in.ineuron.util.HibernateUtil;

public class UpdateApp {

	 

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		Integer update = null;
		Transaction transaction = null;
		boolean flage = false ;
		
		
		try {
			session = HibernateUtil.getSession();
			 transaction = session.beginTransaction();
			// Prepare Query object to hold HQL
			Query<Products> query = session.createQuery("UPDATE FROM in.ineuron.model.Products SET qty = qty+:newqty where pname like :ww");// select * from product;
			
			query.setParameter("newqty", 10);
			query.setParameter("initalLetter", "f%");
			
			
			// Execute the query
			update = query.executeUpdate();

			flage = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if(flage)
			{
				transaction.commit();
				System.out.println("Data is save for the givn id " + update);
			}
			else {
				transaction.rollback();
				System.out.println("Data is not save for the givn id " + update);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
