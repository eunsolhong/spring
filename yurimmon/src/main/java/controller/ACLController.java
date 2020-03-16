package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.AclService;

@Controller
public class ACLController {
	
	@Autowired
	private AclService aclService;
	
	@RequestMapping("/acl/list")
	public String list(Model model) {
		model.addAttribute("aclList", aclService.getAclList());
		return "acl/aclList";
	}
	
	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}
	

}
