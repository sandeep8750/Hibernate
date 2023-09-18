package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.util.HibernateUtil;

public class PartialLoading2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			Query<String> query = session.createQuery("SELECT pname FROM in.ineuron.model.Products WHERE pname IN(:p1,:p2)");// select * from product;

			query.setParameter("p1", "Fossils");
			query.setParameter("p2", "Casio");
			// Execute the query
			
			List<String> products = query.getResultList();
			
			// process the List Object
			
			products.forEach(System.out::println);
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
