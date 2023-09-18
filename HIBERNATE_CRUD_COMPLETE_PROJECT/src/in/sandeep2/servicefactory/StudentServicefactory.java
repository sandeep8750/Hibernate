package in.sandeep2.servicefactory;

import in.sandeep2.service.IStudentservice;
import in.sandeep2.service.StudentServiceImpl;

public class StudentServicefactory {

	private StudentServicefactory() {
	
	}
	private static IStudentservice studentservice = null;
	public static IStudentservice getStudentService() {
		if (studentservice == null) {
			 studentservice  = new StudentServiceImpl();			
		}
		
		return studentservice;
	}
}
