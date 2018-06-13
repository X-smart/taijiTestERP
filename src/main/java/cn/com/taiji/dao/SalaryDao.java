package cn.com.taiji.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.domain.TSalary;

public interface SalaryDao extends JpaRepository<TSalary, Integer> {

	@Query("select s from TSalary s left join s.TEmp e  where e.eName=:eName ")
	 List<TSalary> findMoneyByeName(@Param(value = "eName") String eName);
	
}
