package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chap08.member.MemberInfo;
import chap08.auth.Auth;
import chap08.ex.AuthenticationException;


@Component
public class Authenticator {
	
	@Autowired
	private MemberService memberService;
	
	// 기본 생성자 필수
	public Authenticator(){
		
	}
	
	public Authenticator(MemberService memberService){
		this.memberService=memberService;
	}
	
	public Auth authenticate(String email, String password){
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if(mi==null)
			throw new AuthenticationException();
		
		if(!mi.matchPassword(password))
			throw new AuthenticationException();
		
		return new Auth(mi.getId(),mi.getName());
	}

}
