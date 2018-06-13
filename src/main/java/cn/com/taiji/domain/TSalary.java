package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_salary database table.
 * 
 */
@Entity
@Table(name="t_salary")
@NamedQuery(name="TSalary.findAll", query="SELECT t FROM TSalary t")
public class TSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="s_id")
	private int sId;

	@Temporal(TemporalType.DATE)
	@Column(name="s_date")
	private Date sDate;

	@Column(name="s_money")
	private String sMoney;

	//bi-directional many-to-one association to TEmp
	@ManyToOne
	@JoinColumn(name="e_id")
	private TEmp TEmp;

	public TSalary() {
	}

	public int getSId() {
		return this.sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public Date getSDate() {
		return this.sDate;
	}

	public void setSDate(Date sDate) {
		this.sDate = sDate;
	}

	public String getSMoney() {
		return this.sMoney;
	}

	public void setSMoney(String sMoney) {
		this.sMoney = sMoney;
	}

	public TEmp getTEmp() {
		return this.TEmp;
	}

	public void setTEmp(TEmp TEmp) {
		this.TEmp = TEmp;
	}

}