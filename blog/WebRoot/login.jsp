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
	<title>Retina Dashboard</title>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" href="<%=path %>/css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
<link rel="shortcut icon" href="<%=path %>/images/favicon.ico" type="image/x-icon">
</head>
<body class="login">
	<section style="color:#ffffff;">
		<h1><strong>My Blog</strong></h1>
		<s:form action="Login" method="post">
		    <h1><s:textfield name="adminName" label="用户名"/></h1>
		    <h1><s:password name="password" label="密码"/></h1>
	    	<h1><s:submit value="登录" cssClass="blue"/></h1>
    	</s:form>
	</section>
<script src="<%=path %>/js/jquery.min.js"></script>
</body>
</html>