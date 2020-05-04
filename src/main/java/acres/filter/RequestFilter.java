package acres.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestFilter implements HandlerInterceptor{
	
	Logger log = Logger.getLogger(RequestFilter.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI() + request.getParameterNames());
		log.info("Time to receive request was: " + System.currentTimeMillis());
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI() + request.getParameterNames());
		log.info("Time to complete request was: " + System.currentTimeMillis());
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
