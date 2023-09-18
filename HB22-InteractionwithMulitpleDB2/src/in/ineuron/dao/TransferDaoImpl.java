package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.MySQLHibernateUtil;
import in.ineuron.util.MySQLHibernateUtil2;

public class TransferDaoImpl implements ITransferDao {

	@SuppressWarnings("finally")
	@Override
	public String transferProductById(Long id) {

		Session mysqlSession1 = MySQLHibernateUtil.getSession();
		Session mysqlSession2 = MySQLHibernateUtil2.getSession();
		Integer idValue = 0;
		Boolean flag = false;

		Transaction mysqlTransaction = null;

		InsurancePolicy product = mysqlSession1.get(InsurancePolicy.class, id);

		if (product == null) {
			return "Record not available for copying....";
		} else {

			try {
				mysqlTransaction = mysqlSession2.beginTransaction();
				idValue = (Integer) mysqlSession2.save(product);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) {
					mysqlTransaction.commit();
					return "Data copied from oracle to mysql with the id :: " + idValue;
				} else {
					mysqlTransaction.rollback();
					return "Data not copied from oracle to mysql with the id :: " + idValue;
				}
			}
		}

	}

}
