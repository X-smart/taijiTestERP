package cn.com.taiji.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.com.taiji.domain.TEmp;

public interface EmpDao extends JpaRepository<TEmp,Integer> {
	
}
