package cn.com.taiji.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.com.taiji.domain.TEmp;
import cn.com.taiji.domain.TOrg;

@Repository
public interface OrgDao extends JpaRepository<TOrg,Integer> {
	
	public List<TOrg> findByOName(String oName);
}
