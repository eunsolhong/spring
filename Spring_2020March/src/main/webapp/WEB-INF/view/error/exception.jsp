<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>에러 발생</title>
</head>
<body>
	작업 처리 도중 문제가 발생했습니다.
	<%=exception%>
</body>
</html>