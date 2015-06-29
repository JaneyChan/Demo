<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="">
<head>
	<meta charset="utf-8">
	<title>分类管理</title>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" href="<%=path %>/css/style.css" media="all" />
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.css" media="all" />
	<script src="<%=path %>/js/jquery1.83.js" > </script>  
    <script src="<%=path %>/js/bootstrap-transition.js"></script>  
    <script src="<%=path %>/js/bootstrap-modal.js"></script>
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
	<link rel="shortcut icon" href="<%=path %>/images/favicon.ico" type="image/x-icon">
</head>
<body>
<div class="testing">
<header class="main">
	<h1><strong>个人博客系统</strong> 后台管理</h1>
</header>
<section class="user">
	<div class="profile-img">
		<p><img src="<%=path %>/images/uiface2.png" alt="" height="40" width="40" /> Welcome back John Doe</p>
	</div>
	<%-- <div class="buttons">
		 <span class="button blue"><a href="login.jsp">Logout</a></span>
	</div> --%>
</section>
</div>
<nav>
	<ul>
		<li><a href="<%=path %>/admin/index.jsp"><span class="icon">&#128711;</span>个人中心</a>
			<ul class="submenu">
				<li><a href="<%=path %>/admin/modifyPwd.jsp">修改密码</a></li>
				<li><a href="Admin_findByAdmin">修改个人信息</a></li>
			</ul>	
		</li>
		<li>
			<a href="<%=path %>/article/allArticle.jsp"><span class="icon">&#128196;</span>文章管理</a>
			<ul class="submenu">
				<li><a href="<%=path %>/article/addArticle.jsp">添加文章</a></li>
				<li><a href="<%=path %>/article/allArticle.jsp">文章列表</a></li>
			</ul>	
		</li>
		<li class="section"><a href="<%=path %>/category/category.jsp"><span class="icon">&#128202;</span>文章分类管理</a></li>
		<li>
			<a href="<%=path %>/comment/comment.jsp"><span class="icon">&#59160;</span>评论管理</a>
		</li>
		<li><a href="<%=path %>/board/board.jsp"><span class="icon">&#59168;</span>留言管理</a></li>
		<li>
			<a href="<%=path %>/album/photo.jsp"><span class="icon">&#127748;</span>相册管理</a>
			<ul class="submenu">
				<li><a href="<%=path %>/album/album.jsp">相册列表</a></li>
				<li><a href="<%=path %>/album/addPhoto.jsp">上传照片</a></li>
				<li><a href="<%=path %>/album/photo.jsp">照片列表</a></li>
			</ul>
		</li>
	</ul>
</nav>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128202;</span>
			<hgroup>
				<h1>分类管理</h1>
			</hgroup>
		</header>
		<s:action name="Category_findAll" executeResult="false" ignoreContextParams="false"></s:action>
		<div class="content">
			<div style="margin:0 0 10px 0">
				<a href="#myModal" role="button" class="btn" data-toggle="modal">创建分类</a>
			</div>
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>编号</th>
						<th>分类名</th>
						<th>操作</th>
						<!-- <th>Author</th> -->
					</tr>
				</thead>
					<s:if test="#request.allCategory.size() > 0">
					<tbody>
					<s:iterator value="#request.allCategory" var="cate">
						<tr>
							<td>${cate.cateId }</td>
							<td>${cate.cateName}</td>
							<td>
							<a href="Category_delete?cateId=${cate.cateId}">删除</a>/
							<a href="Category_findById?cateId=${cate.cateId}">修改</a></td>
						</tr>
					</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="4">您还未添加文章分类哦...</td>
						</tr>
					</s:else>
					</tbody>
					</tbody>
				</table>
		</div>
	</section>
</section>
<!-- Modal -->  
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
    <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
        <h2 id="myModalLabel">创建分类</h2>  
    </div>  
    <form action="Category_add" method="post">
    <div class="modal-body">  
         <input type="text" style="height: 40px; width:100%" placeholder="分类名" name="cateName"/>
    </div>  
    <div class="modal-footer">  
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>  
        <button class="btn btn-primary" type="submit">创建</button>  
    </div>  
    </form>
</div>  
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/js/custom.js"></script>
<script src="<%=path %>/js/jquery.tablesorter.min.js"></script>
</body>
</html>