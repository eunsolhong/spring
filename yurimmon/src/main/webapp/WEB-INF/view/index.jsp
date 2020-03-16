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


				<li>요청 파라미터 처리 :
					<ul>
						<li><a href="event/detail?id=1">event/detail?id=1</a>:
							HttpServletRequest을 이용ㅇ한 파라미터 구하기, EventController.detail()</li>
						<li><a href="event/detail2?id=1">event/detail2?id=1</a>:
							@RequestParam을 이용한 파라미터 구하기, EventController.detail2()</li>
						<li><a href="event/detail2">event/detail2</a>: @RequestParam
							필수 파라미터 400 에러, EventController.detail2()</li>
						<li><a href="search">search</a> : @RequestParam 필수 아님 설정,
							SearchController.search()</li>
					</ul>
				</li>


				<li>커맨드 객체, @ModelAttribute:
					<ul>
						<li><a href="member/regist">/member/regist</a> : 커맨드 객체,
							@ModelAttribute로 커맨드 객체 이름 지정, RegistrationController</li>
						<li><a href="acl/list">/acl/list</a> : 커맨드 객체 리스트 처리,
							AclController
							<ul>
								<li>로그인 기능 수행 후 , 실행</li>
								<li>또는, sample.xml 이나 SampleConfig.java 에서 핸들러 인터셉터 설정을 주석
									처리 후 실행</li>
							</ul></li>
						<li><a href="member/modify?mid=m1">/member/modify?mid=m1</a>
							: GET/POST에서 동일 타입 커맨드객체 사용하기, MemberModificationController</li>
						<li><a href="event/list">/event/list</a> : @ModelAttribute를
							이용한 공통모델, EventController.recommand()</li>
					</ul>
				</li>
				
				
				<li>요청 헤더 값:
				<ul>
				<li><a href="header/simple">/header/simple</a> :
				@RequestHeader와 @CookiesValue, SimpleHeaderController.simple()</li>
				<li><a href="header/createauth">/header/createauth</a> :
				@CookieValue 테스트를 위한 쿠키 생성, SimpleHeaderController.createAuth()</li>

				<li>리다이렉트 : 
				<ul>
				<li><a href="header/createauth">/header/createauth</a> SimpleheaderController.createAuth()</li>


				<li>값 검증
				<ul>
				<li><a href="member/regist">/member/regist</a> :
				값 검증, &lt;spring:hasBindErrors name = "memberInfo" /&gt;를 이용한 에러메세지, RegistrationController</li>
				<li><a href="auth/login">/auth/login</a> :
				@Valid 이용 값 검증, &lt;form:form commandName = "loginCommand"&gt;를 이용한 에러메세지, 글로벌 에러메세지, LoginController</li>
				<li><a href="member/modify?mid=m2">/member/modify?mid=m2</a> :
				@Valid 및 JSR3-3 이용 값 검증, MemberModificationController</li>
			</ul>
		</li>
</body>
</html>