package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("Spring_2020March")
public class CommonExeceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleExeption(){
		return "error/commonException";
	}
}
