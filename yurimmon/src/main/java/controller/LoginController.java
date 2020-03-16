package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exception.AuthenticationException;
import service.Auth;
import service.Authenticator;
import service.LoginCommand;


@Controller
@RequestMapping("/auth/login")
public class LoginController {

	private static final String LOGIN_FORM = "auth/loginForm";
	
	@Autowired
	private Authenticator authenticator;
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand) {
		return LOGIN_FORM;
	}
	
	   @RequestMapping(method = RequestMethod.POST)
	   public String login(@Valid LoginCommand loginCommand, Errors errors, HttpServletRequest request) {
	      if (errors.hasErrors()) {
	         return LOGIN_FORM;
	      }

	      try {
	         Auth auth = authenticator.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
	         HttpSession session = request.getSession();
	         session.setAttribute("auth", auth);
	         return "redirect:/index.jsp";
	      } catch (AuthenticationException e) {
	         errors.reject("invalidIdOrPassword");
	         return LOGIN_FORM;
	      }
	   }
	   
	
	@InitBinder //webBinder에 의해서 LoginCommandValidator를 인젝션해준다
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
}
