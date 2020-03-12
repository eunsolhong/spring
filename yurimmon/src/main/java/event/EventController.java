package event;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/event") //프로젝트 명 뒤에 나오는 주소를 덧붙이는 것
public class EventController {

	private static final String REDIECT_EVENT_LIST = "redirect:/event/list";
	private EventService eventService;
	
	public EventController() {
		eventService = new EventService();
	}
	
	@RequestMapping("/list")
	public String list(SearchOption option,Model model) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventTypes", EventType.values());
		
		return "event/list";
	}
	
	@RequestMapping("/list2")
	//model과 view의 역할
	public ModelAndView list2(SearchOption option) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("event/list");
		modelView.addObject("eventList", eventList);
		modelView.addObject("eventTypes", EventType.values());
		return modelView;
	}
	
	
		
}
