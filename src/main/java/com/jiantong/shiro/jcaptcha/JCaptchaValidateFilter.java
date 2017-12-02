package com.jiantong.shiro.jcaptcha;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class JCaptchaValidateFilter extends AccessControlFilter {
	// 是否开启验证码支持
	private boolean jcaptchaEbabled = true;
	// 前台提交的验证码参数名
	private String jcaptchaParam = "jcaptchaCode";
	// 验证码验证失败后存储到的属性名
	private String failureKeyAttribute = "shiroLoginFailure"; 

	public boolean isJcaptchaEbabled() {
		return jcaptchaEbabled;
	}

	public void setJcaptchaEbabled(boolean jcaptchaEbabled) {
		this.jcaptchaEbabled = jcaptchaEbabled;
	}

	public String getJcaptchaParam() {
		return jcaptchaParam;
	}

	public void setJcaptchaParam(String jcaptchaParam) {
		this.jcaptchaParam = jcaptchaParam;
	}

	public String getFailureKeyAttribute() {
		return failureKeyAttribute;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		//1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
        request.setAttribute("jcaptchaEbabled", jcaptchaEbabled);
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        //2、判断验证码是否禁用 或不是表单提交（允许访问）
        if (jcaptchaEbabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
            return true;
        }
        //3、此时是表单提交，验证验证码是否正确
        boolean validateFlag = JCaptcha.validateResponse(httpServletRequest, httpServletRequest.getParameter(jcaptchaParam));
        return validateFlag;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute(failureKeyAttribute, "jCaptcha.error");
		return true;
	}

}
