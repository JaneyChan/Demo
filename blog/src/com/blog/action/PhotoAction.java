package com.blog.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Album;
import com.blog.model.Photo;
import com.blog.service.AlbumService;
import com.blog.service.PhotoService;

public class PhotoAction extends BaseAction {
	
	private Integer albumId;
	private Integer photoId;
	private Album album;
	private String photoName;
	private String time;
	
	@Autowired
	@Qualifier("albumService")
	private AlbumService albumService;
	
	@Autowired
	@Qualifier("photoService")
	private PhotoService photoService;
	
	/**
	 * 删除照片
	 * */
	public String delete() {
		if(photoService.deletePhoto(photoId)) {
			return "allPhotos";
		}
		return "input";
	}
	
	/**
	 * 查找全部照片
	 */
	public String findAll(){
		List<Photo> photos = photoService.queryAll();
		getRequest().setAttribute("photos", photos);
		return "allPhotos";
	}
	
	/**
	 * 按相册查找照片
	 * */
	public String findByAlbum() {
		Album a = albumService.queryById(albumId);
		List<Photo> photos = photoService.findByAlbum(a);
		getRequest().setAttribute("photos", photos);
		getRequest().setAttribute("album", a);
		return "listPhoto";
	}
	
	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

}
