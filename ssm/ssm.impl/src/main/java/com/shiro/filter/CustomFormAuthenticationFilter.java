package com.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * Form表单登陆拦截器
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {


	/*
	 * 认证成功跳转到指定地址
	 * @param token
	 * @param subject
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
/*	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

		WebUtils.getAndClearSavedRequest(request);
		WebUtils.redirectToSavedRequest(request,response,"/index");

		return false;
	}*/
}
