package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.util.HibernateUtil;

public class PartialLoading {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			Query<Object[]> query = session.createQuery("SELECT pname, price,qty FROM in.ineuron.model.Products WHERE pname IN(:p1,:p2)");// select * from product;

			query.setParameter("p1", "Fossils");
			query.setParameter("p2", "Casio");
			// Execute the query
			
			List<Object []> products = query.list();
			
			// process the List Object
			
			System.out.println("pname \t price \t qty");
			products.forEach(
					row->{
						for(Object obj :row )
						{
							System.out.print(obj + "\t");
							
						}
						System.out.println();
					});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
