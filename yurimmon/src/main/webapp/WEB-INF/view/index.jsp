<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<img src="./img/fox.jpg" height="250px">
	<ul>
		<li>Hello World!
			<ul>
				<li><a href="hello.do">/hello.do</a> : ������MVC �ϴ� �� ����
					HelloController.hello()
				<li><a href="hello-raw.do">/hello-raw.do</a> : void ���� Ÿ�� ��Ʈ�ѷ�
					�޼ҵ� HelloController.hello()
			</ul>
		</li>

		<li>�� :
			<ul>
				<li><a href="event/list">/event/list</a> : Model ����,
					EventContoller.list()</li>
				<li><a href="event/list2">/event/list2</a> : ModelAndView ����,
					EventController.list2()</li>
			</ul>
		</li>

		<li>@RequestMapping, @PathVariable
			<ul>
				<li><a href="member/regist">/member/regist</a> : GET/POST ����,
					RegistrationController</li>
				<li><a href="members">/members</a>: @PathVariable ��� ���� ��� ���,
					MemberController.member()</li>
				<li><a href="members/m2">/members/m2</a> : @PathVariable ��,
					MemberController.memberDetail()</li>
				<li><a href="members/m2/orders/1">/members/m2/orders/1</a> :
					@PathVariable ��, MemberController.memberOrderDetail()</li>
				<li><a href="members/m2/orders/1a">/members/m2/orders/1a</a> :
					@PathVariable 400���� ��, MemberController.memberOrderDetail()</li>
			</ul>
		</li>
	</ul>
</body>
</html>