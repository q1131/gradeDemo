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
    <c:forEach items="${pageInfo.list}" var="g">
        <tr>
            <td>${g.gid}</td>
            <td>${g.gname}</td>
            <td><a href="delGrade?gid=${g.gid}">删除</a>
                <a href="getGrade?gid=${g.gid}">修改</a></td>
        </tr>
    </c:forEach>
</table>
当前是第${pageInfo.pageNum}页，共${pageInfo.pages}页，每页${pageInfo.pageSize}条，共${pageInfo.total}条记录<br/>
<br/>
<a href="showGrade2?page=1">首页</a>
<a href="showGrade2?page=${pageInfo.prePage==0?1:pageInfo.prePage}">上一页</a>
<a href="showGrade2?page=${pageInfo.nextPage==pageInfo.pages?pageInfo.pages:pageInfo.nextPage}">下一页</a>
<a href="showGrade2?page=${pageInfo.pages}">尾页</a>
<br/>
<select onchange="location.href='showGrade2?page='+this.value;">
    <!-- <option>请选择页码</option>-->
     <c:forEach begin="1" var="i" end="${pageInfo.pages}" step="1">
     <option <c:if test="${pageInfo.pageNum==i}">selected=selected</c:if>  value="${i}">第${i}页</option>
     </c:forEach>
</select>



</body>
</html>
