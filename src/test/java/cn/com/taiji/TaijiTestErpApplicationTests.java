package cn.com.taiji;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.domain.TEmp;
import cn.com.taiji.domain.TOrg;
import cn.com.taiji.service.EmpService;
import cn.com.taiji.service.OrgService;
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

		String name = "许聪慧";
		list = ss.findMoneyByeName(name);
		System.out.println("\n==========================");
		System.out.println(name + "的薪资发放情况如下：");
		for (TSalary tSalary : list) {
			System.out.println(tSalary);
		}
		System.out.println("==========================\n");
	}

	@Test
	public void selMoneyByeId() {
		List<TSalary> list = new ArrayList<>();
		Integer id = 1;
		list = ss.findMoneyByeId(id);
		System.out.println("\n==========================");
		System.out.println(id + "的薪资发放情况如下：");
		for (TSalary tSalary : list) {
			System.out.println(tSalary);
		}
		System.out.println("==========================\n");
	}

	@Test
	public void saveSal() {
		TEmp emp = new TEmp(12, "李四", "男", "2151545", null, null);
		TSalary salary = new TSalary(5, new Date(), "6000", emp);
		ss.saveTSalary(salary);

	}

	// 保存员工
	@Test
	public void saveEmp() {
		TEmp tem = new TEmp();
		tem.setEId(12);
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
		empService.deleteEmp(8);

	}

	// 根据id查找员工
	@Test
	public void queryEmp() {
		TEmp queryEmp = empService.queryEmp(4);
		System.out.println(queryEmp);
	}

	// 根据姓名查找员工
	@Test
	public void queryEmpByName() {
		List<TEmp> queryEmp = empService.queryEmpByName("于新亮");
		System.out.println(queryEmp);
	}

	// 查找所有员工
	@Test
	public void queryEmpAll() {
		List<TEmp> queryEmp = empService.queryEmpAll();
		System.out.println(queryEmp);
	}

	// 根据Id修改用户
	@Test
	public void upadteEmp() {
		TEmp emp = new TEmp();
		emp.setEName("2333");
		emp.setETel("11111111");
		TEmp upadteEmp = empService.upadteEmp(12, emp);
		System.out.println(upadteEmp);
	}

	// 根据部门id查找部门
	@Test
	public void queryOrg() {
		TOrg org = orgService.queryOrg(2);
		System.out.println(org);
	}

	// 根据部门名称查找部门
	@Test
	public void queryOrgByName() {
		List<TOrg> org = orgService.queryOrgByName("智云");
		System.out.println(org);
	}

	// 根据员工Id查询员工部门
	@Test
	public void queryEmpOrg() {
		TOrg org = orgService.queryEmpOrg(1);
		System.out.println(org);
	}

	// 新增部门
	@Test
	public void saveOrg() {
		TOrg queryOrg = new TOrg();
		queryOrg.setOId(5);
		queryOrg.setOName("政府一部");
		TOrg org = orgService.queryOrg(2);
		queryOrg.setTOrg(org);
		orgService.saveOrg(queryOrg);
	}

	// 根据id删除部门
	@Test
	public void deleteOrg() {
		orgService.deleteOrg(5);
	}

}
