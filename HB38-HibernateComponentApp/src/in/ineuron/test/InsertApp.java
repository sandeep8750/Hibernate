package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Address;
import in.ineuron.model.StudentInfo;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Address address = new Address();
				address.setStateName("Haryana");
				address.setCityName("Faridabad");
				address.setCountryName("Bharat");

				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setSname("Sandeep");
				studentInfo.setSage(21);
				studentInfo.setAddress(address);

				Address address1 = new Address();
				address1.setCountryName("Bharat");
				address1.setCityName("Ayodhya");
				address1.setStateName("Utar Pradesh ");

				StudentInfo studentInfo1 = new StudentInfo();
				studentInfo1.setSname("Sandeep Prajapati");
				studentInfo1.setSage(21);
				studentInfo1.setAddress(address1);

				session.save(studentInfo);
				session.save(studentInfo1);

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
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
