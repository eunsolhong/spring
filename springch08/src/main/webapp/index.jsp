<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>메시지 출력:
			<ul>
				<li><a href="auth/login">/auth/login</a>:&lt;spring:message&gt;
					태그,loginForm.jsp, LoginController</li>
			</ul>
		</li>
		<li>폼 및 에러 메시지:
			<ul>
				<li><a href="member/regist">/member/regist</a>:폼, 에러 메시지,
					registrationForm.jsp, RegistrationController</li>
			</ul>
		</li>

		<li>커스텀 뷰 :
			<ul>
				<li><a href="file/1">/file/1</a> : 파일다운로드, DownloadView,
					DownloadController, download()</li>
				<li><a href="pagestat/rank">/pagestat/rank</a>: 엑셀 다운로드,
					PageRankView, PageRankStatController.pageRank()</li>
				<li><a href="pagestat/rankreport">/pagestat/rankreport</a> :
					PDF 다운로드, PageReportView, PageRankStatController.pageRankReport()</li>
			</ul>
		</li>


		<li>로케일 변경 :
			<ul>
				<li><a href="changeLanguage?lang=en">/changeLanguage?lang=en</a>
					: LocalResolver 예, LocalChangeController.change(), lang 파라미터로 변경</li>
				<li><a href="changeLanguage?lang=ko">/changeLanguage?lang=ko</a>
					: LocalResolver 예, LocalChangeController.change(), lang 파라미터로 변경</li>
				<li><a href="auth/login?lang=ko">/auth/login?lang=en</a> :
					LocalChangeInterceptor 예, lang으로 변경 후, lang 없이 확인</li>
			</ul>
		</li>

	</ul>
</body>
</html>
