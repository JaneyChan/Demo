package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Admin;
import com.blog.model.Admininfo;
import com.blog.model.Article;

@Service("adminDao")
public class AdminDao extends BaseDaoImpl {
	//管理员登录
	public Admin loginAdmin(String adminName, String password) {
		return (Admin)getResultOne("from Admin a where a.adminName = ? and a.password = ?", new Object[]{adminName, password});
	}
	
	//修改密码
	public boolean modifyPwd(Admin admin) {
		return update(admin);
	}
	
	//修改个人信息
	public boolean updateInfo(Admininfo info) {
		return update(info);
	}
	
	//添加个人信息
	public boolean addInfo(Admininfo info) {
		return save(info);
	}
	
	//按管理员查找个人信息
	public Admininfo findByAdmin(Admin admin) {
		return (Admininfo)getResultOne("from Admininfo a where a.admin = ?", new Object[]{admin});
	}
	
	//查找博主信息（前台显示）
	public List<Admininfo> findInfo() {
		return (List<Admininfo>)getResult("from Admininfo", null);
	}
}
