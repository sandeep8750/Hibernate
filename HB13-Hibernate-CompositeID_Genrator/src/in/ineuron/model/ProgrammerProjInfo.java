 
package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjInfo implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgrammerProjID id  ; 
	
	private String  pname ; 
	private Integer deptNO; 
	private String  projName ;
	
	public   ProgrammerProjInfo() {
		System.out.println("Object Created is created ");
	}
	public ProgrammerProjID getId() {
		return id;
	}



	public void setId(ProgrammerProjID id) {
		this.id = id;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public Integer getDptNO() {
		return deptNO;
	}



	public void setDptNO(Integer dptNO) {
		this.deptNO = dptNO;
	}



	public String getProjName() {
		return projName;
	}



	public void setProjName(String projName) {
		this.projName = projName;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "ProgrammerProjInfo [id=" + id + ", pname=" + pname + ", dptNO=" + deptNO + ", projName=" + projName
				+ "]";
	} 
	
	
}
