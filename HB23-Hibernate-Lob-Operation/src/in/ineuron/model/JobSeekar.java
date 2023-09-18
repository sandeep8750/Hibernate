package in.ineuron.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(value =  true)
public class JobSeekar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer jsId;
	String jsName;
	String jsAddr;

	@Lob
	byte[] photo;
	@Lob
	char[] resume;

	public Integer getJsId() {
		return jsId;
	}

	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}

	public String getJsName() {
		return jsName;
	}

	public void setJsName(String jsName) {
		this.jsName = jsName;
	}

	public String getJsAddr() {
		return jsAddr;
	}

	public void setJsAddr(String jsAddr) {
		this.jsAddr = jsAddr;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	@Override

	public String toString() {
		return "JobSeekar [jsId=" + jsId + ", jsName=" + jsName + ", jsAddr=" + jsAddr + ", photo="
				+ Arrays.toString(photo) + ", resume=" + Arrays.toString(resume) + "]";
	}

}
