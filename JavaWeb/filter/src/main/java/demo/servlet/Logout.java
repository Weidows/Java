package demo.servlet;

import demo.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    Object attribute = session.getAttribute(Constants.USER_SESSION);

    /*
      频繁操作session连接会影响性能,通过attribute间接验证登录信息
      通过设置或移除 USER_SESSION 属性来验证是否登录
      存在一个Bug: 在注销状态通过浏览器的后退,可以返回登陆成功的页面(且不存在USER_SESSION)
     */
    if (attribute != null) {
      session.removeAttribute(Constants.USER_SESSION);
      resp.sendRedirect("/demo/index.jsp");
    }
  }
}
