<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>用户列表</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>
<body>
	<a href="add">添加</a>--->${loginUser.username }
	<br />
	<c:forEach items="${users }" var="um">
  	${um.value.username }
  	----<a href="${um.value.username }">${um.value.nickname }</a>
  	----${um.value.password }
  	----${um.value.email } 
  	<a href="${um.value.username }/update">修改</a>
	<a href="${um.value.username }/delete">删除</a>
	<br />
	</c:forEach>
	<input type="file" name="attach"/>
</body>
</html>
