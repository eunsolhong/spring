<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원상세</title>
</head>
<body>
Name : ${member.name}<br>
ID : ${member.id}<br>
Password : ${member.password}<br>
Address : ${member.address.address1} ${member.address.address2} 우편번호(${member.address.zipcode})<br>
Email : ${member.email}<br>
AllowNoti : ${member.allowNoti}<br>

</body>
</html>