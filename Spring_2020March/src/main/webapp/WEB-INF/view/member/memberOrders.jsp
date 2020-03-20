<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원 주문 목록</title>
</head>
<body>

${member.name}님의 주문 목록 : <br>

<ul>
	<c:forEach var="order" items="${orders }">
		<li>
			<a href="<%=request.getContextPath()%>/members/${order.memberId}/order/${orderId}">	${order.id }</a>
		</li>
	</c:forEach>
</ul>
</body>
</html>