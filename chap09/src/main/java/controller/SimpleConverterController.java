package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {

	@RequestMapping(method = RequestMethod.GET)
	public String simpleForm(){
		return "mc/simple";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody	//폼태그로 보낸 값들을 ResponseBody로 받아서 뷰페이지로 보여준다.
	public String simple(@RequestBody String body){
		return body;
	}
}
