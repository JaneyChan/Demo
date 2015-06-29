package com.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Article;
import com.blog.model.Comment;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;


public class CommentAction extends BaseAction {
	
	private Integer commentId;
	private Article article;
	private String content;
	private String commentTime;
	private String userName;
	private String email;
	private Integer articleId;
	
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	
	@Autowired
	@Qualifier("articleService")
	private ArticleService articleService;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	//添加评论
	public String add() {
		Comment c = new Comment();
		article = articleService.queryByID(articleId);
		c.setArticle(article);
		c.setContent(content.trim());
		c.setUserName(userName.trim());
		c.setEmail(email.trim());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = sdf.format(new Date());
		c.setCommentTime(ctime);
		if(commentService.addComment(c)) {
			return "addCommSucc";
		}
		return "addCommFail";
	}
	
	//查找所有评论
	public String findAll() {
		List<Comment> comments = commentService.queryAll();
		getRequest().setAttribute("comments", comments);
		return "allComments";
	}
	
	//按ID删除评论
	public String delete() {
		if(commentService.deleteComment(commentId)) {
			return "deleCommentSucc";
		}
		return "success";
	}
	
	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	
}
