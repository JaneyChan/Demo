package com.blog.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 7574909648122864129L;
	protected Map<String,Object> session;

	/**
	 * 得到session对象
	 * @return
	 */
	public ServletContext getSession() {
		return ServletActionContext.getServletContext();
	}
	/**
	 * 得到request对象
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 得到response对象
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
