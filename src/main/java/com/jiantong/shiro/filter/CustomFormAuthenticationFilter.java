package com.jiantong.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiantong.entity.User;
import com.jiantong.service.UserService;

/**
 * 
 * <p>Title:CustomFormAuthenticationFilter</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2017年10月24日 下午3:20:06
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserService userService;
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub
		if(request.getAttribute(getFailureKeyAttribute()) != null) {
            return true;
        }
		return super.onAccessDenied(request, response, mappedValue);
	}
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean contextRelative = true;
    	Session session = subject.getSession();
    	if(session != null){
    		//会话过期 attribute 为空，重新设置。
    		User user = (User) session.getAttribute("user");
    		if(null == user){
    			user = this.userService.getUserByName(subject.getPrincipal().toString());
    			session.setAttribute("user", user);
    		}
    	}
    
    	String successUrl = this.getSuccessUrl();
    	WebUtils.issueRedirect(request, response, successUrl, null, contextRelative);
		return false;
	}
}
