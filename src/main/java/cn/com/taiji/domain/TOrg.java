package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_org database table.
 * 
 */
@Entity
@Table(name="t_org")
@NamedQuery(name="TOrg.findAll", query="SELECT t FROM TOrg t")
public class TOrg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="o_id")
	private int oId;

	@Column(name="o_name")
	private String oName;

	@Column(name="o_tel")
	private String oTel;

	//bi-directional many-to-one association to TEmp
	@OneToMany(mappedBy="TOrg")
	private List<TEmp> TEmps;

	//bi-directional many-to-one association to TOrg
	@ManyToOne
	@JoinColumn(name="o_pid")
	private TOrg TOrg;

	//bi-directional many-to-one association to TOrg
	@OneToMany(mappedBy="TOrg")
	private List<TOrg> TOrgs;

	public TOrg() {
	}

	public int getOId() {
		return this.oId;
	}

	public void setOId(int oId) {
		this.oId = oId;
	}

	public String getOName() {
		return this.oName;
	}

	public void setOName(String oName) {
		this.oName = oName;
	}

	public String getOTel() {
		return this.oTel;
	}

	public void setOTel(String oTel) {
		this.oTel = oTel;
	}

	public List<TEmp> getTEmps() {
		return this.TEmps;
	}

	public void setTEmps(List<TEmp> TEmps) {
		this.TEmps = TEmps;
	}

	public TEmp addTEmp(TEmp TEmp) {
		getTEmps().add(TEmp);
		TEmp.setTOrg(this);

		return TEmp;
	}

	public TEmp removeTEmp(TEmp TEmp) {
		getTEmps().remove(TEmp);
		TEmp.setTOrg(null);

		return TEmp;
	}

	public TOrg getTOrg() {
		return this.TOrg;
	}

	public void setTOrg(TOrg TOrg) {
		this.TOrg = TOrg;
	}

	public List<TOrg> getTOrgs() {
		return this.TOrgs;
	}

	public void setTOrgs(List<TOrg> TOrgs) {
		this.TOrgs = TOrgs;
	}

	public TOrg addTOrg(TOrg TOrg) {
		getTOrgs().add(TOrg);
		TOrg.setTOrg(this);

		return TOrg;
	}

	public TOrg removeTOrg(TOrg TOrg) {
		getTOrgs().remove(TOrg);
		TOrg.setTOrg(null);

		return TOrg;
	}

}