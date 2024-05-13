package com.sample.commons.xss;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

/*
 * 요청에서 파라미터 및 헤더 값을 가져와서 XSS 공격에 취약한 문자열을 제거하거나 변조
 */
public class RequestWrapper extends HttpServletRequestWrapper {
	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	// 파라미터 값을 가져와서 XSS 공격에 취약한 문자열을 제거하거나 변조하여 반환
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}

		return encodedValues;
	}

	// 단일 파라미터 값을 가져와서 XSS 공격에 취약한 문자열을 제거하거나 변조하여 반환
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}

		return cleanXSS(value);
	}

	// 헤더 값을 가져와서 XSS 공격에 취약한 문자열을 제거하거나 변조하여 반환
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (value == null)
			return null;

		return cleanXSS(value);
	}

	// XSS 공격에 취약한 문자열을 제거하거나 변조하는 메서드
	private String cleanXSS(String value) {
		// XSS 공격에 취약한 문자열을 제거하거나 변조하는 과정 수행
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
}