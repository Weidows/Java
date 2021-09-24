package com.weidows.filter;

import com.weidows.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/jsp/*")
public class SysFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest rq = (HttpServletRequest) request;
    HttpServletResponse rp = (HttpServletResponse) response;
    //过滤器，从session中获取用户
    User userSession = (User) rq.getSession().getAttribute("userSession");
    if (userSession == null) {
      rp.sendRedirect("/error.jsp");
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
  }
}
