<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOrderDetail</title>
</head>
<body>

${member.name}님의 ${order.id}주문:
<ul>
<li>전체 가격 : ${order.totalPrice}</li>
</ul>
</body>
</html>