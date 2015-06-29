package com.blog.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Admin;
import com.blog.service.AdminService;

public class ModifyAction extends BaseAction {
	private String oldPassword;
	private String newPassword;
	private String rePassword;
	private Admin admin;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	//修改密码
	@Override
	public String execute() throws Exception {
		admin = (Admin) session.get("admin");
		
		admin.setPassword(newPassword);
		if(adminService.modifyPwd(admin)) {
			return "index";
		}
		return "modifyPwdFail";
	}
	
	@Override
	public void validate() {
		admin = (Admin) session.get("admin");
		if(admin == null) {
			addFieldError("oldPassword", "请先登录");
		} else if(getOldPassword()== null || getOldPassword().trim().equals("")) {
			addFieldError("oldPassword", "必须输入原来的密码");
		} else if(!getOldPassword().trim().equals(admin.getPassword().trim())) {
			addFieldError("oldPassword", "与原来的密码不一致");
		}
		
		if(getNewPassword() == null || getNewPassword().trim().equals("")) {
			addFieldError("newPassword", "必须输入新的密码");
		}
		
		if(getRePassword() == null || getRePassword().trim().equals("")) {
			addFieldError("rePassword", "必须输入确认密码");
		} else if(!getRePassword().trim().equals(getNewPassword().trim())) {
			addFieldError("rePassword", "确认密码与新的密码不一致");
		}
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
