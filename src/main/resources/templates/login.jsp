<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转到主页</title>
</head>
<body>
    <form id="user" action="${pageContext.request.contextPath }/login" method="post">
    用户名：<input type="text" name="userAccounts" value="admin">
    密码：<input type="password" name="userPassword" value="admin">
    <input type="submit" value="提交">
</form>

</body>
</html>