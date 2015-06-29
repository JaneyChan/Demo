package com.blog.model;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Board implements java.io.Serializable {

	// Fields

	private Integer boardId;
	private String message;
	private String time;
	private String userName;
	private String email;

	// Constructors

	/** default constructor */
	public Board() {
	}

	/** full constructor */
	public Board(Integer boardId, String message, String time,
			String userName, String email) {
		super();
		this.boardId = boardId;
		this.message = message;
		this.time = time;
		this.userName = userName;
		this.email = email;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setboardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Property accessors
	
	
}