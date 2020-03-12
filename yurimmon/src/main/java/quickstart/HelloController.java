package quickstart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	//return type = String
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("greeting", "안녕하세요:D");
		return "hello";
	}
	//return type = X
	@RequestMapping("/hello-raw.do")
	public void hello(HttpServletResponse response) throws IOException{
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("안녕하세요:P");
		writer.flush();
	}
}