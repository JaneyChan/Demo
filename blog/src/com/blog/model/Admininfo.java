package com.blog.model;

/**
 * Admininfo entity. @author MyEclipse Persistence Tools
 */

public class Admininfo implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private Admin admin;
	private String nickName;
	private String nativePlace;
	private String address;
	private String decription;

	// Constructors

	/** default constructor */
	public Admininfo() {
	}

	/** full constructor */
	public Admininfo(Admin admin, String nickName, String nativePlace,
			String address, String decription) {
		this.admin = admin;
		this.nickName = nickName;
		this.nativePlace = nativePlace;
		this.address = address;
		this.decription = decription;
	}

	// Property accessors

	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

}