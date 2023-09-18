package in.sandeep2.service;

import in.sandeep3.dao.IStudentDao;
import in.sandeep3.daofactory.StudentDaoFactory;
import in.sandeep4.dto.Student;

public class StudentServiceImpl implements IStudentservice {

	@Override
	public String addStudent(String sname, Integer sage, String saddress) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		Student searchStudent = studentDao.searchStudent(sid);
		return searchStudent;
	}

	@Override
	public String updateStudent(Student student) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		String updateStudent = studentDao.updateStudent(student);
		return updateStudent;
	}

	@Override
	public String deleteStudent(Integer sid) {

		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		String deleteStudent = studentDao.deleteStudent(sid);
		return deleteStudent;
	}

}
