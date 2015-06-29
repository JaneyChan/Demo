package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.AlbumDao;
import com.blog.model.Album;

@Service("albumService")
public class AlbumService {
	@Autowired
	@Qualifier("albumDao")
	private AlbumDao albumDao;
	
	//添加照片
	public boolean add(Album album) {
		return albumDao.add(album);
	}
		
	//更新相册
	public boolean update(Album album) {
		return albumDao.updateAlbum(album);
	}
	
	//删除相册
	public boolean deleteAlbum(Album album) {
		return albumDao.deleteAlbum(album);
	}
	
	//查询所有相册
	@SuppressWarnings("unchecked")
	public List<Album> queryAll() {
		return albumDao.queryAll();
	}
	
	//按ID查询相册
	public Album queryById(int albumId) {
		return albumDao.queryById(albumId);
	}
}
