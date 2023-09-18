package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeekar;
import in.ineuron.util.HibernateUtil;

public class InsertLobApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false ;
		JobSeekar seekar = null;
		byte photobyte[] = null;
		char resume[] = null;
		Integer id = null;
		File file = null;
		
		
		   try (FileInputStream fis = new FileInputStream("C:\\Users\\sande\\OneDrive\\Pictures\\pic2.jpg")) {
			photobyte = new byte[fis.available()];
			   fis.read(photobyte);
		}
		   file  = new File("C:\\Users\\sande\\OneDrive\\Desktop\\wp.txt");
		   
		   try (Reader rd = new FileReader(file)) {
			resume = new char[(int) file.length()];
			   
		}
		   try {
				session = HibernateUtil.getSession();
				if (session != null)
					transaction = session.beginTransaction();

				if (transaction != null) {

					 seekar = new JobSeekar();
					 seekar.setJsName("SANDEEP");
					 seekar.setJsAddr("Bengaluru");
					 seekar.setPhoto(photobyte);
					 seekar.setResume(resume);
					
					id = (Integer) session.save(seekar);
					flag = true;
				}

			
		}  catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database....");
				System.out.println("object inserted in DB id is :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database..."+ id);
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
