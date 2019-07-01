<%@page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
>>修改年级
<form method="post" name="s" action="updateGrade">
    年级名称:<input type="text" name="gname" value="${grade.gname}" /><br/>
    <input type="hidden" name="gid" value="${grade.gid}">
    <input type="submit" name="ss" value="修改" />
</form>
</body>
</html>
