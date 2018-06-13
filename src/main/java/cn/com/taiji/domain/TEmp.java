package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_emp database table.
 * 
 */
@Entity
@Table(name="t_emp")
@NamedQuery(name="TEmp.findAll", query="SELECT t FROM TEmp t")
public class TEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="e_id")
	private int eId;

	@Column(name="e_name")
	private String eName;

	@Column(name="e_sex")
	private String eSex;

	@Column(name="e_tel")
	private String eTel;

	//bi-directional many-to-one association to TOrg
	@ManyToOne
	@JoinColumn(name="o_id")
	private TOrg TOrg;

	//bi-directional many-to-one association to TSalary
	@OneToMany(mappedBy="TEmp")
	private List<TSalary> TSalaries;

	public TEmp() {
	}

	public int getEId() {
		return this.eId;
	}

	public void setEId(int eId) {
		this.eId = eId;
	}

	public String getEName() {
		return this.eName;
	}

	public void setEName(String eName) {
		this.eName = eName;
	}

	public String getESex() {
		return this.eSex;
	}

	public void setESex(String eSex) {
		this.eSex = eSex;
	}

	public String getETel() {
		return this.eTel;
	}

	public void setETel(String eTel) {
		this.eTel = eTel;
	}

	public TOrg getTOrg() {
		return this.TOrg;
	}

	public void setTOrg(TOrg TOrg) {
		this.TOrg = TOrg;
	}

	public List<TSalary> getTSalaries() {
		return this.TSalaries;
	}

	public void setTSalaries(List<TSalary> TSalaries) {
		this.TSalaries = TSalaries;
	}

	public TSalary addTSalary(TSalary TSalary) {
		getTSalaries().add(TSalary);
		TSalary.setTEmp(this);

		return TSalary;
	}

	public TSalary removeTSalary(TSalary TSalary) {
		getTSalaries().remove(TSalary);
		TSalary.setTEmp(null);

		return TSalary;
	}

}