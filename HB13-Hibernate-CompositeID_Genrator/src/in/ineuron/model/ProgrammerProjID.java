package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgrammerProjID implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private Integer projID;
	private Integer pid;
	
	
	
	public Integer getProjID() {
		return projID;
	}



	public void setProjID(Integer projID) {
		this.projID = projID;
	}



	public Integer getPid() {
		return pid;
	}



	public void setPid(Integer pid) {
		this.pid = pid;
	}



	@Override
	public String toString() {
		return "ProgrammerProjID [projID=" + projID + ", pid=" + pid + "]";
	}



	
	
}
