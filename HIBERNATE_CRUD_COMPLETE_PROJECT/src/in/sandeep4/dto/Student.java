package in.sandeep4.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Table;

@Entity 
@DynamicUpdate(value = true)
public class Student implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "PrimeryKey" , strategy = "identity")
	@GeneratedValue(generator = "PrimeryKey")
	private Integer StudentID;
	private String StudentName;
	private Integer StudentAge ; 
	private String StudentAddress;
	public Integer getStudentID() {
		return StudentID;
	}
	public void setStudentID(Integer studentID) {
		StudentID = studentID;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Integer getStudentAge() {
		return StudentAge;
	}
	public void setStudentAge(Integer studentAge) {
		StudentAge = studentAge;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	@Override
	public String toString() {
		return "Student [StudentID=" + StudentID + ", StudentName=" + StudentName + ", StudentAge=" + StudentAge
				+ ", StudentAddress=" + StudentAddress + "]";
	}
	
		
	
}
