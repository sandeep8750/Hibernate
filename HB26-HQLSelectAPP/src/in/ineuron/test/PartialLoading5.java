package in.ineuron.test;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.util.HibernateUtil;

public class PartialLoading5 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			Query<Products> query = session.createQuery(" FROM in.ineuron.model.Products WHERE pid=:id");// select * from product;

			System.out.println("Enter pid for Get data form DB :: ");
			int id = new Scanner(System.in).nextInt();
			
			query.setParameter("id", id);
			// Execute the query
			Optional<Products> products = query.uniqueResultOptional();
			

			// process the List Object
			if(products.isPresent())
			{
				Products product = products.get();
				System.out.println(product);				
			}
			else {
				System.out.println("Record is not Avilable for given id :: " + id);
			}
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
