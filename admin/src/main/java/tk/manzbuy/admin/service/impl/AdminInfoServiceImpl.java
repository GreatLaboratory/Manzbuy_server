package tk.manzbuy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.manzbuy.admin.dao.AdminInfoDao;
import tk.manzbuy.admin.dto.AdminInfo;
import tk.manzbuy.admin.service.AdminInfoService;

@Service
public class AdminInfoServiceImpl implements AdminInfoService{
	@Autowired
	AdminInfoDao adminInfoDao;

	@Override
	@Transactional
	public List<AdminInfo> getAdminInfos() {
		
		List<AdminInfo> list = adminInfoDao.selectAll();
		return list;
	}
	
	
}
