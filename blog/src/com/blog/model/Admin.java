package com.blog.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String password;
	private Set admininfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String adminName, String password, Set admininfos) {
		this.adminName = adminName;
		this.password = password;
		this.admininfos = admininfos;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getAdmininfos() {
		return this.admininfos;
	}

	public void setAdmininfos(Set admininfos) {
		this.admininfos = admininfos;
	}

}