package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.ArticleDao;
import com.blog.model.Article;

@Service("articleService")
public class ArticleService {
	@Autowired
	@Qualifier("articleDao")
	private ArticleDao articleDao;
	
	//添加一篇文章
	public boolean addArticle(Article article) {
		return articleDao.addArticle(article);
	}
	
	//删除一篇文章
	public boolean deleteArticle(int articleId) {
		return articleDao.deleteArticle(articleId);
	}
	
	//更新一篇文章
	public boolean updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}
	
	//查询所有文章
	public List<Article> queryAll() {
		return articleDao.queryAll();
	}

	//按ID查询文章
	public Article queryByID(int articleId) {
		return articleDao.queryByID(articleId);
	}
	
	//按分类查询文章
	public List<Article> queryByCate(int cateId) {
		return articleDao.queryByCate(cateId);
	}
}
