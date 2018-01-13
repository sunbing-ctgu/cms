package com.jiantong.shiro.jcaptcha;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

public class CustomManageableImageCaptchaService extends DefaultManageableImageCaptchaService {

	private static CustomManageableImageCaptchaService instance;
	
	private CustomManageableImageCaptchaService () {
		super(new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000, 75000);
	}
	
	public static synchronized CustomManageableImageCaptchaService getInstance() {
		if(null == instance) {
			instance = new CustomManageableImageCaptchaService();
		}
		return instance;
	}
	
	public boolean hasCapcha(String id, String userCaptchaResponse) {
		return store.getCaptcha(id).validateResponse(userCaptchaResponse);
	}
	
}
