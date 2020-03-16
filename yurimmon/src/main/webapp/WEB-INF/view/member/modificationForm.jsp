<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>회원 정보 수정</title>
</head>
<body>

<form:form commandName="modReq">
   <input type="hidden" name="id" value="${modReq.id }"/>
   <label for="email">E-mail</label> : 
      <input type="text" name="email" id="email" value="${modReq.email }"/>
   <form:errors path="email"/><br>
   
   <label for="email">Name</label> : 
      <input type="text" name="name" id="name" value="${modReq.name }"/>
   <form:errors path="name"/><br>
   
   <label for="email">Address1</label> : 
      <input type="text" name="address.address1" id="address1" value="${modReq.address.address1 }"/>
   <form:errors path="address.address1"/><br>
   
   <label for="email">Address2</label> : 
      <input type="text" name="address.address2" id="address2" value="${modReq.address.address2 }"/>
   <form:errors path="address.address2"/><br>
   
   <label for="Zipcode">Zipcode</label> : 
      <input type="text" name="address.zipcode" id="zipcode" value="${modReq.address.zipcode }"/>
   <form:errors path="address.zipcode"/><br>
   
   <label>
      <input type="checkbox" name="allowNoti" value="true" ${modReq.allowNoti ? 'checked' : '' }/>
      Email수신
   </label>   <br>
      
   <label for="currentPassword">NowPassword</label> : 
   <input type="password" name="currentPassword" id="currentPassword"/>
   <form:errors path="currentPassword"/><br>
   <input type="submit" value="Modify"/>   
</form:form>
</body>
</html>