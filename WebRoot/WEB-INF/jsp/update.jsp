<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
  <head> 
    <title>添加用户</title>
  </head>
  
  <body>
  
  	<sf:form method="post" modelAttribute="user">
  		Username:<sf:input path="username"/> <sf:errors path="username"/><br/>
  		Password:<sf:password path="password"/><sf:errors path="password"/><br/>
  		Nickname:<sf:input path="nickname"/><sf:errors path="nickname"/><br/>
  		Email:<sf:input path="email"/><sf:errors path="email"/><br/>
  		<input type="submit" value="修改用户">
  	</sf:form>
  </body>
</html>
