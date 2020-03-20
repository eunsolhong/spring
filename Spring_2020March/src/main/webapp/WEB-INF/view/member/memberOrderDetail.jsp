<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

${member.name }님의 ${order.id} 주문 :
<ul>
	<li>전체 가격 : ${order.totalPrice }</li>
</ul>

</body>
</html>