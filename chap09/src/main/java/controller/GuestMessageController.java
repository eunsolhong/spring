package controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import guest.GuestMessage;
import guest.GuestMessageList;
import guest.GuestMessageList2;

@Controller	
public class GuestMessageController {

	@RequestMapping(value = "/guestmessage/list.xml")
	@ResponseBody
	public GuestMessageList listXml() {
		return getMessageList();
	}
	
	@RequestMapping(value = "/guestmessage/post.xml", method = RequestMethod.POST)
	@ResponseBody
	public GuestMessageList postXml(@RequestBody GuestMessageList messageList) {
		
		System.out.println("========" + messageList.getMessages());
		
		return messageList;
	}
	
	private GuestMessageList getMessageList() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage(1, "메세지", new Date()),
				new GuestMessage(2, "메세지2", new Date())
				);
		
		return new GuestMessageList(messages);
	}
	
	@RequestMapping(value = "/guestmessage/list.json")
	@ResponseBody
	public GuestMessageList2 listJson() {
		return getMessageList2();
	}
	
	private GuestMessageList2 getMessageList2() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage(1, "메세지", new Date()),
				new GuestMessage(2, "메세지2", new Date())
				);
		
		return new GuestMessageList2(messages);
	}
}
