package com.blog.model;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Article article;
	private String content;
	private String commentTime;
	private String userName;
	private String email;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Article article, String content, String commentTime,
			String userName, String email) {
		this.article = article;
		this.content = content;
		this.commentTime = commentTime;
		this.userName = userName;
		this.email = email;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}