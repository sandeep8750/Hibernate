package in.sandeep.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sandeep.model.Student1;

public class Test {

	public static void main(String[] args) throws IOException {

		// 1. Inform JVM to activate HIBERNATE
				Configuration configuration = new Configuration();
				configuration.configure();

				// Creating a SessionFactory object to hold many other objects required for
				// HIBERNATE

				SessionFactory sessionFactory = configuration.buildSessionFactory();

				// Using SessionFactory object, get only one Session object to perform our
				// persistence operation
				Session session = sessionFactory.openSession();
				
				Transaction transaction = session.beginTransaction();
				
				// 2. Create PERSITENCE Object
				
				Student1 student = new Student1();
				
				student.setSid(10);
				student.setSname("sandeep");
				student.setSage(21);
				student.setSaddress("NIT 3");
				
				
				// 3. Perform PERISTENCE operation using Entity/Model/POJO object
				session.save(student);
				
				System.in.read();
				
				transaction.commit();

				session.close();
				sessionFactory.close();

	}

}
