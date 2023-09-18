package in.sandeep3.daofactory;

import in.sandeep3.dao.IStudentDao;
import in.sandeep3.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {
		
	}
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao() {
		
		if(studentDao == null) {
			studentDao =  new StudentDaoImpl();			
		}
		return studentDao ;
		
	}
}
