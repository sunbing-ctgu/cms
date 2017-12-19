package com.jiantong.controller.admin.base;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class BaseController {

	/**
	 * 获取Session
	 * @param request
	 * @return
	 */
	protected HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session;
	}
	
	/**
	 * 获取Language
	 * @param request
	 */
	protected String getLanguage(HttpServletRequest request) {
		HttpSession session = getSession(request);
		Locale locale = (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if(null != locale) {
			return locale.getLanguage();
		}else {
			return LocaleContextHolder.getLocale().getLanguage();
		}
	}
}
