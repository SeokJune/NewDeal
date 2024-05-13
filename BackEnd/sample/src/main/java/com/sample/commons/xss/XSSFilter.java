package com.sample.commons.xss;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/*
 * XSS (Cross-Site Scripting) 공격을 방지하기 위해 사용되는 필터 클래스
 * RequestWrapper 클래스를 사용하여 요청을 래핑하여 처리
 */
public class XSSFilter implements Filter {
	// 필터 설정
	public FilterConfig filterConfig;

	// 필터 초기화
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	// 필터 제거
	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	// 요청을 가로채어 XSS 공격을 방지하는 처리 수행
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
	}
}
