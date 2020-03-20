package controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import event.Event;
import event.EventType;
import event.SearchOption;

import service.EventService;

@Controller
@RequestMapping("/event") // 프로젝트 명 뒤에 나오는 주소를 덧붙이는 것
public class EventController {

	private static final String REDIECT_EVENT_LIST = "redirect:/event/list";
	private EventService eventService;

	public EventController() {
		eventService = new EventService();
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"),true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
		

	@ModelAttribute("recEventList")
	public List<Event> recommend(){
		return eventService.getRecommendedEventService();
	}

	@RequestMapping("/list")
	public String list(SearchOption option, Model model) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventTypes", EventType.values());

		return "event/list";
	}

	@RequestMapping("/list2")
	// model과 view의 역할
	public ModelAndView list2(SearchOption option) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("event/list");
		modelView.addObject("eventList", eventList);
		modelView.addObject("eventTypes", EventType.values());
		return modelView;
	}

	//request로 id를 받을 경우
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) throws IOException {
		String id = request.getParameter("id");
		if (id == null) {
			return REDIECT_EVENT_LIST;
		}
		Long eventId = null;
		try {
			eventId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return REDIECT_EVENT_LIST;
		}
		Event event = getEvent(eventId);
		if (event == null) {
			return REDIECT_EVENT_LIST;
		}
		model.addAttribute("event", event);
		return "event/detail";
	}

	private Event getEvent(Long eventId) {
		return eventService.getEvent(eventId);
	}
	
	//@RequestParam로 id의 값을 받을 경우
	@RequestMapping("/detail2")
	public String detail2(@RequestParam(value="id", required=false )long eventId, Model model){
		Event event = getEvent(eventId);
		if(event == null){
			return REDIECT_EVENT_LIST;
		}
		model.addAttribute("event", event);
		return "event/detail";
	}

}
