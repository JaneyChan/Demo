package com.blog.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Album;
import com.blog.model.Category;
import com.blog.model.Photo;
import com.blog.service.AlbumService;
import com.blog.service.PhotoService;

public class AlbumAction extends BaseAction {
	
	private Integer albumId;
	private String albumName;
	
	@Autowired
	@Qualifier("albumService")
	private AlbumService albumService;
	
	@Autowired
	@Qualifier("photoService")
	private PhotoService photoService;
	
	public String add() {
		Album a = new Album();
		a.setAlbumName(albumName);
		if(albumService.add(a)) {
			return "addAlbumSucc";
		} 
		return "fail";
	}

	/**
	 * 查找全部相册
	 * @return
	 */
	public String findAll(){
		List<Album> albums = albumService.queryAll();
		getRequest().setAttribute("albums", albums);
		return "listAlbum";
	}
	
	/**
	 * 删除某个相册
	 * */
	public String delete() {
		Album a = albumService.queryById(albumId);
		if(a != null) {
			if(photoService.deletePhotoByAlbum(albumId)) {
				if(albumService.deleteAlbum(a)) {
					return "listAlbum";
				}
			}
		}
		return "input";
	}
	
	//按ID查找相册
	public String findById() {
		Album album = albumService.queryById(albumId);
		if(album != null) {
			getRequest().setAttribute("album", album);
			return "findAlbumSucc";
		}
		return "success";
	}
	
	//更新相册
	public String update() {
		Album a = albumService.queryById(albumId);
		a.setAlbumName(albumName);
		if(a != null) {
			if(albumService.update(a)) {
				return "listAlbum";
			}
		}
		return "input";
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

}
