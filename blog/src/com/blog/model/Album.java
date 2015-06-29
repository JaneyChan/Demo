package com.blog.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Album entity. @author MyEclipse Persistence Tools
 */

public class Album implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private String albumName;
	private Set photos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Album() {
	}

	/** full constructor */
	public Album(String albumName, Set photos) {
		this.albumName = albumName;
		this.photos = photos;
	}

	// Property accessors

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Set getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set photos) {
		this.photos = photos;
	}

}