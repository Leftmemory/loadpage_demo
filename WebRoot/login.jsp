<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
  <head> 
    <title>添加用户</title>
  </head>
  
  <body>
  
  	<form method="post" action="user/login">
  		Username:<input type="text" name="username"/><br/>
  		Password:<input type="password" name="password"/><br/>

  		<input type="submit" value="登录">
  	<form>
  </body>
</html>
