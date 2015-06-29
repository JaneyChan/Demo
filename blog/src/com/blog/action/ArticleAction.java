package com.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Article;
import com.blog.model.Category;
import com.blog.model.Comment;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.CommentService;

public class ArticleAction extends BaseAction {
	
	private Integer articleId;
	private String title;
	private String content;
	private Integer cateId;
	private String publishTime;
	@Autowired
	@Qualifier("articleService")
	private ArticleService articleService;

	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	//添加文章
	public String add() {
		Article a = new Article();
		a.setTitle(title.trim());
		a.setCateId(cateId);
		a.setContent(content.trim());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		a.setPublishTime(date);
		if(articleService.addArticle(a)) {
			return "allArticle";
		}
		return "input";
	}
	
	//修改文章
	public String update() {
		Article a = articleService.queryByID(articleId);
		a.setTitle(title.trim());
		a.setCateId(cateId);
		a.setContent(content.trim());
		if(articleService.updateArticle(a)) {
			return "allArticle";
		}
		return "input";
	}
	
	//查找所有文章
	public String findAll() {
		List<Article> articles = articleService.queryAll();
		getRequest().setAttribute("articles", articles);
		return "allArticles";
	}
	
	//按文章ID查找某一篇文章
	public String findById() {
		Article article = articleService.queryByID(articleId);
		if(article != null) {
			getRequest().setAttribute("article", article);
			return "findArticleSucc";
		}
		return "success";
	}
	
	//按文章ID在前台页面显示某一篇文章，及该文章下的所有评论
	public String show() {
		Article article = articleService.queryByID(articleId);
		
		if(article != null) {
			//查找该文章的所有评论
			List<Comment> comments = null;
			comments = commentService.queryByArticle(article);
			getRequest().setAttribute("article", article);
			getRequest().setAttribute("comments", comments);
		}
		
		Category category = categoryService.queryById(article.getCateId());
		getRequest().setAttribute("category", category);
		
		return "showArticle";
	}
	
	public String delete() {
		//按文章ID删除评论
		commentService.deleteByArticle(articleId);
		//按文章ID删除文章
		if(articleService.deleteArticle(articleId)) {
			return "allArticle";
		}
		return "input";
	}
	
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

}
