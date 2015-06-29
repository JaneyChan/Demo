package com.blog.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Article;
import com.blog.model.Category;
import com.blog.service.CategoryService;

public class CategoryAction extends BaseAction {
	private Integer cateId;
	private String cateName;
	private Integer articleNum;
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	public String add() {
		Category c = new Category();
		c.setCateName(cateName);
		if(categoryService.add(c)) {
			return "listCate";
		} 
		return "input";
	}

	/**
	 * 查找全部分类
	 * @return
	 */
	public String findAll(){
		List<Category> categorys = categoryService.queryAll();
		getRequest().setAttribute("allCategory", categorys);
		return "listCate";
	}
	
	/**
	 * 删除某个分类
	 * */
	public String delete() {
		Category c = categoryService.queryById(cateId);
		if(c != null) {
			if(categoryService.deleteCate(c)) {
				return "listCate";
			}
		}
		return "input";
	}
	
	//修改文章分类
	public String update() {
		Category c = categoryService.queryById(cateId);
		c.setCateName(cateName);
		if(c != null) {
			if(categoryService.update(c)) {
				return "listCate";
			}
		}
		return "input";
	}
	
	//按文章ID查找某一篇文章
	public String findById() {
		Category category = categoryService.queryById(cateId);
		if(category != null) {
			getRequest().setAttribute("category", category);
			return "findCateSucc";
		}
		return "success";
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Integer getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(Integer articleNum) {
		this.articleNum = articleNum;
	}

}
