package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Article;

@Service("articleDao")
public class ArticleDao extends BaseDaoImpl {
	//添加一篇文章
	public boolean addArticle(Article article) {
		return save(article);
	}
	
	//删除一篇文章
	public boolean deleteArticle(int articleId) {
		String sql = "delete from article where article_id = " + articleId;
	    return deleteSQLUpdate(sql)==0?false:true;
	}
	
	//更新一篇文章
	public boolean updateArticle(Article article) {
		return update(article);
	}
	
	//查询所有文章
	@SuppressWarnings("unchecked")
	public List<Article> queryAll() {
		return (List<Article>) getResult("from Article a order by a.articleId desc",null);
	}
	
	//按ID查询文章
	public Article queryByID(int articleId) {
		return (Article)getResultOne("from Article a where a.articleId = ?", new Object[]{articleId});
	}
	
	//按分类查询文章
	public List<Article> queryByCate(int cateId) {
		return (List<Article>)getResult("from Category c where c.cateId = ?", new Object[]{cateId});
	}
	
}
