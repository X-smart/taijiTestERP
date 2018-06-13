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

	@Transactional
	public List<TSalary> findEmpMoney(String eName) {
		List<TSalary> list = salDao.findMoneyByeName(eName);
		return list;
	};

	@Transactional
	public void saveTSalary(TSalary salary) {
		salDao.save(salary);
	}

}
