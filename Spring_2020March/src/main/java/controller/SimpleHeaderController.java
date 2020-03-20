package controller;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleHeaderController {

	@RequestMapping("/header/simple")
	public String simple(
			@RequestHeader(value="Accept", defaultValue="text/html") String acceptType, 
			@CookieValue(value="auth", required=false) Integer authValue, Model model){
		//(value="auth", required=false)쿠키가 null이어도 오류를 내지 않는다.
		
		model.addAttribute("acceptType", acceptType);
		if(authValue != null){
			model.addAttribute("auth", authValue);
		}
		return "header/simpleValue";
	}
	
	@RequestMapping("/header/createAuth")
	public String createAuth(HttpServletResponse response, Model model){
		Random random = new Random();
		String authValue = Integer.toString(random.nextInt());
		response.addCookie(new Cookie("auth", authValue));	//auth를 키로 랜덤한 값이 들어간다.
		//return "redirect:simple";
		return "redirect:http://localhost:8090/Spring_2020March/index.jsp";
	}
}
