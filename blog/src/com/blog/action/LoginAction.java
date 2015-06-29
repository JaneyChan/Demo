package com.blog.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Admin;
import com.blog.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends BaseAction {
	private String adminId;
	private String adminName;
	private String password;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@Override
	public String execute() throws Exception {
		Admin a = adminService.loginAdmin(adminName, password);
		if(a != null) {	
			session.put("admin", a);
			return SUCCESS;
		} 
		return INPUT;
	}
	
	@Override
	public void validate() {
		if(getAdminName()== null || getAdminName().trim().equals("")) {
			addFieldError("adminName", "必须输入用户名");
		}
		
		if(getPassword() == null || getPassword().trim().equals("")) {
			addFieldError("password", "必须输入密码");
		}
	}
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
