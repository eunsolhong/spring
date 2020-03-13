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
	public String members(Model model) {
		List<MemberInfo> members = memberService.getMembers();
		model.addAttribute("members",members);
		return "member/members";
	}
	
	@RequestMapping("/members/{memberId}")
	public String memberDetail(@PathVariable String memberId, Model model) {
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if(mi == null) {
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		return "member/memberDetail";
	}
	
	@RequestMapping("/members/{memberId}/orders")
	public String memberOrders(@PathVariable("memberId") String memberId, Model model) {
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if(mi == null) {
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		model.addAttribute("orders", getOrderOfMember(memberId));
		return "member/memberOrders";
	}
	
	private List<OrderInfo> getOrderOfMember(String memberId){
		return Arrays.asList(new OrderInfo(1L, 10000, memberId), new OrderInfo(2L, 15000, memberId));
	}
	
	@RequestMapping("/members/{memberId}/orders/{orderId}")
	public String memberOrderDetail(@PathVariable("memberId")String memberId, @PathVariable("orderId") Long orderId, Model model) {
		model.addAttribute("member", memberService.getMemberInfo(memberId));
		model.addAttribute("order", new OrderInfo(orderId, orderId.intValue() * 5000 + 5000, memberId));
		return "member/memberOrderDetail";
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}


// 이 부분에서 알아야 할것
// @PathVariable : rest방식으로 할때 url을 실제데이터로 사용가능
// members/다음에 뭔가 오면 파라미터쪽에도 같이 온다.

