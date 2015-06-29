package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.CommentDao;
import com.blog.model.Article;
import com.blog.model.Comment;

@Service("commentService")
public class CommentService {
	@Autowired
	@Qualifier("commentDao")
	private CommentDao commentDao;
	
	//添加评论
	public boolean addComment(Comment comment) {
		return commentDao.addComment(comment);
	}
	
	//删除评论
	public boolean deleteComment(int commentId) {
		return commentDao.deleteComment(commentId);
	}
	
	//删除评论
	public void deleteByArticle(int articleId) {
		commentDao.deleteByArticle(articleId);
	}
	
	//按文章ID查找指定文章的全部评论
	public List<Comment> queryByArticle(Article article){
		return commentDao.queryByArticle(article);
	}
	
	//获取所有文章的评论
	public List<Comment> queryAll() {
		return commentDao.queryAll();
	}
}
