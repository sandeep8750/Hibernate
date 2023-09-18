package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectAppUsingHQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");

			filter.setParameter("accType1", "Blocked");
			filter.setParameter("accType2", "Closed");

			 Criteria criteria = session.createCriteria(BankAccount.class);
			 Criterion condi = Restrictions.ge("Balance", 30000.0f);
			 criteria.add(condi);
			 List<BankAccount> account = criteria.list();
			 account.forEach(System.out::println);

			
			System.out.println();

			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			Criteria query1 = session.createCriteria(BankAccount.class);
			Criterion condi1 = Restrictions.ge("Balance",100.0f); 
			query1.add(condi1);

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
