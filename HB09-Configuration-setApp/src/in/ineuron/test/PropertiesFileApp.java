package in.ineuron.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class PropertiesFileApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		int id = 1;

		
		try {
			// Load Hibernate configuration from hibernate.properties
			Configuration configuration = new Configuration();
			FileInputStream fis = new FileInputStream("D:\\Java\\Hibernate\\HB09-Configuration-setApp\\src\\hibernate.properties");
			
			Properties properties = new Properties();
			properties.load(fis);
			
		configuration.setProperties(properties);
			
			// Add the annotated class for mapping
			configuration.addAnnotatedClass(Student.class);

			// Build the session factory
			sessionFactory = configuration.buildSessionFactory();

			
			// Open a new session
			session = sessionFactory.openSession();

			// Retrieve the Student with the given id
			Student student = session.get(Student.class, id);

			if (student != null) {
				System.out.println("Student details :: " + student);
			} else {
				System.out.println("Student not found for id :: " + id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("Hibernate Exception: " + he.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("General Exception: " + e.getMessage());
		} finally {
			// Close the session and session factory
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
