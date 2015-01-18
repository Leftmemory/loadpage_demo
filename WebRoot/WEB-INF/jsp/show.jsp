<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>用户列表</title>
  </head>
  
  <body>
  <br/>

  	Username:${user.username }<br/>
  	Password:${user.password }<br/>
  	Nickname:${user.nickname }<br/>
  	Email:${user.email }<br/>
  </body>
</html>
