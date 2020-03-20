<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>이벤트 정보</title>
</head>
<body>

이벤트 정보 : <br>
<ul>
	<li>ID : ${event.id }</li>
	<li>Name : ${event.name}
</ul>

<ul>
	<c:forEach var="event" items="${recEventList }" >
		<li><a href="<%=request.getContextPath()%>event/detail?id=${event.id }">${event.name }</a></li>
	</c:forEach>
</ul>
</body>
</html>