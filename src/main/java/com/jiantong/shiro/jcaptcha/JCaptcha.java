package com.jiantong.shiro.jcaptcha;

import com.octo.captcha.service.CaptchaServiceException;
import javax.servlet.http.HttpServletRequest;

public class JCaptcha {
	
	public static final CustomManageableImageCaptchaService captchaService = CustomManageableImageCaptchaService.getInstance();

	public static boolean validateResponse(HttpServletRequest request, String userCaptchaResponse) {
		if (request.getSession(false) == null) {
			return false;
		}
		boolean validated = false;
		try {
			String id = request.getSession().getId();
			validated = captchaService.validateResponseForID(id, userCaptchaResponse).booleanValue();
		} catch (CaptchaServiceException e) {
			e.printStackTrace();
		}
		return validated;
	}

	public static boolean hasCaptcha(HttpServletRequest request, String userCaptchaResponse) {
		if (request.getSession(false) == null) {
			return false;
		}
		boolean validated = false;
		try {
			String id = request.getSession().getId();
			validated = captchaService.hasCapcha(id, userCaptchaResponse);
		} catch (CaptchaServiceException e) {
			e.printStackTrace();
		}
		return validated;
	}

}
