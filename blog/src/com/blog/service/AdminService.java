package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.AdminDao;
import com.blog.model.Admin;
import com.blog.model.Admininfo;

@Service("adminService")
public class AdminService {
	@Autowired
	@Qualifier("adminDao")
	private AdminDao adminDao;
	
	//管理员登录
	public Admin loginAdmin(String adminName, String password) {
		return adminDao.loginAdmin(adminName, password);
	}
	
	//修改密码
	public boolean modifyPwd(Admin admin) {
		return adminDao.modifyPwd(admin);
	}
	
	//修改个人信息
	public boolean updateInfo(Admininfo info) {
		return adminDao.updateInfo(info);
	}
	
	//添加个人信息
	public boolean addInfo(Admininfo info) {
		return adminDao.addInfo(info);
	}
	
	//按管理员查找个人信息
	public Admininfo findByAdmin(Admin admin) {
		return adminDao.findByAdmin(admin);
	}
	
	//查找博主信息（前台显示）
	public List<Admininfo> findInfo() {
		return adminDao.findInfo();
	}
}
