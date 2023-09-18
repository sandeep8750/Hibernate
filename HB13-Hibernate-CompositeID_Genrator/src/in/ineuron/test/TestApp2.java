package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjID;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class TestApp2 {

	
	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		ProgrammerProjID id =null ;
		try {
			session = HibernateUtil.getSession();

			
			if (session != null) {
				ProgrammerProjID projID = new ProgrammerProjID();
				projID.setPid(100);
				projID.setProjID(503);
				ProgrammerProjInfo projInfo = session.get(ProgrammerProjInfo.class, projID);
				if(projInfo != null)
				{
					System.out.println("Object Obtained from DB is ::" + projInfo);
				}
				else {
				System.out.println("object is found for given id ::" + projID);	
				}
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
