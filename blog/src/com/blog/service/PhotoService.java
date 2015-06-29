package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.PhotoDao;
import com.blog.model.Album;
import com.blog.model.Photo;

@Service("photoService")
public class PhotoService {
	@Autowired
	@Qualifier("photoDao")
	private PhotoDao photoDao;
	//上传照片
	public boolean add(Photo photo) {
		return photoDao.add(photo);
	}
	
	//按相册分类查找照片
	public List<Photo> findByAlbum(Album album) {
		return photoDao.findByAlbum(album);
	}
	
	//按ID查询照片
	public Photo queryById(int photoId) {
		return photoDao.queryById(photoId);
	}
	
	//查找所有照片
	public List<Photo> queryAll() {
		return photoDao.queryAll();
	}
	
	//删除照片
	public boolean deletePhoto(int photoId) {
		return photoDao.deletePhoto(photoId);
	}
	
	//按相册ID删除照片
	public boolean deletePhotoByAlbum(int albumId) {
		return photoDao.deletePhotoByAlbum(albumId);
	}
}
