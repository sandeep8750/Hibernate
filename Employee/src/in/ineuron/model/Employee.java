package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value = true)
public class Employee {

	@Id
	@GenericGenerator(name = "gen1",strategy = "in.ineuron.idgenerator.StudentIdGenerator")
	@GeneratedValue(generator = "gen1")
	
	private String EmployeeId;

	private String EmployeeName;

	private String EmployeeAdress;

	private Integer EmployeeAge;

	public  Employee() {
		System.out.println("Hibernate uses Zero argument constructor internally");
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmployeeAdress() {
		return EmployeeAdress;
	}

	public void setEmployeeAdress(String employeeAdress) {
		EmployeeAdress = employeeAdress;
	}

	public Integer getEmployeeAge() {
		return EmployeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		EmployeeAge = employeeAge;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeAdress="
				+ EmployeeAdress + ", EmployeeAge=" + EmployeeAge + "]";
	}
	
	

}
