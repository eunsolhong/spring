package service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import Exception.AuthenticationException;
import auth.Auth;
import member.MemberInfo;

@Component
public class Authenticator {

	@Autowired	//MemberService�� �̹� Bean���� �����Ǿ��ִ�.
	private MemberService memberService;
	
	public Authenticator(){	}

	public Authenticator(MemberService memberService){
		this.memberService = memberService;
	}
	
	public Auth authenticate(String email, String password){
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if(mi == null) throw new AuthenticationException();
		if(!mi.matchPassword(password)) throw new AuthenticationException();
		
		return new Auth(mi.getId(), mi.getName());
	}
}
