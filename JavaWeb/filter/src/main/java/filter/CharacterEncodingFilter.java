package filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
  //初始化并等待过滤对象出现
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("CharacterEncodingFilter初始化");
  }

  /*
    1. 过滤中的所有代码，在过滤特定请求的时候都会执行
    2. 必须要让过滤器继续执行 (因为filter可能不止一个,需要传递)
      chain.doFilter(request,response);
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html");

    System.out.println("CharacterEncodingFilter执行前....");
    chain.doFilter(request, response); //让我们的请求继续走，如果不写，程序到这里就被拦截停止！
    System.out.println("CharacterEncodingFilter执行后....");
  }

  //销毁：web服务器关闭的时候，过滤器会销毁
  @Override
  public void destroy() {
    System.out.println("CharacterEncodingFilter销毁");
  }
}
