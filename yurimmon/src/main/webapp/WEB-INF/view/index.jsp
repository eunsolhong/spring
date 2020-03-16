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


				<li>��û �Ķ���� ó�� :
					<ul>
						<li><a href="event/detail?id=1">event/detail?id=1</a>:
							HttpServletRequest�� �̿뤷�� �Ķ���� ���ϱ�, EventController.detail()</li>
						<li><a href="event/detail2?id=1">event/detail2?id=1</a>:
							@RequestParam�� �̿��� �Ķ���� ���ϱ�, EventController.detail2()</li>
						<li><a href="event/detail2">event/detail2</a>: @RequestParam
							�ʼ� �Ķ���� 400 ����, EventController.detail2()</li>
						<li><a href="search">search</a> : @RequestParam �ʼ� �ƴ� ����,
							SearchController.search()</li>
					</ul>
				</li>


				<li>Ŀ�ǵ� ��ü, @ModelAttribute:
					<ul>
						<li><a href="member/regist">/member/regist</a> : Ŀ�ǵ� ��ü,
							@ModelAttribute�� Ŀ�ǵ� ��ü �̸� ����, RegistrationController</li>
						<li><a href="acl/list">/acl/list</a> : Ŀ�ǵ� ��ü ����Ʈ ó��,
							AclController
							<ul>
								<li>�α��� ��� ���� �� , ����</li>
								<li>�Ǵ�, sample.xml �̳� SampleConfig.java ���� �ڵ鷯 ���ͼ��� ������ �ּ�
									ó�� �� ����</li>
							</ul></li>
						<li><a href="member/modify?mid=m1">/member/modify?mid=m1</a>
							: GET/POST���� ���� Ÿ�� Ŀ�ǵ尴ü ����ϱ�, MemberModificationController</li>
						<li><a href="event/list">/event/list</a> : @ModelAttribute��
							�̿��� �����, EventController.recommand()</li>
					</ul>
				</li>
				
				
				<li>��û ��� ��:
				<ul>
				<li><a href="header/simple">/header/simple</a> :
				@RequestHeader�� @CookiesValue, SimpleHeaderController.simple()</li>
				<li><a href="header/createauth">/header/createauth</a> :
				@CookieValue �׽�Ʈ�� ���� ��Ű ����, SimpleHeaderController.createAuth()</li>

				<li>�����̷�Ʈ : 
				<ul>
				<li><a href="header/createauth">/header/createauth</a> SimpleheaderController.createAuth()</li>


				<li>�� ����
				<ul>
				<li><a href="member/regist">/member/regist</a> :
				�� ����, &lt;spring:hasBindErrors name = "memberInfo" /&gt;�� �̿��� �����޼���, RegistrationController</li>
				<li><a href="auth/login">/auth/login</a> :
				@Valid �̿� �� ����, &lt;form:form commandName = "loginCommand"&gt;�� �̿��� �����޼���, �۷ι� �����޼���, LoginController</li>
				<li><a href="member/modify?mid=m2">/member/modify?mid=m2</a> :
				@Valid �� JSR3-3 �̿� �� ����, MemberModificationController</li>
			</ul>
		</li>
</body>
</html>