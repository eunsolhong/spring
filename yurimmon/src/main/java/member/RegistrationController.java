package member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {

	private static final String MEMBER_REGISTRATION_FROM = "member/registrationFrom";
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String from(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq) {
		//@ModelAttribute
		return MEMBER_REGISTRATION_FROM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq, BindingResult bindingResult) {
		//@ModelAttribute memberInfo하는 이름으로 MemberRegistRequest 객체가 날라간다. / BindingResult는 에러체크
		new MemberRegistValidator().validate(memRegReq, bindingResult);
		if(bindingResult.hasErrors()) {
			//비어있는 값이 있다면 다시 전 페이지로 돌아간다.
			return MEMBER_REGISTRATION_FROM;
		}
		memberService.registNewMember(memRegReq);
		return "member/registered";
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
}
