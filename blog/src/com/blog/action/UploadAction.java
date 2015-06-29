package com.blog.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Album;
import com.blog.model.Photo;
import com.blog.service.PhotoService;


public class UploadAction  extends BaseAction {
	private static final int BUFFER_SIZE = 16 * 1024;
	private Integer albumId;
	// 上传文件域对象
	private File upload;
	// 上传文件名
	private String uploadFileName;
	// 上传文件类型
	private String uploadContentType;
	// 保存文件的目录路径
	private String savePath;

	@Autowired
	@Qualifier("photoService")
	private PhotoService photoService;
	
	// 把源文件对象复制成目标文件对象
	private static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override 
    public String execute() throws Exception { 
        System.out.println("upload");
        System.out.println(albumId);
		//根据服务器的文件保存地址和原文件名创建目录文件全路径 
        String dstPath = ServletActionContext.getServletContext() 
                                .getRealPath(this.getSavePath()) 
                                + "/" + this.getUploadFileName(); 
       
        System.out.println("上传的文件的类型："+ this.getUploadContentType()); 
        File dstFile = new File(dstPath); 
        copy(this.upload, dstFile); 
        Photo p = new Photo();
        p.setPhotoName(uploadFileName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
        p.setTime(date);
        
        Album a = new Album();
        a.setAlbumId(albumId);
        p.setAlbum(a);
        
        
        photoService.add(p);
        return SUCCESS;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
}
