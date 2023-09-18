package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjID;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		ProgrammerProjID id =null ;
		try {
			session = HibernateUtil.getSession();

			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				
				ProgrammerProjID projID = new ProgrammerProjID();
				projID.setPid(101);
				projID.setProjID(502);

				ProgrammerProjInfo projInfo = new ProgrammerProjInfo();
				
				projInfo.setId(projID);
				projInfo.setPname("sandeep");
				projInfo.setProjName("Hibernate_Composite_Id_Generator");
				projInfo.setDptNO(10);
				
				id = (ProgrammerProjID)session.save(projInfo);
				flag = true;
			}

		} catch (HibernateException e) {
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
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
