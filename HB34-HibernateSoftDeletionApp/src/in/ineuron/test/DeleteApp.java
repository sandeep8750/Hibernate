package in.ineuron.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flage = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					BankAccount account = new BankAccount();
					account.setAccountNumber(12345);
					session.delete(account);
					flage = true;
				}
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flage) {
				transaction.commit();
				System.out.println("Object status changed to closed/blocked==> soft deletion");
			} else {
				transaction.rollback();
				System.out.println("object status not changed");

			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
