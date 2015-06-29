package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Article;
import com.blog.model.Comment;

@Service("commentDao")
public class CommentDao extends BaseDaoImpl {
	//添加评论
	public boolean addComment(Comment comment) {
		return save(comment);
	}
	
	//删除评论
	public boolean deleteComment(int commentId) {
		String sql = "delete from comment where comment_id = " + commentId;
	    return deleteSQLUpdate(sql)==0?false:true;
	}
	
	//删除评论
	public void deleteByArticle(int articleId) {
		String sql = "delete from comment where article_id = " + articleId;
	    deleteSQLUpdate(sql);
	}
	
	//按文章ID查找指定文章的全部评论
	public List<Comment> queryByArticle(Article article){
		return (List<Comment>) getResult("from Comment c where c.article = ? order by c.commentId desc", new Object[]{article});
	}
	
	//获取所有文章的评论
	public List<Comment> queryAll() {
		return (List<Comment>) getResult("from Comment c order by c.commentId desc", null);
	}
}
