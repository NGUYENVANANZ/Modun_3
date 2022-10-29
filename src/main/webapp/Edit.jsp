<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/29/2022
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/NhanVienServlet">
    ID: <input name="id" value="${newNhanvien.id}">
    NAME:<input name="name"  value="${newNhanvien.name}">
    AGE:<input name="age"  value="${newNhanvien.age}">
    IMG:<input name="img"  value="${newNhanvien.img}">
    <button name="action" value="Edit">Sửa!</button>
</form>
</body>
</html>
