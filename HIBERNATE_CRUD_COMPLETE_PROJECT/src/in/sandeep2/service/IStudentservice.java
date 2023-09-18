package in.sandeep2.service;

import in.sandeep4.dto.Student;

public interface IStudentservice {

    public String  addStudent(String sname , Integer sage , String saddress);
	
	public Student searchStudent(Integer sid ); 
	
	public String updateStudent(Student student);

	public String deleteStudent(Integer sid );
	
	
}
