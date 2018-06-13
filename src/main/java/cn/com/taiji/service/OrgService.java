package cn.com.taiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.dao.OrgDao;
import cn.com.taiji.domain.TOrg;


@Service
public class OrgService {

	@Autowired
	private OrgDao orgDao;
	
	@Transactional
	public TOrg queryOrg(Integer id) {
		// TODO Auto-generated method stub
		TOrg org= orgDao.findOne(id);
		return org;
	}
}
