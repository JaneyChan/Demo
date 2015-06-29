package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Album;
import com.blog.model.Photo;

@Service("photoDao")
public class PhotoDao extends BaseDaoImpl {
	//上传照片
	public boolean add(Photo photo) {
		return save(photo);
	}
	
	//删除照片
	public boolean deletePhoto(int photoId) {
		String sql = "delete from photo where photo_id = " + photoId;
	    return deleteSQLUpdate(sql)==0?false:true;
	}
	
	//按ID查询照片
	public Photo queryById(int photoId) {
		return (Photo) getResultOne("from Photo p where p.photoId = ?", new Object[]{photoId});
	}
	
	//查询所有相册
	@SuppressWarnings("unchecked")
	public List<Photo> queryAll() {
		return (List<Photo>) getResult("from Photo",null);
	}
		
	//按相册分类查找照片
	public List<Photo> findByAlbum(Album album) {
		return (List<Photo>) getResult("from Photo p where p.album = ?", new Object[]{album});
	}
	
	//按相册ID删除照片
	public boolean deletePhotoByAlbum(int albumId) {
		String sql = "delete from photo where album_id = " + albumId;
	    return deleteSQLUpdate(sql)==0?false:true;
	}
}
