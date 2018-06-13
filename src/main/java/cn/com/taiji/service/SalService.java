package cn.com.taiji.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.dao.SalaryDao;
import cn.com.taiji.domain.TSalary;

@Service
public class SalService {
	@Autowired
	SalaryDao salDao;

	/**
	 * 按员工姓名查询薪资
	 * @param eName
	 * @return
	 */
	@Transactional
	public List<TSalary> findMoneyByeName(String eName) {
		List<TSalary> list = salDao.findMoneyByeName(eName);
		return list;
	};

	/**
	 * 按员工ID查询薪资
	 * @param eName
	 * @return
	 */
	@Transactional
	public List<TSalary> findMoneyByeId(Integer eId) {
		List<TSalary> list = salDao.findMoneyByeId(eId);
		return list;
	};
	@Transactional
	public void saveTSalary(TSalary salary) {
		salDao.save(salary);
	}

}
