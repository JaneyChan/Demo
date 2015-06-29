package com.blog.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private String title;
	private String content;
	private Integer cateId;
	private String publishTime;
	private String hasRead;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** full constructor */
	public Article(String title, String content, Integer cateId,
			String publishTime, String hasRead, Set comments) {
		this.title = title;
		this.content = content;
		this.cateId = cateId;
		this.publishTime = publishTime;
		this.hasRead = hasRead;
		this.comments = comments;
	}

	// Property accessors

	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCateId() {
		return this.cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getHasRead() {
		return this.hasRead;
	}

	public void setHasRead(String hasRead) {
		this.hasRead = hasRead;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}