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
	<title>相册管理</title>
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
		<li><a href="<%=path %>/category/category.jsp"><span class="icon">&#128202;</span>文章分类管理</a></li>
		<li>
			<a href="<%=path %>/comment/comment.jsp"><span class="icon">&#59160;</span>评论管理</a>
		</li>
		<li><a href="<%=path %>/board/board.jsp"><span class="icon">&#59168;</span>留言管理</a></li>
		<li class="section">
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
				<h1>照片管理</h1>
			</hgroup>
		</header>
		<s:action name="Photo_findAll" executeResult="false" ignoreContextParams="false"></s:action>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>照片名称</th>
						<th>上传时间</th>
						<th>照片</th>
						<th>操作</th>
						<!-- <th>Author</th> -->
					</tr>
				</thead>
					<s:if test="#request.photos.size() > 0">
					<tbody>
					<s:iterator value="#request.photos" var="photo">
						<tr>
							<td>${photo.photoName }</td>
							<td>${photo.time}</td>
							<td><img src="<%=path %>/upload/${photo.photoName}" width="56px" height="42px"/></td>
							<td><a href="Photo_delete?photoId=${photo.photoId}">删除</a></td>
						</tr>
					</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="5">您还未上传照片哦</td>
						</tr>
					</s:else>
					</tbody>
					</tbody>
				</table>
		</div>
	</section>
</section>
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/js/custom.js"></script>
<script src="<%=path %>/js/jquery.tablesorter.min.js"></script>
</body>
</html>