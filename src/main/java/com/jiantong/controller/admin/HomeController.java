package com.jiantong.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.jiantong.controller.admin.base.BaseController;

@Controller
@RequestMapping("/admin")
public class HomeController extends BaseController{
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		//后台获取国际化的信息  
		RequestContext requestContext = new RequestContext(request);  
		String message = requestContext.getMessage("message.title.welcome");
		System.out.println(message);
		String language = getLanguage(request);
		System.out.println(language);
		return "admin/home";
	}
	
	@RequestMapping(value = "/setLanguage", method = RequestMethod.GET)
	public String setSystemLanguage(HttpServletRequest request, Model model,
			@RequestParam(value = "lang", required = false, defaultValue = "zh_CN") String lang) {
		if (!model.containsAttribute("contentModel")) {
			if ("zh_CN".equals(lang)) {
				Locale locale = new Locale("zh", "CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			} else if ("en_US".equals(lang)) {
				Locale locale = new Locale("en", "US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			} else {
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
			}
		}
		return "admin/home";
	}
	
}
