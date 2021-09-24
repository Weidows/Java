package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloCookie extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setCharacterEncoding("utf-8");
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    // 获取客户端请求中携带的cookie
    Cookie[] cookies = req.getCookies();
    boolean isFirst = true; // 标志是否是第一次访问

    writer.println("你上一次访问时间是: ");
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("LastLoginTime")) {
        isFirst = false;
        writer.println(cookie.getValue());
      }
    }
    if (isFirst) {
      writer.println("这次是第一次访问.");
    }

    // 响应携带cookie返回给客户端
    Cookie lastLoginTime = new Cookie("LastLoginTime", System.currentTimeMillis() + "");// 非字符串+"" = 字符串
    resp.addCookie(lastLoginTime);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
