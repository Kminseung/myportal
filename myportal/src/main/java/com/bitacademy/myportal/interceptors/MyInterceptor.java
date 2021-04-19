package com.bitacademy.myportal.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// spring-servlet.xml에 인터셉터로 등록해야 함
// 인터페이스 구현 방식 인터셉터
public class MyInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	// preHandle : 컨트롤러 호출 이전에 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) // 뒤쪽에 연결된 인터셉터 or 컨트롤러
			throws Exception {
		logger.debug("MyInterceptor.preHandle");
		
		// return이 false면 실행을 중단하고 뒤에 연결된 인터셉터 or 컨트롤러로 전달되지 않음
		return true;
	}

	// postHandle : 컨트롤러 호출 이후에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor.postHandle");
	}

	// afterCompletion : 뷰 렌더링까지 완료된 상태에서 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor.afterCompletion");
	}

}
