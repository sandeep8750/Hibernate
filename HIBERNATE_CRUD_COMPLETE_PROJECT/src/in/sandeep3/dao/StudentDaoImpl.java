package in.sandeep3.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.sandeep4.dto.Student;
import in.sandeep5.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {

		Transaction transaction = session.beginTransaction();

		String status = "";
		boolean flage = false;
		try {
			if (transaction != null) {

				Student student = new Student();

				student.setStudentName(sname);
				student.setStudentAge(sage);
				student.setStudentAddress(saddress);

				session.save(student);
				flage = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flage) {
				transaction.commit();
				status = "sucess";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}

		return status;
	}

	@Override
	public Student searchStudent(Integer sid) {
		
		Student student = session.load(Student.class, sid);
		
		if (student != null) {
			return student;
		}
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		
		Transaction transaction = session.beginTransaction();

		String status = "";
		boolean flage = false;
		try {
			if (transaction != null) {
				if (student != null) {
					
					session.merge(student);
					flage = true;
					
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flage) {
				transaction.commit();
				status = "sucess";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}

		return status;

	}

	@Override
	public String deleteStudent(Integer sid) {
		
		Student student = searchStudent(sid);
		
		Transaction transaction = session.beginTransaction();

		String status = "";
		boolean flage = false;
		try {
			if (transaction != null) {
				if(student != null)
				{
					session.delete(student);
					flage = true;
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flage) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "not found";
			}
		}

		return status;

	}

}
