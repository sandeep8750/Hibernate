package in.ineuron.test;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.MySQLHibernateUtil;
import in.ineuron.util.MySQLHibernateUtil2;

public class InteractWithMultipleDB {

	public static void main(String[] args) throws Exception {

		ITransferDao dao = new TransferDaoImpl();
		System.out.println(dao.transferProductById((long) 3));

		MySQLHibernateUtil.closeSessionFactory();
		MySQLHibernateUtil2.closeSessionFactory();

	}
	
}

