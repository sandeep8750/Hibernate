package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class SetProperty {

	private static int id =1;

	public static void main(String[] args) throws IOException {
		Session session = null;
		SessionFactory sessionFactory = null;
		
		try {
			// Setting the properties for configuration object using pure java object approach
			
			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///sandeep");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "root123");
			
			configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.show_sql","true");
			configuration.setProperty("hibernate.format_sql","true");
			configuration.setProperty("hibernate.hbm2ddl.auto","update");
			
			// providing mapping information about persistance object 
			configuration.addAnnotatedClass(Student.class);
			
			sessionFactory = configuration.buildSessionFactory();
			
			session = sessionFactory.openSession();
			Student student = session.get(Student.class, id);
			
		if(student != null)
		{
			System.out.println("Before updation in the table:: " + student);			
		}
		
			System.in.read();
			session.refresh(student);
			System.out.println("Record not avilable for given id :: " + id);
			System.out.println("After updation in the table :: " + student);
		
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			session.close();
			sessionFactory.close();

		}

	}

}
