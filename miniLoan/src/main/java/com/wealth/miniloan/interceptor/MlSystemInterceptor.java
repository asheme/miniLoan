package com.wealth.miniloan.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MlSystemInterceptor extends HandlerInterceptorAdapter {
	// @Resource(name = "systemLoggerService")
		// private SystemLoggerService systemLoggerService;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
		 * (javax.servlet.http.HttpServletRequest,
		 * javax.servlet.http.HttpServletResponse, java.lang.Object)
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {

			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			// 后台session控制
			String[] noFilters = new String[] { "index.jsp", "toLogin.do",
					"logon.do", "sessionOut.do", "exit.do" };
			String uri = request.getRequestURI();

			if (!uri.endsWith("/miniloan/")) {
				boolean beFilter = true;
				for (String s : noFilters) {
					if (uri.indexOf(s) != -1) {
						beFilter = false;
						break;
					}
				}
				if (beFilter) {
					Subject currUser = SecurityUtils.getSubject();
					if (currUser != null) {
						Session session = currUser.getSession(false);
						Object obj = null;
						if (session != null)
							obj = session.getAttribute("user");
						
						if (null == obj) {
							// 未登录
							PrintWriter out = response.getWriter();
							StringBuilder builder = new StringBuilder();
							builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
							builder.append("window.top.location.href=\"");
							builder.append(request.getContextPath()+"/sessionOut.do");
							builder.append("\";</script>");
							out.print(builder.toString());
							out.close();
							return false;
						} 
					}
				}
			}

			return super.preHandle(request, response, handler);
		}
}
