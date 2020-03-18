package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import event.EventForm;
import member.EventFormStep1Validator;

@Controller
@SessionAttributes("eventForm")
// 이컨트롤러 내에서 데이터의 리퀘스팅하는 모든게 eventForm에 영향을 받고있음
//eventForm이 없으면 새로운 eventForm을 리턴함
//필드를 폼에서 해당되는 오브젝트를 셋필드네임에 집어넣음
public class EventCreationController {

	private static final String EVENT_CREATION_STEP1= "event/creationStep1";
	private static final String EVENT_CREATION_STEP2= "event/creationStep2";
	private static final String EVENT_CREATION_STEP3= "event/creationStep3";
	private static final String EVENT_CREATION_DONE= "event/creationDone";
	
	@ModelAttribute("eventForm")
	public EventForm formData() {
		return new EventForm();
	}
	
	@RequestMapping("/newevent/step1")
	public String step1() {
		return EVENT_CREATION_STEP1;
	}
	
	@RequestMapping(value = "/newevnet/step2", method = RequestMethod.POST)
	public String step2(@ModelAttribute("eventForm") EventForm formData, BindingResult result) {
		new EventFormStep1Validator().validate(formData, result);
		//모델어트리뷰트로 입력받은폼을 두번째로 날리는거
		if(result.hasErrors()) 
			return EVENT_CREATION_STEP1;
		return EVENT_CREATION_STEP2;
	}
	
	@RequestMapping(value = "/newevent/step2", method = RequestMethod.GET)
	public String step2FromStep3(@ModelAttribute("eventFrom") EventForm formData) {
		return EVENT_CREATION_STEP2;
	}
	
	@RequestMapping(value = "/newevent/step3", method = RequestMethod.POST)
	public String step3(@ModelAttribute("eventForm") EventForm formData, BindingResult result) {
		ValidationUtils.rejectIfEmpty(result, "target", "required");
		if(result.hasErrors())
			return EVENT_CREATION_STEP2;
		return EVENT_CREATION_STEP3;
	}
	
	@RequestMapping(value = "/newevet/done", method = RequestMethod.POST)
	public String done(@ModelAttribute("eventForm") EventForm formData, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return EVENT_CREATION_DONE;
	}
}
