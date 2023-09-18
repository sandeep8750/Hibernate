package in.ineuron.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectAppUsingCriterianApi {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");

			filter.setParameter("accType1", "Blocked");
			filter.setParameter("accType2", "Closed");

			NativeQuery<BankAccount> query = session.createSQLQuery("SELECT * FROM bankaccount1 where balance>=:amt");
			query.setParameter("amt", 30000.0f);

			query.addEntity(BankAccount.class);
			List<BankAccount> account = query.list();
			account.forEach(System.out::println);

			
			System.out.println();

			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			NativeQuery<BankAccount> query1 = session.createSQLQuery("SELECT * FROM bankaccount1 where balance>=:amt");
			query1.setParameter("amt", 100.0f);

			query1.addEntity(BankAccount.class);
			List<BankAccount> account1 = query1.list();
			account1.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
