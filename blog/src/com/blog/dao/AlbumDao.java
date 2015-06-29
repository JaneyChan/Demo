package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Album;

@Service("albumDao")
public class AlbumDao extends BaseDaoImpl {
	//添加相册
	public boolean add(Album album) {
		return save(album);
	}
	
	//更新相册
	public boolean updateAlbum(Album album) {
		return update(album);
	}
	
	//删除相册
	public boolean deleteAlbum(Album album) {
		return delete(album);
	}
	
	//查询所有相册
	@SuppressWarnings("unchecked")
	public List<Album> queryAll() {
		return (List<Album>) getResult("from Album",null);
	}
	
	//按ID查询相册
	public Album queryById(int albumId) {
		return (Album) getResultOne("from Album a where a.albumId = ?", new Object[]{albumId});
	}
}
