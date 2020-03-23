<%@ page language="java" contentType="text/html; charset=EUC-KR"	pageEncoding="EUC-KR"%>
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
				<li><a href="hello.do">/hello.do</a> : ������MVC �ϴ� �� ���� HelloController.hello()
				<li><a href="hello-raw.do">/hello-raw.do</a> : void ���� Ÿ�� ��Ʈ�ѷ� 	�޼ҵ� HelloController.hello()
			</ul>
		</li>

		<li>@RequestMapping, @PathVariavle;
			<ul>
				<li><a href="event/list">/event/list</a> : Model ����, EventContoller.list()</li>
				<li><a href="event/list2">/event/list2</a> : ModelAndView ����, EventController.list2()</li>
			</ul>
		</li>
		
		<li>@RequestMapping, @PathVariable : 
			<ul>
			<li><a href="member/regist">/member/regist</a> : GET/POST ����, RegistrationController</li>
			<li><a href="members">members</a> : @PathVariable ����� ���� ��� ���, MemberController.members()</li>
			<li><a href="members/m2">members/m2</a> :  @PathVariable ����� ���� ��� ���, MemberController.memberDetail()</li>
			<li><a href="members/m2/orders/1">members/m2/orders/1</a> : @PathVariable ����� ���� ��� ���, MemberController.memberOrderDetail()</li>
			<li><a href="members/m2/orders/1a">members/m2/orders/1a</a> : @PathVariable 400���� ����, MemberController.memberOrderDetail()</li>
			</ul>
		</li>
		
		<li>��û �Ķ���� ó�� : 
			<ul>
				<li><a href="event/detail?id=1">/event/detail?id=1</a> : HttpServletRequest�� �̿��� �Ķ���� ���ϱ�, EventController.detail()</li>
				<li><a href="event/detail2?id=1">/event/detail2?id=1</a> : @RequestParam�� �̿��� �Ķ���� ���ϱ�, EventController.detail2()</li>
				<li><a href="event/detail2">/event/detail2</a> : @RequstParam �ʼ� �Ķ���� 400 Error ó�����(default~�� �־ �ذ�?), EventController.detail2()</li>
				<li><a href="search">search</a> : @RequestParam �ʼ� �ƴ� ����, SearchController.search()</li>
			</ul>
		</li>
		
		<li>Ŀ�ǵ� ��ü, @ModelAttribute :
			<ul>
				<li><a href="member/regist">member/regist</a> : Ŀ�ǵ� ��ü, @ModelAttribute�� Ŀ�ǵ� ��ü �̸� ����, RegisterationController</li>
				<li><a href="acl/list">/acl/list</a> : Ŀ�ǵ� ��ü ����Ʈ ó��, AclController
					<ul>
						<li>�α��� ��� ���� �� ����</li>
						<li>�Ǵ�, sample.xml or SampleConfig.java���� �ڵ鷯 ���ͼ��� ������ �ּ� ó�� �� ����
					</ul>
				</li>
				<li><a href="member/modify?mid=m1">/member/modify?mid=m1</a> : GET/POST���� ���� Ÿ�� Ŀ�ǵ� ��ü ����ϱ�, MemberModificationController</li>
				<li><a href="event/list">/event/list</a> :@ModelAttribute�� �̿��� ���� ��, EventController.recommend()</li>
			</ul>
		</li>
		<li>��û ��� �� :
			<ul>
				<li><a href="header/simple">/header/simple</a> : @RequestHeader�� @CookieValue, SimpleHeaderController.simple()</li>
				<li><a href="header/createAuth">/header/createAuth</a> : @CookieValue �׽�Ʈ�� ���� ��Ű ����, SimpleHeaderController.createAuth()</li>
			</ul>
		</li>
		
		<li>�����̷�Ʈ : 
			<ul>
				<li><a href="header/createAuth">/header/createAuth</a> : �����̷�Ʈ, SimpleHeaderController.createAuth()</li>
			</ul>
		</li>
		
		<li>�� ���� : 
			<ul>
				<li><a href="member/regist">/member/regist</a> : �� ����, &lt;spring:hasBindErrors name="memberInfo" /&gt;�� �̿��� �����޽��� RegistrationController </li>
				<li><a href="auth/login">/auth/login</a> : @Valid �̿� �� ����, &lt;form:form commentName="loginCommand"/&gt;�� �̿��� �����޽���, �۷ι� �����޽���, LoginController</li>	
				<li><a href="member/modify?mid=m2">/member/modify?mid=m2</a> : @Valid �� JSR303 �̿� �� ����, MemberModificationController</li>
			</ul>
		</li>
	</ul>
</body>
</html>