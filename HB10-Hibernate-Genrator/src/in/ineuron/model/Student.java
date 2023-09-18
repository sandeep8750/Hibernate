package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Student")
@DynamicInsert(value = true)
public class Student {

	/*
	@Id
	 * @GeneratedValue(generator = "pkv")
	 * 
	 * @GenericGenerator(name = "pkv",strategy = "increment")
	 */
	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "pkv")
	 * 
	 * @GenericGenerator(name = "pkv" , strategy = "sequence")
	 */
	
	@Id 
	@GenericGenerator(name = "pkv" , strategy = "identity")
	@GeneratedValue(generator = "pkv")
	private Integer sid;

	private String sname;

	private String saddress;

	private Integer sage;

	public Student() {
		System.out.println("Hibernate uses Zero argument constructor internally");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}

}
