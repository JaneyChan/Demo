package com.blog.model;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */

public class Photo implements java.io.Serializable {

	// Fields

	private Integer photoId;
	private Album album;
	private String photoName;
	private String time;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(Album album, String photoName, String time) {
		this.album = album;
		this.photoName = photoName;
		this.time = time;
	}

	// Property accessors

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getPhotoName() {
		return this.photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}