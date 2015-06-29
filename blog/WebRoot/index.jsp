<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<title>首页|博客</title>
<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/frontstyle.css">
<link rel="shortcut icon" href="<%=path %>/images/favicon.ico" type="image/x-icon">
</head>
<body>
	<header class="l-header"
		style="background-image:url(images/header.jpg);">
		<div class="hdbg"></div>
		<div class="hdbg2"></div>
		<div class="m-about">
			<div id="logo">
				<div class="playerd">
					<div id="pic" center="center;" class="">
						<img src="images/logo.jpg">
					</div>
				</div>
			</div>
			<h1 class="tit">
				<a href="#">交流故事，沟通想法*</a>
			</h1>
			<div class="about">分享音乐，分享心情，分享感动！</div>

		</div>
		<div class="m-nav">
			<ul class="nav">
				<li class="menu-item current-menu-item"><a href="index.jsp">首页</a></li>
				<li class="menu-item"><a href="album.jsp">照片墙</a></li>
				<li class="menu-item"><a href="board.jsp">留言板</a></li>
				<li class="menu-item"><a href="Admin_show">关于我</a></li>
			</ul>
		</div>
	</header>
	<div class="mainContent">

		<div class="jsc-sidebar" id="jsi-nav">
			<aside class="sidebar">
				<div class="cbl-logo">
					<div class="a-avatar">
						<a href="#"
							style="background:url(images/logo.jpg) no-repeat;background-size:160px 160px;"><span>欲思博客</span></a>
					</div>
				</div>
				<div class="m-sidebar">
					<section class="topspaceinfo">
						<h1>善良的人永远是受苦的</h1>
						<p>然而，宝剑锋从磨砺出，梅花香苦自苦寒来...</p>
						<p style="&lt;/p"></p>
					</section>
					<div class="userinfo">
						<p class="q-fans">
							公告：我的主博客地址 » <a href="index.jsp" title="我的主博客地址">欲思博客</a>
						</p>
					</div>

					<s:action name="Article_findAll" executeResult="false" ignoreContextParams="false"></s:action>
					<section class="widget widget_recent_entries">
						<h2 class="widget_tit">近期文章</h2>
						<ul>
							<s:subset source="#request.articles" start="0" count="5">
							<s:iterator var="art">
								<li><a href="Article_show?articleId=${art.articleId}">${art.title}</a></li>
							</s:iterator>
							</s:subset>
						</ul>
					</section>
					
					<s:action name="Board_findAll" executeResult="false" ignoreContextParams="false"></s:action>
					<section class="widget f_comment">
						<h2 class="widget_tit">最新留言</h2>
						<s:subset source="#request.listBoard" start="0" count="5">
						<s:iterator var="board">
							<div class="all-comments">
								<a href="board.jsp"><img alt="" src="images/default.png" class="avatar photo" height="36" width="36" />${board.userName }
								<span class="muted">${board.time}<br />${board.message}</span></a>
							</div>
							
						</s:iterator>
						</s:subset>
					</section>
					
				</div>
			</aside>
		</div>

		<div class=" jsc-sidebar-content jsc-sidebar-pulled">
			<div class="m-header">
				<a class="m-menu jsc-sidebar-trigger"></a> <a href="#">欲思博客</a> <a
					href="index.jsp" class="m-admin"></a>
			</div>
			<div class="blogitem">

				<s:action name="Article_findAll" executeResult="false" ignoreContextParams="false"></s:action>
				<s:iterator value="#request.articles" var="art">
				<!-- <article
					class="post type-post status-publish format-standard hentry category-wordpress"> -->
					<article>
					<h2 class="title">
						<a class="slow" href="Article_show?articleId=${art.articleId}"
							title="详细阅读  ${art.title}">${art.title}</a>
					</h2>
					<ul class="text">
						<p>
						${art.content }
						</p>
					</ul>
					<div class="textfoot">
						<a>${art.publishTime }</a>
						<a href="Article_show?articleId=${art.articleId}"
							title="详细阅读 ${art.title}">阅读全文</a>
					</div>
				</article>
				</s:iterator>
				
				<div class="pages"></div>
			</div>
		</div>
	</div>

	<div id="back-to-top" class="red" data-scroll="body"
		style="display: block; opacity: 0.609071620698271;">
		<svg id="point-up" version="1.1" xmlns="http://www.w3.org/2000/svg"
			xmlns:xlink="http://www.w3.org/1999/xlink" width="32" height="32"
			viewBox="0 0 32 32"> <path
				d="M23.588 17.637c-0.359-0.643-0.34-1.056-2.507-3.057 0.012-7.232-4.851-12.247-5.152-12.55 0-0.010 0-0.015 0-0.015s-0.003 0.003-0.007 0.007l-0.007-0.007c0 0 0 0.005 0 0.015-0.299 0.305-5.141 5.342-5.097 12.575-2.158 2.010-2.138 2.423-2.493 3.068-0.65 1.178-0.481 5.888 0.132 6.957 0.613 1.069 1.629 0.293 1.977-0.004 0.348-0.298 1.885-2.264 2.263-2.176 0 0 0.465-0.090 0.989 0.414 0.518 0.498 1.462 0.966 2.27 1.033 0 0.001 0 0.002-0 0.003 0.005-0.001 0.010-0.001 0.015-0.002 0.005 0 0.010 0.001 0.015 0.001 0-0.001-0-0.002 0-0.003 0.808-0.070 1.749-0.543 2.265-1.043 0.522-0.507 0.988-0.419 0.988-0.419 0.378-0.090 1.923 1.869 2.272 2.165 0.35 0.296 1.369 1.067 1.977-0.005 0.608-1.072 0.756-5.783 0.101-6.958v0 0zM15.95 14.86c-1.349 0.003-2.445-1.112-2.448-2.492-0.003-1.38 1.088-2.5 2.437-2.503 1.349-0.003 2.445 1.112 2.448 2.492 0.003 1.379-1.088 2.5-2.437 2.503v0 0zM17.76 24.876c-0.615 0.474-1.236 0.633-1.801 0.626-0.566 0.009-1.187-0.147-1.804-0.617-0.553-0.403-1.047-0.348-1.308 0.003-0.261 0.351-0.169 2.481 0.152 2.939 0.321 0.458 0.697-0.298 1.249-0.327 0.552-0.028 1.011 1.103 1.221 1.75 0.107 0.331 0.274 0.633 0.5 0.654 0.226-0.023 0.392-0.326 0.497-0.657 0.207-0.648 0.661-1.781 1.213-1.756 0.553 0.026 0.932 0.78 1.251 0.321 0.319-0.459 0.401-2.59 0.139-2.94-0.262-0.35-0.757-0.403-1.308 0.003v0 0z"
				fill="#CCCCCC"></path> </svg>
	</div>
	<footer>
		<div class="footavatar">
			<img src="<%=path %>/images/logo.jpg" class="footphoto">
			<ul class="footinfo">
				<p class="fname">
					<a>欲思博客</a>
				</p>
				<p class="finfo">分享音乐，分享心情，分享感动，相信你所听到的声音，相信你所看到的文字.我在这里，爱在发烧~</p>
				<ul>
				</ul>
			</ul>
		</div>
		<div class="Copyright">
			<p>© 2014 欲思博客Powered by WordPress Theme forget</p>
		</div>
	</footer>
	<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
</body>
</html>