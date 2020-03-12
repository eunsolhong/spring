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
				<li><a href="hello.do">/hello.do</a> : 스프링MVC 일단 해 보기
					HelloController.hello()
				<li><a href="hello-raw.do">/hello-raw.do</a> : void 리턴 타입 컨트롤러
					메소드 HelloController.hello()
			</ul>
		</li>

		<li>모델 :
			<ul>
				<li><a href="event/list">/event/list</a> : Model 예시,
					EventContoller.list()</li>
				<li><a href="event/list2">/event/list2</a> : ModelAndView 예시,
					EventController.list2()</li>
			</ul>
		</li>

		<li>@RequestMapping, @PathVariable
			<ul>
				<li><a href="member/regist">/member/regist</a> : GET/POST 예시,
					RegistrationController</li>
				<li><a href="members">/members</a>: @PathVariable 사용 위한 목록 출력,
					MemberController.member()</li>
				<li><a href="members/m2">/members/m2</a> : @PathVariable 예,
					MemberController.memberDetail()</li>
				<li><a href="members/m2/orders/1">/members/m2/orders/1</a> :
					@PathVariable 예, MemberController.memberOrderDetail()</li>
				<li><a href="members/m2/orders/1a">/members/m2/orders/1a</a> :
					@PathVariable 400응답 예, MemberController.memberOrderDetail()</li>
			</ul>
		</li>
	</ul>
</body>
</html>