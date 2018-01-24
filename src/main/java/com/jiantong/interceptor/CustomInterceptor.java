package com.jiantong.interceptor;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.jiantong.bean.ColumnTree;
import com.jiantong.service.ColumnService;

public class CustomInterceptor implements HandlerInterceptor {
	
    private final static String MENU_SESSION = "menuList";
	
	private final static String CURRENT_PATH_SESSION = "currentPath";
	
	private final static String CHANNEL_ZH = "zh";
	
	private final static String CHANNEL_EN = "en";
	
	private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
	
	@Autowired
	private ColumnService columnService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("preHandle executed...");
		HttpSession session = request.getSession();
		List<ColumnTree> dataList = (List<ColumnTree>)session.getAttribute(MENU_SESSION);
		if(null == dataList) {
			Integer channel = getChannel(request);
			List<ColumnTree> columnTreeList = columnService.getShowColumnTree(channel);
			session.setAttribute(MENU_SESSION, columnTreeList);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("postHandle executed...");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("afterCompletion executed...");
	}
	
	/**
	 * 获取频道
	 * @param request
	 * @return
	 */
	private Integer getChannel(HttpServletRequest request) {
		String language = LocaleContextHolder.getLocale().getLanguage();
		HttpSession session = request.getSession();
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
