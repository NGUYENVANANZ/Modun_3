<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/28/2022
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản Lí Nhân Viên</title>
</head>
<body>
<h1>
    <a href="Creat.jsp">Thêm nv!</a>
</h1>
<table border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>Age</td>
        <td>IMG</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhanViens}" var="nv">
        <tr>
            <td>${nv.getId()}</td>
            <td>${nv.getName()}</td>
            <td>${nv.getAge()}</td>
            <td><img src="${nv.getImg()}" width="250" height="250" alt="Mạng Yếu"></td>
            <td><a href="<c:url value="/NhanVienServlet?action=showEditNhanVien&id=${nv.getId()}"/>">edit</a></td>
            <td><a href="<c:url value="/NhanVienServlet?action=delete&id=${nv.getId()}"/>">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
