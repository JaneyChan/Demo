package com.blog.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Admin;
import com.blog.model.Admininfo;
import com.blog.service.AdminService;

public class AdminAction extends BaseAction {
	
	private Integer infoId;
	private Admin admin;
	private String nickName;
	private String nativePlace;
	private String address;
	private String decription;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	//修改个人信息
	public String update() {
		Admin admin = (Admin) session.get("admin");
		if(admin == null) {
			return "login";
		}
		System.out.println(admin == null);
		Admininfo info = adminService.findByAdmin(admin);
		if(info != null) { //如果不是第一次修改个人信息，则进行修改操作
			info.setAdmin(admin);
			info.setAddress(address.trim());
			info.setDecription(decription.trim());
			info.setNativePlace(nativePlace.trim());
			info.setNickName(nickName.trim());
			if(adminService.updateInfo(info)) {
				return "index";
			}
		} else { //否则进行增加个人信息
			info = new Admininfo();
			info.setAdmin(admin);
			info.setAddress(address.trim());
			info.setDecription(decription);
			info.setNativePlace(nativePlace.trim());
			info.setNickName(nickName.trim());
			if(adminService.addInfo(info)) {
				return "index";
			}
		}
		return "findSucc";
	}
	
	//根据Session中的"admin"对象，查找个人信息
	public String findByAdmin() {
		Admin admin = (Admin) session.get("admin");
		if(admin == null) {
			return "login";
		}
		Admininfo info = adminService.findByAdmin(admin);
		getRequest().setAttribute("info", info);
		return "findSucc";
	}
	
	public String show() {
		List<Admininfo> infos = adminService.findInfo();
		getRequest().setAttribute("info", infos.get(0));
		return "show";
	}
	

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
	
}
