package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberInfo;
import member.OrderInfo;
import service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("/members")
	public String members(Model model){
		List<MemberInfo> members = memberService.getMembers();
		model.addAttribute("members",members);
		return "member/members";
	}
	
	@RequestMapping("/members/{memberId}")
	public String memberDetail(@PathVariable String memberId, Model model){
		//@PathVariable 레스트 방식으로 할 때 url을 실제 데이터로 이용이 가능하다.
		// /members/{memberId} = member/다음에 나오는 값이 memberId이다.
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if(mi == null){
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		return "member/memberDetail";
	}
	
	@RequestMapping("/members/{memberId}/orders")
	public String memberOrderas(@PathVariable ("memberId") String memberId, Model model){
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if(mi == null){
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		model.addAttribute("orders",getOrdersOfMember(memberId));
		return "member/memberOrders";
	}
	
	private List<OrderInfo> getOrdersOfMember(String memberId){
		return Arrays.asList(new OrderInfo(1L, 10000, memberId), new OrderInfo(2L, 15000, memberId));
	}
	
	@RequestMapping("/members/{memberId}/orders/{orderId}")
	public String memberOrderDetail(@PathVariable("memberId") String memberId, @PathVariable("orderId") Long orderId, Model model){
		// /members/{memberId}/orders/{orderId} 의 파라미터인 @PathVariable("orderId") Long orderId의 타입은 정수. 이 경우 문자가 들어와 타입이 달라진다면 400에러를 발생시킨다.
		model.addAttribute("member", memberService.getMemberInfo(memberId));
		model.addAttribute("order", new OrderInfo(orderId, orderId.intValue() * 5000 + 5000, memberId));
		return "member/memberOrderDetail";
	}
	
	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
}
