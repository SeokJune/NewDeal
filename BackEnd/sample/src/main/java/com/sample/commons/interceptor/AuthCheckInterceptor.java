package com.sample.commons.interceptor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthCheckInterceptor implements HandlerInterceptor {
	// Logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 가져오기
		HttpSession session = request.getSession(false);

		// 세션 존재 여부 확인
		if (session != null) {
			// 요청 URI
			String requestUri = request.getRequestURI();
			// 경로가 루트인지 확인
			if ("/".equals(requestUri)) {
				// 루트에 접근할 경우 로그 남기고 루트로 리다이렉트
				logger.info("root path in");
				response.sendRedirect(request.getContextPath() + "/");
				response.flushBuffer();
				return false;
			}
			
			// 세션에 진증 정보가 있는지 확인
			Object authInfo = session.getAttribute("usrMnuAtrt");
			if (authInfo != null) {
				return true;
			}
		}
		
		// HTTP 헤더에서 axios 요청인지 확인
		String axiosHeader = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(axiosHeader)) {
			response.sendError(901);
		}

		return true;
	}
}
