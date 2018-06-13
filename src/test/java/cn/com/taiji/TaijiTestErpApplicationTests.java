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
import cn.com.taiji.domain.TSalary;
import cn.com.taiji.service.SalService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaijiTestErpApplicationTests {
	@Autowired
	SalService ss;

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
		TSalary salary =new TSalary(5, new Date(), "6000", emp);
		ss.saveTSalary(salary);
		
		
	}

}
