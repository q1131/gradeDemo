<%@page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<a href="add.jsp">添加年级</a>
<h2>所有年级</h2>
<table>
    <tr>
        <td>年级编号</td>
        <td>年级名称</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="g">
        <tr>
            <td>${g.gid}</td>
            <td>${g.gname}</td>
            <td><a href="delGrade?gid=${g.gid}">删除</a>
                <a href="getGrade?gid=${g.gid}">修改</a>
                <a href="showStudent?gid=${g.gid}">查看学生</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
