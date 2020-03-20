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

		<li>@RequestMapping, @PathVariavle;
			<ul>
				<li><a href="event/list">/event/list</a> : Model 예시,
					EventContoller.list()</li>
				<li><a href="event/list2">/event/list2</a> : ModelAndView 예시,
					EventController.list2()</li>
			</ul>
		</li>

		<li>@RequestMapping, @PathVariable :
			<ul>
				<li><a href="member/regist">/member/regist</a> : GET/POST 예시,
					RegistrationController</li>
				<li><a href="members">members</a> : @PathVariable 사용을 위한 목록 출력,
					MemberController.members()</li>
				<li><a href="members/m2">members/m2</a> : @PathVariable 사용을 위한
					목록 출력, MemberController.memberDetail()</li>
				<li><a href="members/m2/orders/1">members/m2/orders/1</a> :
					@PathVariable 사용을 위한 목록 출력, MemberController.memberOrderDetail()</li>
				<li><a href="members/m2/orders/1a">members/m2/orders/1a</a> :
					@PathVariable 400응답 예시, MemberController.memberOrderDetail()</li>
			</ul>
		</li>

		<li>요청 파라미터 처리 :
			<ul>
				<li><a href="event/detail?id=1">/event/detail?id=1</a> :
					HttpServletRequest을 이용한 파라미터 구하기, EventController.detail()</li>
				<li><a href="event/detail2?id=1">/event/detail2?id=1</a> :
					@RequestParam을 이용한 파라미터 구하기, EventController.detail2()</li>
				<li><a href="event/detail2">/event/detail2</a> : @RequstParam
					필수 파라미터 400 Error 처리방법(default~를 넣어서 해결?),
					EventController.detail2()</li>
				<li><a href="search">search</a> : @RequestParam 필수 아님 설정,
					SearchController.search()</li>
			</ul>
		</li>

		<li>커맨드 객체, @ModelAttribute :
			<ul>
				<li><a href="member/regist">member/regist</a> : 커맨드 객체,
					@ModelAttribute로 커맨드 객체 이름 지정, RegisterationController</li>
				<li><a href="acl/list">/acl/list</a> : 커맨드 객체 리스트 처리,
					AclController
					<ul>
						<li>로그인 기능 수행 후 실행</li>
						<li>또는, sample.xml or SampleConfig.java에서 핸들러 인터셉서 설정을 주석 처리
							후 실행
					</ul></li>
				<li><a href="member/modify?mid=m1">/member/modify?mid=m1</a> :
					GET/POST에서 동일 타입 커맨드 객체 사용하기, MemberModificationController</li>
				<li><a href="event/list">/event/list</a> :@ModelAttribute를 이용한
					공통 모델, EventController.recommend()</li>
			</ul>
		</li>
		<li>요청 헤더 값 :
			<ul>
				<li><a href="header/simple">/header/simple</a> :
					@RequestHeader와 @CookieValue, SimpleHeaderController.simple()</li>
				<li><a href="header/createAuth">/header/createAuth</a> :
					@CookieValue 테스트를 위한 쿠키 생성, SimpleHeaderController.createAuth()</li>
			</ul>
		</li>

		<li>리다이렉트 :
			<ul>
				<li><a href="header/createAuth">/header/createAuth</a> : 리다이렉트,
					SimpleHeaderController.createAuth()</li>
			</ul>
		</li>

		<li>값 검증 :
			<ul>
				<li><a href="member/regist">/member/regist</a> : 값 검증,
					&lt;spring:hasBindErrors name="memberInfo" /&gt;를 이용한 에러메시지
					RegistrationController</li>
				<li><a href="auth/login">/auth/login</a> : @Valid 이용 값 검증,
					&lt;form:form commentName="loginCommand"/&gt;를 이용한 에러메시지, 글로벌
					에러메시지, LoginController</li>
				<li><a href="member/modify?mid=m2">/member/modify?mid=m2</a> :
					@Valid 및 JSR303 이용 값 검증, MemberModificationController</li>
			</ul>
		</li>

		<li>값 변환 :
			<ul>
				<li><a href="member/regist">/member/regist</a> :
					@DateTimeFormat, RegistrationController/MemberRegistRequest</li>
				<li><a href="event/list">/event/list</a> : @InitBinde와
					CustomDateEditor, EventController.list()</li>

			</ul>
		</li>

		<li>HTTP 세션 :
			<ul>
				<li><a href="auth/login">/auth/login</a> : HttpServletRequest를
					통해 HttpSession사용, LoginController</li>
				<li><a href="auth/logout">/auth/logout</a> : HttpSession 직접 사용,
					LogoutController</li>
				<li><a href="newevent/step1">/newevent/step1</a> :
					@SessionAttributes 사용, EventCreateController</li>
			</ul>
		</li>

		<li>익셉션 처리 :
			<ul>
				<li><a href="cal/divide?op1=10&op2=0">/cal/divide&amp;op1=10&op2=0</a>
					: @ExecutionHandler, CalculatorController()</li>
				<li><a href="event/detail2">/event/detail2</a> :
					@ControllerAdvice 사용, CommonExceptionHandler. 설정(sample.xml,
					SampleConfig.java)에서 CommonExeceptionHandler 부분의 주석 해제 후</li>
				<li><a href="files/a111">/files/a111</a> : 익셉션 클래스에
					RequestStatus 사용, FileController.fileInfo() / NoFileInfoExecetion</li>
			</ul>
		</li>


		<li>requestMapping(Pattern 이용)
			<ul>
				<li><a href="files/a111">/files/a111</a> : 익셉션 클래스에 @ResponseStatus 사용, FileController.fileInfo()/NoFileInfoExcetion</li>
				<li><a href="files/aaa.download">/files/?*.download</a> :	</li>
				<li><a href="folders/aaa/bbb/ccc/files">/folders/**/files</a> :	</li>
				
			</ul>
		</li>
	</ul>
	
	<li>스프링 설정
		<ul>	
			<li><a href="index">/index</a> : 뷰 전용 컨트롤러</li>
			<li><a href="img/javalogo.jpg">/img/javalogo.jpg</a> : 정적 자원(위치 : WEB-INF/resources/javalogo.jpg)</li>
			
		</ul>
	</li>
	

</body>
</html>