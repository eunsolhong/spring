package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.MemberRegistRequest;
import member.MemberRegistValidator;
import service.MemberService;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {

	private static final String MEMBER_REGISTRATION_FROM = "member/registrationFrom";
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String from(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq) {
		//@ModelAttribute memberInfo��� �̸��� ��ü�� ���� �޾ƿ� ä���.
		return MEMBER_REGISTRATION_FROM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq, BindingResult bindingResult) {
		//@ModelAttribute memberInfo�ϴ� �̸����� MemberRegistRequest ��ü�� ���󰣴�. / BindingResult�� ����üũ
		new MemberRegistValidator().validate(memRegReq, bindingResult);
		if(bindingResult.hasErrors()) {										//(Map�� Ű���� ���� value�� �ִ°��� Ȯ��)
			//����ִ� ���� �ִٸ� �ٽ� �� �������� ���ư���.
			return MEMBER_REGISTRATION_FROM;
		}
		memberService.registNewMember(memRegReq);	//if���� �ɸ��� ������ ��ü�� �־�� ���� ������Ʈ�� ������.
		return "member/registered";
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
}
