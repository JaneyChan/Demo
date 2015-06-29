package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.model.Category;

@Service("categoryService")
public class CategoryService {
	@Autowired
	@Qualifier("categoryDao")
	private CategoryDao categoryDao;
	
	//添加分类
	public boolean add(Category category) {
		return categoryDao.add(category);
	}
	
	//更新分类
	public boolean update(Category category) {
		return categoryDao.updateCate(category);
	}
	
	//删除分类
	public boolean deleteCate(Category category) {
		return categoryDao.deleteCate(category);
	}
	
	//查询所有分类
	public List<Category> queryAll() {
		return categoryDao.queryAll();
	}
	
	//按ID查询分类
	public Category queryById(int cateId) {
		return categoryDao.queryById(cateId);
	}
}
