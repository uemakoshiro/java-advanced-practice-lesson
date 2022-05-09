<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<c:if test="${result eq 'miss'}">
  <p>IDまたはPASSが間違っています</p>
</c:if>

<div>
  <form action="login" method="post">
    <div>ID: <input type="text" name="id">
      <c:if test="${idEmp eq 'true'}">
         IDは必須です
      </c:if></div>
    
    <div>PASS: <input type="password" name="password">
      <c:if test="${passEmp eq 'true'}">
         PASSは必須です
      </c:if></div>
    
    <div><button type="submit">ログイン</button></div>
  </form>
</div>
</body>
</html>
