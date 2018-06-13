package cn.com.taiji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.dao.EmpDao;
import cn.com.taiji.dao.OrgDao;
import cn.com.taiji.domain.TEmp;
import cn.com.taiji.domain.TOrg;

@Service
public class OrgService {

	@Autowired
	private OrgDao orgDao;

	@Autowired
	private EmpDao empDao;

	// 根据部门id查找部门
	@Transactional
	public TOrg queryOrg(Integer id) {
		// TODO Auto-generated method stub
		TOrg org = orgDao.findOne(id);
		return org;
	}

	// 根据部门名称查找部门
	@Transactional
	public List<TOrg> queryOrgByName(String name) {
		// TODO Auto-generated method stub
		List<TOrg> org = orgDao.findByOName(name);
		return org;
	}

	// 根据员工Id查询员工部门
	public TOrg queryEmpOrg(Integer id) {
		TEmp emp = empDao.findOne(id);
		return emp.getTOrg();
	}

	// 新增部门
	@Transactional
	public void saveOrg(TOrg org) {
		orgDao.save(org);
	}

	// 根据id删除部门
	@Transactional
	public void deleteOrg(Integer id) {
		orgDao.delete(id);
	}
}
