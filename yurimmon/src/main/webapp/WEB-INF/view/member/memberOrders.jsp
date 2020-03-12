<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Orders</title>
</head>
<body>

	${member.name}님의 주문목록 :
	<ul>
		<c:forEach var="order" items="${orders}">
			<li><a
				href="<%=request.getContextPath() %>/members/${order.memberId}/orders/${order.id}">${order.id}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>