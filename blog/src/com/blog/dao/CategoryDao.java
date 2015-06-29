package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Category;

@Service("categoryDao")
public class CategoryDao extends BaseDaoImpl {
	//添加分类
	public boolean add(Category category) {
		return save(category);
	}
	
	//更新分类
	public boolean updateCate(Category category) {
		return update(category);
	}
	
	//删除分类
	public boolean deleteCate(Category category) {
		return delete(category);
	}
	
	//查询所有分类
	@SuppressWarnings("unchecked")
	public List<Category> queryAll() {
		return (List<Category>) getResult("from Category",null);
	}
	
	//按ID查询分类
	public Category queryById(int cateId) {
		return (Category) getResultOne("from Category c where c.cateId = ?", new Object[]{cateId});
	}
}
