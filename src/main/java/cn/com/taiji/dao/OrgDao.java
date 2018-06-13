package cn.com.taiji.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.com.taiji.domain.TOrg;

@Repository
public interface OrgDao extends JpaRepository<TOrg,Integer> {

}
