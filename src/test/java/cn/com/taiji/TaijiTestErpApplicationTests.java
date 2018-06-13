package cn.com.taiji;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.domain.TEmp;
import cn.com.taiji.domain.TOrg;
import cn.com.taiji.service.EmpService;
import cn.com.taiji.service.OrgService;

import cn.com.taiji.domain.TEmp;
import cn.com.taiji.domain.TSalary;
import cn.com.taiji.service.SalService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaijiTestErpApplicationTests {
	@Autowired
	SalService ss;

	@Autowired
	private EmpService empService;
	@Autowired
	private OrgService orgService;

	@Test
	public void selMoneyByeName() {
		List<TSalary> list = new ArrayList<>();
		list = ss.findEmpMoney("张三");
		for (TSalary tSalary : list) {
			System.out.println(tSalary);
		}

	}

	@Test
	public void saveSal() {
		TEmp emp = new TEmp(10, "李四", "男", "2151545", null, null);
		TSalary salary = new TSalary(5, new Date(), "6000", emp);
		ss.saveTSalary(salary);

	}

	// 保存员工
	@Test
	public void saveEmp() {
		TEmp tem = new TEmp();
		tem.setEId(5);
		tem.setEName("于新亮");
		tem.setESex("男");
		tem.setETel("1326789332");
		TOrg queryOrg = orgService.queryOrg(2);
		tem.setTOrg(queryOrg);
		empService.saveEmp(tem);
	}

	// 删除员工
	@Test
	public void deleteEmp() {
		empService.deleteEmp(6);

	}

	// 根据id查找员工
	@Test
	public void queryEmp() {
		TEmp queryEmp = empService.queryEmp(4);
		System.out.println(queryEmp);
	}

	// 根据id查找员工
	@Test
	public void queryEmpByName() {
		List<TEmp> queryEmp = empService.queryEmpByName("于新亮");
		System.out.println(queryEmp);
	}

	// 根据Id查询员工部门
	@Test
	public void queryEmpOrg() {
		TOrg org = empService.queryEmpOrg(1);
		System.out.println(org);
	}

	// 根据Id修改用户
	@Test
	public void upadteEmp() {
		TEmp emp = new TEmp();
		emp.setEName("2333");
		emp.setETel("11111111");
		TEmp upadteEmp = empService.upadteEmp(8, emp);
		System.out.println(upadteEmp);
	}

}
