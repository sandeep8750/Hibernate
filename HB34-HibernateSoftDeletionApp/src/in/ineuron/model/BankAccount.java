package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "bankaccount1")
@SQLDelete(sql = "UPDATE bankaccount1 SET status='Active' WHERE AccountNumber=?")
@Where(clause = "STATUS NOT IN ('blocked','closed')")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer AccountNumber;
	private String HolderName;
	private Float Balance;
	private String Status;

	static {
		System.out.println("BankAccount Class is loading....");
	}

	public BankAccount() {
		System.out.println("BankAccount Object is used by Hibernate....");
	}

	public Integer getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getHolderName() {
		return HolderName;
	}

	public void setHolderName(String holderName) {
		HolderName = holderName;
	}

	public Float getBalance() {
		return Balance;
	}

	public void setBalance(Float balance) {
		Balance = balance;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BankAccount [AccountNumber=" + AccountNumber + ", HolderName=" + HolderName + ", Balance=" + Balance
				+ ", Status=" + Status + "]";
	}

}
