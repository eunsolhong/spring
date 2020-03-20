package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Exception.MemberNotFoundException;
import Exception.NotMatchPasswordException;
import member.MemberInfo;
import member.MemberModRequest;
import service.MemberService;

@Controller
@RequestMapping("/member/modify")
public class MemberModificationController {

	private static final String MEMBER_MODIFICATION_FORM = "member/modificationForm";
	private static final String MEMBER_NOT_FOUND_VIEW = "member/memberNotFound";
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("modReq") MemberModRequest modReq, @RequestParam("mid") String memberId){
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if(mi == null){
			return MEMBER_NOT_FOUND_VIEW;
		}
		
		modReq.setId(mi.getId());
		modReq.setName(mi.getName());
		modReq.setEmail(mi.getEmail());
		modReq.setAllowNoti(mi.isAllowNoti());
		
		return MEMBER_MODIFICATION_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String modify(@Valid @ModelAttribute("modReq")MemberModRequest modReq, Errors errors){
		if(errors.hasErrors()){
			return MEMBER_MODIFICATION_FORM;
		}
		
		try{
			memberService.modifyMemberInfo(modReq);
			return "member/modified";
		}catch (NotMatchPasswordException e) {
			errors.rejectValue("currentPassword", "invalidPassword");
			return MEMBER_MODIFICATION_FORM;
		}catch(MemberNotFoundException e){
			return MEMBER_NOT_FOUND_VIEW;
		}
	}
	
	public void SetMemberService(MemberService memberService){
		this.memberService = memberService;
	}
}
