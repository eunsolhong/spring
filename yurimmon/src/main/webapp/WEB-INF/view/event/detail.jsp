<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 정보</title>
</head>
<body>

	<ul>
		<li>ID : ${event.id}</li>
		<li>이름 : ${event.name}</li>
	</ul>
	추천 이벤트 :
	<ul>
		<c:forEach var="event" items="${recEventList}">
			<li><a
				href="<%=request.getContextPath()%>event/detail?id=${event.id}">${event.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>