package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component("measuringInterceptor")
public class MeasuringInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("MI: preHandler()");
		request.setAttribute("mi.beginTime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		System.out.println("MI: afterCompletion()");
		Long beginTime = (Long) request.getAttribute("mi.beginTime");
		long endTime = System.currentTimeMillis();
		System.out.println(request.getRequestURI() + " 실행시간: " + (endTime - beginTime));
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("MI: postHandle()");
	}
	
}
