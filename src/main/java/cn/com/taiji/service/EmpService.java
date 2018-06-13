package cn.com.taiji.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.dao.EmpDao;
import cn.com.taiji.domain.TEmp;
import cn.com.taiji.domain.TOrg;

@Service
public class EmpService {

	@Autowired
	private EmpDao empDao;

	// 保存员工
	@Transactional // 引入事务
	public void saveEmp(TEmp t1) {
		empDao.save(t1);
	}

	// 删除员工
	@Transactional
	public void deleteEmp(Integer id) {
		empDao.delete(id);

	}

	// 根据id查找员工
	@Transactional
	public TEmp queryEmp(Integer id) {
		return empDao.findOne(id);
	}

	// 根据姓名查找员工
	@Transactional
	public List<TEmp> queryEmpByName(String eName) {
		return (List<TEmp>) empDao.findByEName(eName);
	}

	// 查找所有员工
	@Transactional
	public List<TEmp> queryEmpAll() {
		return  (List<TEmp>) empDao.findAll();
	}

	// 根据Id修改用户
	@Transactional
	public TEmp upadteEmp(Integer id, TEmp emp) {
		TEmp queryEmp = empDao.findOne(id);
		emp.setEId(id);
		TEmp mergeEmp = empDao.save(emp);
		return mergeEmp;
	}

}
