package in.ineuron.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.JobSeekar;
import in.ineuron.util.HibernateUtil;


public class SelectLobApp {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		JobSeekar seekar = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			
			if (session != null) {
				
				 seekar = session.get(JobSeekar.class, 4);
				if(seekar != null)
				{
					System.out.println("Id is       :: " + seekar.getJsId());
					System.out.println("Name is     :: " + seekar.getJsName());
					System.out.println("Address is  :: " + seekar.getJsAddr());
					
					try (FileOutputStream fos = new FileOutputStream("./sandeep/san.jpg");
							FileWriter writer = new FileWriter("./sandeep/resume.txt")) {
						fos.write(seekar.getPhoto());
						writer.write(seekar.getResume());
						System.out.println("Photo and resume got downloaded to :: ./store/****");
					}


				}
				else {
					
					System.out.println("Object not obtained to database..." + seekar);					
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
