package demo.filter;

import demo.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;

    Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
    if (attribute == null) {
      resp.sendRedirect("/demo/failed.jsp");
    }

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}
