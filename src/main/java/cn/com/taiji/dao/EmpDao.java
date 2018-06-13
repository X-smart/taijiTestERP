package cn.com.taiji.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.com.taiji.domain.TEmp;
@Repository
public interface EmpDao extends JpaRepository<TEmp,Integer> {

	public List<TEmp> findByEName(String eName);
	
	
}
