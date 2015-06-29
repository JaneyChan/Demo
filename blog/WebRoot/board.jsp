<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<title>留言墙|博客</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/frontstyle.css">
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
				<li class="menu-item current-menu-item"><a href="<%=path %>/index.jsp">首页</a></li>
				<li class="menu-item"><a href="<%=path %>/album.jsp">照片墙</a></li>
				<li class="menu-item"><a href="<%=path %>/board.jsp">留言板</a></li>
				<li class="menu-item"><a href="Admin_show">关于我</a></li>
			</ul>
		</div>
	</header>
	<div class="mainContent">
		<div class="blogitem" style="margin-left: 0;float: none;">
			<div class="content">
				<article class="post-67 page type-page status-publish hentry"
					style="margin-left: 0px;" id="post-67">
					<h2 class="title">
						<a class="slow" title="留言板">留言板</a><span class="edit"></span>
					</h2>
					<ul class="text">

						<p>
							<span style="font-size: medium; color: #000000;">有什么话要对我们说吗？这里是你畅所欲言的地方，可以咨询，可以交流，可以感叹，可以发飙，但不可以订外卖。</span><span
								style="color: #808080; font-size: small;">(关于链接交换，请在博客申请友链页面提出交换，若有不便之处敬请原谅。)</span>
						</p>

					</ul>
				</article>
			</div>
			<div id="comments">
				<div id="respond">
					<form action="Board_add"
						method="post" id="commentform">
						<div class="f-publish" id="real-avatar">
							<span> 
								<img src="images/default.png" class="avatar" height="50" width="50"></span>
							<textarea name="message" id="comment" tabindex="4"
								onkeydown="if(event.ctrlKey&&event.keyCode==13){document.getElementById('submit').click();return false};"
								placeholder="你想说点什么~"></textarea>
						</div>
							<input name="submit" type="submit" id="submit" tabindex="5"
								value="发布">
						<script type="text/javascript"
							src="js/realgravatar.js"></script>
						<div class="comment-show" style="display:none;">
							<ul>
								<li class="form-inline"><label><span style="color: red;">*&nbsp;</span>名称（必填）：</label> <input
									type="text" name="userName" id="author" value="" tabindex="1"></li>
								<li class="form-inline"><label><span style="color: red;">*&nbsp;</span>邮箱（必填）：</label> <input
									type="text" name="email" id="email" value="" tabindex="2"></li>
							</ul>
						</div>
					</form>
				</div>
				
				<s:action name="Board_findAll" executeResult="false" ignoreContextParams="false"></s:action>
				<p id="prompt">已经有 <s:property value='#request.listBoard.size()'/>人抢在你前面了~</p>
				<ul class="commentlist" style="display: block;">
					<s:iterator value="#request.listBoard" var="board">
					<li class="comment" id="li-comment-">
						<div class="comment_body">
							<div class="author">
								<img alt="" src="images/default.png" class="avatar photo" height="30" width="30">
							</div>
							<div class="comment_data">
								<span class="name">${board.userName }</span>
								<span class="time">${board.time }</span>
								<div class="comment_text">
									<p>${board.message }</p>
								</div>
							</div>
						</div>
					</li>
					</s:iterator>
				</ul>
			</div>
		</div>
	</div>

	<div id="back-to-top" class="red" data-scroll="body"
		style="display: block; opacity: 0.609071620698271;">
		<svg id="point-up" version="1.1" width="32" height="32"
			viewBox="0 0 32 32"> <path
				d="M23.588 17.637c-0.359-0.643-0.34-1.056-2.507-3.057 0.012-7.232-4.851-12.247-5.152-12.55 0-0.010 0-0.015 0-0.015s-0.003 0.003-0.007 0.007l-0.007-0.007c0 0 0 0.005 0 0.015-0.299 0.305-5.141 5.342-5.097 12.575-2.158 2.010-2.138 2.423-2.493 3.068-0.65 1.178-0.481 5.888 0.132 6.957 0.613 1.069 1.629 0.293 1.977-0.004 0.348-0.298 1.885-2.264 2.263-2.176 0 0 0.465-0.090 0.989 0.414 0.518 0.498 1.462 0.966 2.27 1.033 0 0.001 0 0.002-0 0.003 0.005-0.001 0.010-0.001 0.015-0.002 0.005 0 0.010 0.001 0.015 0.001 0-0.001-0-0.002 0-0.003 0.808-0.070 1.749-0.543 2.265-1.043 0.522-0.507 0.988-0.419 0.988-0.419 0.378-0.090 1.923 1.869 2.272 2.165 0.35 0.296 1.369 1.067 1.977-0.005 0.608-1.072 0.756-5.783 0.101-6.958v0 0zM15.95 14.86c-1.349 0.003-2.445-1.112-2.448-2.492-0.003-1.38 1.088-2.5 2.437-2.503 1.349-0.003 2.445 1.112 2.448 2.492 0.003 1.379-1.088 2.5-2.437 2.503v0 0zM17.76 24.876c-0.615 0.474-1.236 0.633-1.801 0.626-0.566 0.009-1.187-0.147-1.804-0.617-0.553-0.403-1.047-0.348-1.308 0.003-0.261 0.351-0.169 2.481 0.152 2.939 0.321 0.458 0.697-0.298 1.249-0.327 0.552-0.028 1.011 1.103 1.221 1.75 0.107 0.331 0.274 0.633 0.5 0.654 0.226-0.023 0.392-0.326 0.497-0.657 0.207-0.648 0.661-1.781 1.213-1.756 0.553 0.026 0.932 0.78 1.251 0.321 0.319-0.459 0.401-2.59 0.139-2.94-0.262-0.35-0.757-0.403-1.308 0.003v0 0z"
				fill="#CCCCCC"></path> </svg>
	</div>
	<footer>
		<div class="footavatar">
			<img src="images/logo.jpg" class="footphoto">
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
	<script type="text/javascript" src="js/jquery.js"></script>
</body>
</html>