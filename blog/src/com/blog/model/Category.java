package com.blog.model;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer cateId;
	private String cateName;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */

	public Category(Integer cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}
	
	// Property accessors

	public Integer getCateId() {
		return this.cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

}