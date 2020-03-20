<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원 목록</title>
</head>
<body>

<ul>
	<c:forEach var="mi" items="${members }">
		<li> <a href="/Spring_2020March/members/${mi.id }">${mi.name }</a></li>
	</c:forEach>
</ul>
</body>
</html>