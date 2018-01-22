package com.jiantong.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class BaseHandler {

	public final static int SUCCESS = 1;
	
	public final static int FAIL = -1;
	
	public final static String MENU_SESSION = "menuList";
	
	public final static String CURRENT_PATH_SESSION = "currentPath";
	
	public final static String CHANNEL_ZH = "zh";
	
	public final static String CHANNEL_EN = "en";
	
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
	
	/**
	 * 获取频道
	 * @param request
	 * @return
	 */
	protected Integer getChannel(HttpServletRequest request) {
		String language = LocaleContextHolder.getLocale().getLanguage();
		HttpSession session = getSession(request);
		Locale locale = (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if(null != locale) {
			language = locale.getLanguage();
		}
		if(CHANNEL_ZH.equals(language)) {
			return 0;
		}else {
			return 1;
		}
	}
}
